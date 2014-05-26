package net.therap.config;

import net.therap.db.entity.common.Provider;
import net.therap.site.HostUtils;
import net.therap.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Calendar;
import java.util.StringTokenizer;

/**
 * @author masum
 */
public class FormIdGeneratorBean implements FormIdGenerator {

    private static final Logger log = LoggerFactory.getLogger(FormIdGeneratorBean.class);

    public static final String TEST_PREFIX = "T";
    public static final int BASE_YEAR = 2004;

    private static final String[] symbolPool = new String[]{
            "2", "3", "4", "5", "6", "7", "8", "9",
            "A", "B", "C", "D", "E", "F", "G", "H",
            "J", "K", "L", "M", "N", "P", "Q", "R",
            "S", "T", "U", "V", "W", "X", "Y", "Z"
    };

    /* The last millisecond used by genFormIdSeq */
    private int lastMillis = 0;
    private int lastSecond = 0;

    /* Explicitly mentioning it although it's the default. We need WRITE lock. */
    @Override
    public String generate(Provider provider, String formType, boolean testMode) {
        checkFormTypeLength(formType);
        String prefix = getPrefix(provider);
        String seq = nextSequence(); // the sequence
        String main = formType + "-" + prefix + "-" + seq;

        return getFormId(main, testMode);
    }

    /* Explicitly mentioning it although it's the default. We need WRITE lock. */
    @Override
    public String generate(String formType, boolean testMode) {
        checkFormTypeLength(formType);
        String seq = nextSequence(); // the sequence
        String main = formType + "-" + seq;

        return getFormId(main, testMode);
    }

    /**
     * Limiting formType length to 7 as already two module (IDFEXTN and RESHAB)
     * is using, but it is recommended to keep it within 5.
     */
    private void checkFormTypeLength(String formType) {
        if (StringUtils.isNotEmpty(formType) && formType.length() > 7) {
            throw new IllegalArgumentException("Form Type is limited to 7 character. It is better to keep it within 5.");
        }
    }

    private String getFormId(String main, boolean testMode) {
        if (testMode) {
            main = TEST_PREFIX + main;
        }

        String formId = main + calculateCheckDigit(main);

        log.debug("Generated formId: {}", formId);

        return formId;
    }

    private String getPrefix(Provider provider) {
        String state = (provider.getState() != null)
                ? provider.getState().toUpperCase()
                : provider.getCountry().getCode().toUpperCase();
        String providerCode = provider.getCode().toUpperCase();

        /* Use the first word of provider code, words are separated with space or hyphen */

        StringTokenizer st = new StringTokenizer(providerCode, " -");
        String codeStart = st.nextToken(); // sure we will get one

        /* Limit max length of provider code to 5 */
        if (codeStart.length() > 5) {
            codeStart = codeStart.substring(0, 5);
        }

        return codeStart + state;
    }

    private String nextSequence() {
        Calendar cal = Calendar.getInstance();
        String hostName = HostUtils.getHostName();

        int y = cal.get(Calendar.YEAR) - BASE_YEAR;
        int m = cal.get(Calendar.MONTH) + 1; // In java January is 0
        int d = cal.get(Calendar.DAY_OF_MONTH);    // starts with 1
        int s = cal.get(Calendar.HOUR_OF_DAY) * 3600
                + cal.get(Calendar.MINUTE) * 60
                + cal.get(Calendar.SECOND);
        int millis = cal.get(Calendar.MILLISECOND);
        int hostHash = Math.abs(hostName.hashCode()) % (32 * 32 * 32);  // Generate 3 digits at max

        /*
         * Make sure we give out a different millis than the last one
         * if we are on the same second.
         */

        /*
         * BUG NOTE 1: There was a serious bug here.  If we get called more than twice in the same milli second,
         * lastMillis will be more than millis and the millis value would be a repeat of a previous value!
         *
         * BUG NOTE 2: If the method was called too many times in a milli second, it caused a duplicate ID. This is
         * because millis value is converted to a base 32 number and then truncated to two digits. This is fixed
         * in core-services on Jan 18, 2012 by Masum.
         */
        if (s <= lastSecond) {
            if (s < lastSecond) {
                s = lastSecond;
            }
            if (millis <= lastMillis) {
                millis = lastMillis + 1;
                if (millis >= 1024) {
                    // There are 86400 seconds/day. The seconds value is converted to base 32 and truncated to 4 digits.
                    // This gives a max of about 1 million. It's unlikely that our "s" will wrap around.
                    s++;
                    millis = 0;
                }
            }
        }

        lastSecond = s;
        lastMillis = millis;

        String y32 = base32(y, 0);
        String m32 = base32(m, 0);
        String d32 = base32(d, 0);
        String s32 = base32(s, 4);
        String millis32 = base32(millis, 2);
        String hostHash32 = base32(hostHash, 0);        // max 3 digits

        return y32 + m32 + d32 + s32 + millis32 + hostHash32;
    }

    /**
     * Convert a base 10 integer to base32 string representation.
     *
     * @param n     The number to convert.
     * @param width Truncate to this width. 0 means no truncation.
     * @return The base32 number.
     */
    private String base32(int n, int width) {
        StringBuilder val = new StringBuilder(10);
        int r;

        while (n > 0) {
            r = n % 32;
            n = n / 32;
            val.append(symbolPool[r]);
        }

        val.reverse();

        if (width == 0)
            return val.toString();

        StringBuilder v2 = new StringBuilder(10);
        for (int len = val.length(); len < width; len++) {
            v2.append(symbolPool[0]);
        }
        v2.append(val);

        return v2.toString();
    }

    private String calculateCheckDigit(String formId) {
        char[] chars = formId.toCharArray();
        char hyphen = '-';

        int total = 0;
        int pos = 1;
        for (char c : chars) {
            if (c == hyphen) continue;

            total += (pos * Character.getNumericValue(c));
            pos++;
        }

        int check = total % 32;
        String cs = base32(check, 0);

        return cs;
    }
}

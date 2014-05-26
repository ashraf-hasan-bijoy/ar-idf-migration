package net.therap.config;

import net.therap.db.entity.common.Provider;

/**
 * Generates form IDs. Code is mostly copied from the therap main project, except a bug is fixed where duplicate
 * form IDs were generated.
 *
 * @author masum
 */
public interface FormIdGenerator {

    String generate(Provider provider, String formType, boolean testMode);

    String generate(String formType, boolean testMode);
}

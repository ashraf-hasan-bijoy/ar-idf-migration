package net.therap.util;

import net.therap.db.entity.common.Country;
import net.therap.db.entity.common.Provider;
import net.therap.service.therap.TherapDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


/**
 * Created by ashraf on 5/28/14.
 */
@Component
public class TherapCommonDataProvider {

    @Value("${provider.code}")
    private String code;

    @Autowired
    private TherapDataService dataService;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Provider getActiveProvider(){
        return dataService.getProvider(code);
    }

    public Country getCountry() {
        return dataService.getCountry();
    }
}

package net.therap.config;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * @author ashraf
 * @since 5/15/14
 */
@Configuration
public class DbConfig {
    @Bean(name = "dataSource")
    public DataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("oracle.jdbc.OracleDriver");
        driverManagerDataSource.setUrl(System.getProperty("url"));
        driverManagerDataSource.setUsername(System.getProperty("userName"));
        driverManagerDataSource.setPassword(System.getProperty("password"));
        return driverManagerDataSource;
    }
}

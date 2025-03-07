package dio.api_swagger.Security;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ConfigurationProperties(prefix = "security.config")
public class SecurityConfig {
    private  String PREFIX;
    private  String KEY;
    private  String EXPIRATION;

    public String getPREFIX() {
        return PREFIX;
    }

    public void setPREFIX(String PREFIX) {
        this.PREFIX = PREFIX;
    }

    public String getKEY() {
        return KEY;
    }

    public void setKEY(String KEY) {
        this.KEY = KEY;
    }

    public String getEXPIRATION() {
        return EXPIRATION;
    }

    public void setEXPIRATION(String EXPIRATION) {
        this.EXPIRATION = EXPIRATION;
    }
}

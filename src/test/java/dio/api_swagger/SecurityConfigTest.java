package dio.api_swagger;


import static org.junit.jupiter.api.Assertions.assertEquals;

import dio.api_swagger.Security.SecurityConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SecurityConfigTest {

    @Autowired
    private SecurityConfig securityConfig;

    @Test
    void testConfigLoad() {
        assertEquals("Bearer", securityConfig.getPREFIX());
        assertEquals("RINjs8F75EV173WmzCXELTA1Bg6RZUQ6OmJ+lxZsrKsyxY9k5m7riPGlhfc5zaZve4BS52NycLUjt918LcbZuw==",securityConfig.getKEY());
        assertEquals("3600000", securityConfig.getEXPIRATION());
    }
}


package com.cts.management.configuration;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {CorsConfiguration.class})
@ExtendWith(SpringExtension.class)
class CorsConfigurationTest {
    @Autowired
    private CorsConfiguration corsConfiguration;

    /**
     * Method under test: {@link CorsConfiguration#corsConfigurer()}
     */
    @Test
    void testCorsConfigurer() {
        // TODO: Complete this test.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by corsConfigurer()
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        corsConfiguration.corsConfigurer();
    }
}


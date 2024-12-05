package com.ahmadsedighi.cloud;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Ahmad R. Seddighi (ahmadseddighi@yahoo.com)
 * Date: 05/12/2024
 * Time: 10:42
 */
@ConfigurationProperties(prefix = "polar")
public class PolarProperties {
    private String greeting;

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }
}

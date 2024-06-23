package org.syantovich.hometask38bootinit.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "app")
public class AppProperties {
    private String key;
    private String profileName;
    private String version;

    public void setVersion(String version) {
        this.version = version;
    }

    public String getVersion() {
        return version;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getKey() {
        return key;
    }

    public String getProfileName() {
        return profileName;
    }
}

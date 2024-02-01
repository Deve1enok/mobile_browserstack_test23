package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:resources/mobile.properties"
})
public interface BrowserStackConfig extends Config {

    @Key("user")
    @DefaultValue("deveenok_1kNgLJ")
    String getUser();

    @Key("key")
    @DefaultValue("qSMpqV7mxWaSZo3T54EF")
    String getKey();

    @Key("baseUrl")
    @DefaultValue("http://hub.browserstack.com/wd/hub")
    String getBaseUrl();

    @Key("app")
    @DefaultValue("bs://sample.app")
    String getApp();

    @Key("device")
    @DefaultValue("Google Pixel 3")
    String getDevice();

    @Key("osVersion")
    @DefaultValue("9.0")
    String getOsVersion();

    @Key("project")
    @DefaultValue("First Java Project")
    String getProject();

    @Key("build")
    @DefaultValue("browserstack-build-1")
    String getBuild();

    @Key("name")
    @DefaultValue("first_test")
    String getName();
}

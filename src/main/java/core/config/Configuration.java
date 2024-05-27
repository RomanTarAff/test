package core.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:test.properties"})
public interface Configuration extends Config {

    @Key("execution")
    String execution();

    @Key("headless")
    Boolean headless();

    @Key("url")
    String url();

    @Key("apiUrl")
    String apiUrl();

    @Key("loginUrl")
    String loginUrl();

    @Key("grid.url")
    String gridUrl();

    @Key("grid.port")
    String gridPort();
}

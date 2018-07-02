package de.fusion.deluxeenchantments.config;

public interface ConfigAdapterInterface {


    ConfigManager build();

    ConfigManager reload();

    ConfigWriter setPath(String path);

    ConfigReader getPath(String path);


}

package com.ede.client.configuration.prop;


/**
 * @author WalkCat
 * @version 0.1
 * Interface created for get <b>URL</b> in String data for get connection with database
 */
public interface Config {

    /**
     * Method getUrl() return String url which can used to connection with database
     * @return method return String which contains url to database. URL taken from dbConfig.properties
     * @exeption FileNotFoundException
     * */
    String getUrl();
}

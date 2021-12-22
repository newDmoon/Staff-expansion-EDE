package com.ede.client.configuration.prop;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


/**
 * Class ConfigDb created for implementation interface Config. Class used Singleton pattern.
 * @author WalkCat
 * @version 0.1
 * */
public class ConfigDb implements Config{


    /**
     * filed which contains current status of singleton object
     * */
    private static ConfigDb config;

    /**
     * private constructor without arguments of ConfigDb class
     * */
    private ConfigDb() {

    }

    /**
     * Instance method which return current object, but if equals null return new created object
     * @return ConfigDb
     * */
    public static ConfigDb getInstance(){
        if(config!=null){
            return config;
        }else{
            return new ConfigDb();
        }
    }

    /**
     * Override method getUrl() from Config interface.
     * @return String
     * @exception FileNotFoundException
     * @exception IOException
     * */
    @Override
    public String getUrl() {
        Properties properties = new Properties();
        try(FileInputStream fileInputStream = new FileInputStream("D:\\Учеба\\Staff-expansion-EDE\\src\\main\\resources\\dbConfig.properties")){
            properties.load(fileInputStream);
            return  properties.getProperty("db.url");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

package me.qihao;

import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;

import java.io.IOException;

public class LogInitializer {

    public static void init() {
        try {
            ClassLoader classLoader = App.class.getClassLoader();
            ConfigurationSource source = new ConfigurationSource(classLoader.getResourceAsStream("conf/log/log4j2.xml"));
            Configurator.initialize(null, source);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

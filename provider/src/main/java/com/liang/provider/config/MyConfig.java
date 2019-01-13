package com.liang.provider.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
@ConfigurationProperties(prefix = "config")
public class MyConfig {


    private Tomcat tomcat = new Tomcat();



    public static class Tomcat{

        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }


    public Tomcat getTomcat() {
        return tomcat;
    }

    public void setTomcat(Tomcat tomcat) {
        this.tomcat = tomcat;
    }
}

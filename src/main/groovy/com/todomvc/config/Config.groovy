package com.todomvc.config

import org.aeonbits.owner.ConfigFactory

class Config {

    static EnvConfig getEnvConfig() {
        ConfigFactory.create(EnvConfig.class,
                [env: System.getProperty('env')])
    }
}

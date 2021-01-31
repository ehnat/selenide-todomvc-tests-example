package com.todomvc.config

import org.aeonbits.owner.Config
import org.aeonbits.owner.Config.Key
import org.aeonbits.owner.Config.Sources

@Sources('classpath:env/env.properties')
interface EnvConfig extends Config {

    @Key('${env}.baseUrl')
    String getBaseUrl()
}

package com.babelgroup.helloworld.practicaSiniestros.config;

import com.babelgroup.helloworld.practicaSiniestros.aseguradoras.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class AseguradorasConfig {

    @Bean
    public Map<String, Aseguradora> aseguradoras() {
        Map<String, Aseguradora> aseguradoras = new HashMap<>();
        aseguradoras.put("Mutua Madrileña", new AseguradoraMutuaMadrileña());
        aseguradoras.put("Allianz", new AseguradoraAllianz());
        aseguradoras.put("Mapfre", new AseguradoraMapfre());
        aseguradoras.put("General", new AseguradoraImpl());


        return aseguradoras;
    }
}
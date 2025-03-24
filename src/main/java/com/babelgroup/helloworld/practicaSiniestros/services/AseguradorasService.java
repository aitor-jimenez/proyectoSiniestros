package com.babelgroup.helloworld.practicaSiniestros.services;

import com.babelgroup.helloworld.practicaSiniestros.aseguradoras.Aseguradora;
import com.babelgroup.helloworld.practicaSiniestros.siniestros.Siniestro;

public interface AseguradorasService {
    void elegirAseguradora();
    void procesarSiniestro(Siniestro siniestro, Aseguradora aseguradora);
}

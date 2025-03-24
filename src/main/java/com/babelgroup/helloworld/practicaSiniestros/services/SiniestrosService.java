package com.babelgroup.helloworld.practicaSiniestros.services;

import com.babelgroup.helloworld.practicaSiniestros.siniestros.Siniestro;

import java.util.List;

public interface SiniestrosService {
    void addSiniestro(Siniestro siniestro);
    List<Siniestro> getSiniestros();
    Siniestro solicitarDatosSiniestro();
}

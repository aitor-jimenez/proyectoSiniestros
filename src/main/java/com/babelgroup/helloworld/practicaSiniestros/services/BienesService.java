package com.babelgroup.helloworld.practicaSiniestros.services;

import com.babelgroup.helloworld.practicaSiniestros.bienes.Bien;
import com.babelgroup.helloworld.practicaSiniestros.iomanager.IOManager;

import java.util.List;

public interface BienesService {
    void addBien(Bien bien);
    List<Bien> getBienes();
    Bien solicitarDatosBien(IOManager ioManager);
}

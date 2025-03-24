package com.babelgroup.helloworld.practicaSiniestros.siniestros;

import com.babelgroup.helloworld.practicaSiniestros.bienes.Bien;

import java.util.Date;

public interface Siniestro {
    Bien getBienAfectado();
    Date getFechaSiniestro();
}

package com.babelgroup.helloworld.practicaSiniestros.siniestros;

import com.babelgroup.helloworld.practicaSiniestros.bienes.Bien;

import java.util.Date;

public class SiniestroImpl implements Siniestro {

    private Bien bienAfectado;
    private Date fechaSiniestro;

    public SiniestroImpl(Bien bienAfectado, Date fechaSiniestro) {
        this.bienAfectado = bienAfectado;
        this.fechaSiniestro = fechaSiniestro;
    }

    public Bien getBienAfectado() {
        return this.bienAfectado;
    }

    public Date getFechaSiniestro() {
        return this.fechaSiniestro;
    }

}

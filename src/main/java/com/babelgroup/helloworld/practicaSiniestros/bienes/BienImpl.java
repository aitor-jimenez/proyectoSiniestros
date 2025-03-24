package com.babelgroup.helloworld.practicaSiniestros.bienes;

import java.util.Date;

public class BienImpl implements Bien {

    private String nombre;
    private double valor;
    private int amortizacion;
    private Date fechaAdquisicion;

    public BienImpl(String nombre, double valor, int amortizacion, Date fechaAdquisicion) {
        this.nombre = nombre;
        this.valor = valor;
        this.amortizacion = amortizacion;
        this.fechaAdquisicion = fechaAdquisicion;
    }

    public String getNombre() {
        return this.nombre;
    }

    public double getValor() {
        return this.valor;
    }

    public int getAmortizacion() {
        return this.amortizacion;
    }

    public Date getFechaAdquisicion() {
        return this.fechaAdquisicion;
    }

}

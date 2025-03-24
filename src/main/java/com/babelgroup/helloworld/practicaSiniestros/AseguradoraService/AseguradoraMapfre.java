package com.babelgroup.helloworld.practicaSiniestros.AseguradoraService;

import com.babelgroup.helloworld.practicaSiniestros.bienes.Bien;
import com.babelgroup.helloworld.practicaSiniestros.siniestros.Siniestro;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class AseguradoraMapfre implements Aseguradora {
    private static final double VALOR_RESIDUAL = 0.17;

    public double calcular(Siniestro siniestro) {
        Bien bien = siniestro.getBienAfectado();
        double valorInicial = bien.getValor();
        double tasaDepreciacion = 1.0 / bien.getAmortizacion();
        int years = calculateYears(bien.getFechaAdquisicion(), siniestro.getFechaSiniestro());
        double valorDepreciado = valorInicial - (valorInicial * tasaDepreciacion * years);

        return Math.max(valorDepreciado, valorInicial * VALOR_RESIDUAL);

    }

    private int calculateYears(Date compra, Date siniestro) {
        long diferenciams = siniestro.getTime() - compra.getTime();
        return (int) TimeUnit.MILLISECONDS.toDays(diferenciams) / 365;
    }
}

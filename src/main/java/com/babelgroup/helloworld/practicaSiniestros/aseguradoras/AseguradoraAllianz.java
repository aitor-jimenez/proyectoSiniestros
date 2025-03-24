package com.babelgroup.helloworld.practicaSiniestros.AseguradoraService;

import com.babelgroup.helloworld.practicaSiniestros.bienes.Bien;
import com.babelgroup.helloworld.practicaSiniestros.siniestros.Siniestro;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

@Component
public class AseguradoraAllianz implements Aseguradora {

    private static final double BONIFICACION_VALOR = 1.05;

    public double calcular(Siniestro siniestro) {
        Bien bienAfectado = siniestro.getBienAfectado();
        double valorDepreciado = bienAfectado.getValor() * BONIFICACION_VALOR;

        for(int i = 0; i < this.calcularAniosDepreciacion(bienAfectado.getFechaAdquisicion(), siniestro.getFechaSiniestro()); i++) {
            valorDepreciado *= 1.0 - 1.0 / (double) bienAfectado.getAmortizacion();
        }

        return valorDepreciado;
    }

    private int calcularAniosDepreciacion(Date fechaAdquisicion, Date fechaSiniestro) {
        LocalDate localAdquisicion = fechaAdquisicion.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate localSiniestro = fechaSiniestro.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return Period.between(localAdquisicion, localSiniestro).getYears() + 1;
    }

}

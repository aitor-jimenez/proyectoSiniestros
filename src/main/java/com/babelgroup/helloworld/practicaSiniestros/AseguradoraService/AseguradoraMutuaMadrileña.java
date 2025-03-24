package com.babelgroup.helloworld.practicaSiniestros.AseguradoraService;
import com.babelgroup.helloworld.practicaSiniestros.siniestros.Siniestro;
import java.time.temporal.ChronoUnit;

public class AseguradoraMutuaMadrileña implements Aseguradora{
    //Para la mutua el valor residual será del 10%

    private static final double VALOR_RESIDUAL = 0.1;

    @Override
    public double calcular(Siniestro siniestro) {

        //Valor inicial del bien afectado
        double valorInicial = siniestro.getBienAfectado().getValor();

        // Para la Mutua, se duplica el tiempo de amortización
        int añosAmortizacion = siniestro.getBienAfectado().getAmortizacion() * 2;

        // Cálculo de años transcurridos desde la compra (como número real)
        double diasTranscurridos = ChronoUnit.DAYS.between(siniestro.getBienAfectado().getFechaAdquisicion(),
                siniestro.getFechaSiniestro());
        double añosTranscurridos = diasTranscurridos / 365.0;

        // El primer año (año 0) no hay depreciación
        if (añosTranscurridos < 1.0) {
            return valorInicial;
        }

        // Tasa de depreciación anual (con el tiempo de amortización duplicado)
        double tasaDepreciacionAnual = 1.0 / añosAmortizacion;

        // Cálculo del valor con depreciación lineal acumulada
        double valorActual = valorInicial * Math.pow((1.0 - tasaDepreciacionAnual), añosTranscurridos);


        // Aplicar valor residual mínimo del 10%
        double valorResidual = valorInicial * VALOR_RESIDUAL;
        return Math.max(valorActual, valorResidual);
    }

}

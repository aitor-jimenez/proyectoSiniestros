package com.babelgroup.helloworld.practicaSiniestros.services;

import com.babelgroup.helloworld.practicaSiniestros.aseguradoras.Aseguradora;
import com.babelgroup.helloworld.practicaSiniestros.siniestros.Siniestro;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

@Service
public class AseguradorasServiceImpl implements AseguradorasService {

    private SiniestrosService siniestrosService;
    private Map<String, Aseguradora> aseguradoras;

    public AseguradorasServiceImpl(SiniestrosService siniestrosService, Map<String, Aseguradora> aseguradoras) {
        this.siniestrosService = siniestrosService;
        this.aseguradoras = aseguradoras;
    }

    @Override
    public void elegirAseguradora() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Elija una aseguradora (por nombre):");
        for (String nombre : aseguradoras.keySet()) {
            System.out.println(nombre);
        }
        String choice = scanner.nextLine();
        Aseguradora aseguradoraElegida = aseguradoras.get(choice);
        if (aseguradoraElegida == null) {
            throw new IllegalArgumentException("Aseguradora no encontrada");
        }

        System.out.println("Elija un siniestro:");
        for (int i = 0; i < siniestrosService.getSiniestros().size(); i++) {
            System.out.println((i + 1) + ". " + siniestrosService.getSiniestros().get(i).getBienAfectado().getNombre());
        }
        int siniestroChoice = scanner.nextInt();
        Siniestro siniestroElegido = siniestrosService.getSiniestros().get(siniestroChoice - 1);

        procesarSiniestro(siniestroElegido, aseguradoraElegida);
    }


    @Override
    public void procesarSiniestro(Siniestro siniestro, Aseguradora aseguradora) {
        double resultado = aseguradora.calcular(siniestro);
        System.out.println("El resultado del cálculo es: " + resultado);
    }
}
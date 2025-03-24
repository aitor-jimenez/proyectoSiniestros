package com.babelgroup.helloworld.practicaSiniestros;

import com.babelgroup.helloworld.practicaSiniestros.bienes.Bien;
import com.babelgroup.helloworld.practicaSiniestros.iomanager.IOManager;
import com.babelgroup.helloworld.practicaSiniestros.services.AseguradorasService;
import com.babelgroup.helloworld.practicaSiniestros.services.BienesService;
import com.babelgroup.helloworld.practicaSiniestros.services.SiniestrosService;
import com.babelgroup.helloworld.practicaSiniestros.siniestros.Siniestro;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

    private final BienesService bienesService;
    private final SiniestrosService siniestrosService;
    private final AseguradorasService aseguradorasService;
    private IOManager ioManager;

    public Runner(IOManager iomanager, BienesService bienesService, SiniestrosService siniestrosService, AseguradorasService aseguradorasService) {
        this.aseguradorasService = aseguradorasService;
        this.bienesService = bienesService;
        this.siniestrosService = siniestrosService;
        this.ioManager = iomanager;
    }

    @Override
    public void run(String... args) throws Exception {
        String opcion;
        boolean salir = false;

        this.ioManager.write("Bienvenido al sistema gestor de siniestros.");
        while (!salir) {
            this.ioManager.write("Escoge una opción:\n" +
                    "1. Añadir bien.\n" +
                    "2. Añadir siniestro.\n" +
                    "3. Calcular indemnización.\n" +
                    "4. Salir.");
            opcion = this.ioManager.read();

            switch (opcion) {
                case "1":
                    Bien bien = this.bienesService.solicitarDatosBien(this.ioManager);
                    this.bienesService.addBien(bien);
                    break;
                case "2":
                    Siniestro siniestro = this.siniestrosService.solicitarDatosSiniestro();
                    this.siniestrosService.addSiniestro(siniestro);
                    break;
                case "3":
                    this.aseguradorasService.elegirAseguradora();
                    break;
                case "4":
                    salir = true;
                    break;
                default:
                    this.ioManager.write("Opción no válida.");
                    break;
            }
        }

        this.ioManager.write("Finalizando...");
    }

}

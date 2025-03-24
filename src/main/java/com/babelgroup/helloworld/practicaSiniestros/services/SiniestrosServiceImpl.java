package com.babelgroup.helloworld.practicaSiniestros.services;

import com.babelgroup.helloworld.practicaSiniestros.bienes.Bien;
import com.babelgroup.helloworld.practicaSiniestros.iomanager.IOManager;
import com.babelgroup.helloworld.practicaSiniestros.siniestros.Siniestro;
import com.babelgroup.helloworld.practicaSiniestros.siniestros.SiniestroImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class SiniestrosServiceImpl implements SiniestrosService {
    @Autowired
    IOManager ioManager;

    @Autowired
    BienesService bienesService;

    private List<Siniestro> siniestros = new ArrayList<>();

    public void addSiniestro(Siniestro siniestro) {
        this.siniestros.add(siniestro);
    }

    public List<Siniestro> getSiniestros() {
        return this.siniestros;
    }

    public Siniestro solicitarDatosSiniestro() {
        Bien bienAdd = null;
        ioManager.write("Escoge un bien:");
        for(Bien bien: bienesService.getBienes()) {
            ioManager.write(bien.getNombre());
        }
        String opcion = ioManager.read();
        for(Bien bien: bienesService.getBienes()) {
            if(bien.getNombre().equals(opcion))
                bienAdd = bien;
        }
        ioManager.write("Introduce la fecha del siniestro (YYYY-MM-DD): ");
        Date fechaAdquisicion = Date.from(LocalDate.parse(ioManager.read()).atStartOfDay(ZoneId.systemDefault()).toInstant());
        return new SiniestroImpl(bienAdd, fechaAdquisicion);
    }
}

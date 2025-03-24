package com.babelgroup.helloworld.practicaSiniestros.services;

import com.babelgroup.helloworld.practicaSiniestros.bienes.Bien;
import com.babelgroup.helloworld.practicaSiniestros.bienes.BienImpl;
import com.babelgroup.helloworld.practicaSiniestros.iomanager.IOManager;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
public class BienesServiceImpl implements BienesService {

    private List<Bien> bienes;

    public BienesServiceImpl(List<Bien> bienes) {
        this.bienes = bienes;
    }

    public void addBien(Bien bien) {
        this.bienes.add(bien);
    }

    public List<Bien> getBienes() {
        return this.bienes;
    }

    public Bien solicitarDatosBien(IOManager ioManager) {
        ioManager.write("Introduce el nombre del bien: ");
        String nombre = ioManager.read();
        ioManager.write("Introduce el valor del bien: ");
        double valor = Double.parseDouble(ioManager.read());
        ioManager.write("Introduce la fecha de adquisición del bien (YYYY-MM-DD): ");
        Date fechaAdquisicion = Date.from(LocalDate.parse(ioManager.read()).atStartOfDay(ZoneId.systemDefault()).toInstant());
        ioManager.write("Introduce el tiempo de amortización del bien: ");
        int amortizacion = Integer.parseInt(ioManager.read());
        return new BienImpl(nombre, valor, amortizacion, fechaAdquisicion);
    }
}

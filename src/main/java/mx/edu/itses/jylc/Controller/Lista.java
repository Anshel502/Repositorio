/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.edu.itses.jylc.Controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.edu.itses.jylc.Model.Vuelo;

/**
 *
 * @author josue
 */
public class Lista extends Thread {
    private List<Vuelo> vuelos;
    private File archivo;

    public Lista(List<Vuelo> vuelos, File archivo) {
        this.vuelos = vuelos;
        this.archivo = archivo;
    }

    @Override
    public void run() {
        List<Vuelo> nuevos = new ArrayList<>();
        try (BufferedReader b = new BufferedReader(new FileReader(archivo))) {
            b.readLine(); 
            String l;
            while ((l = b.readLine()) != null) {
                String[] info = l.split(",");
                if (info.length == 5) { 
                    try {
                        Vuelo vuelo = new Vuelo(
                            info[0].trim(), info[1].trim(),info[2].trim(), info[3].trim(),info[4].trim()
                        );
                        nuevos.add(vuelo);
                    } catch (ParseException | NumberFormatException e) {
                        System.err.println("Error al parsear línea: " + l);
                        e.printStackTrace();
                    }
                } else {
                    System.err.println("Línea con formato inválido: " + l);
                }
            }
            synchronized (vuelos) {
                vuelos.clear();
                vuelos.addAll(nuevos);
            }
            Thread.sleep(30000); 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}



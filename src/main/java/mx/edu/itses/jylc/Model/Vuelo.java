package mx.edu.itses.jylc.Model;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 *
 * @author josue
 */
public class Vuelo {
    private String nombre;
    private String origen;
    private String destino;
    private Date fechaCompleta;
    private int numPasajeros;

    private static final String ARCHIVO_VUELOS = "vuelos.txt";
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("EEE dd MMM yyyy HH:mm");
    private static List<Vuelo> vuelos = new ArrayList<>();

    
    public Vuelo(String nombre, String origen, String destino, String fechaCompleta, String numPasajeros) throws ParseException {
        this.nombre = nombre;
        this.origen = origen;
        this.destino = destino;
        this.fechaCompleta = DATE_FORMAT.parse(fechaCompleta); 
        this.numPasajeros = Integer.parseInt(numPasajeros); 
    }


    public Vuelo() {
        vuelos = new ArrayList<>();
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Date getFechaCompleta() {
        return fechaCompleta;
    }

    public void setFechaCompleta(String fechaCompleta) throws ParseException {
        this.fechaCompleta = DATE_FORMAT.parse(fechaCompleta);
    }

    public int getNumPasajeros() {
        return numPasajeros;
    }

    public void setNumPasajeros(int numPasajeros) {
        this.numPasajeros = numPasajeros;
    }

    
    public static List<Vuelo> getVuelos() {
        return vuelos;
    }

    public static void setVuelos(List<Vuelo> vuelos) {
        Vuelo.vuelos = vuelos;
    }

    public void agregarVuelo(Vuelo vuelo) {
        vuelos.add(vuelo);
        GuardarVuelo();
    }

    public void GuardarVuelo() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(ARCHIVO_VUELOS))) {
            for (Vuelo v : vuelos) {
                writer.println(v);
            }
        } catch (IOException e) {
            System.out.println("Error al guardar el vuelo: " + e.getMessage());
        }
    }

    
    @Override
    public String toString() {
        return "Vuelo{" +
                "nombre='" + nombre + '\'' +
                ", origen='" + origen + '\'' +
                ", destino='" + destino + '\'' +
                ", fechaCompleta=" + DATE_FORMAT.format(fechaCompleta) +
                ", numPasajeros=" + numPasajeros +
                '}';
    }
}
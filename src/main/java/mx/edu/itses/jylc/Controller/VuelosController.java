package mx.edu.itses.jylc.Controller;

import mx.edu.itses.jylc.Model.Vuelo;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author josue
 */
public class VuelosController {

    private static List<Vuelo> vuelos = new ArrayList<>();

    public static List<Vuelo> obtenerVuelos() {
        return vuelos;
    }

  
    public static void agregarVuelo(Vuelo vuelo) {
      
        vuelos.add(vuelo);
        System.out.println("Vuelo agregado: " + vuelo);
    }

    public static void inicializarVuelos() {
        vuelos = new ArrayList<>();
    }


    public static void mostrarVuelos() {
        if (vuelos.isEmpty()) {
            System.out.println("No hay vuelos registrados aun.");
        } else {
            System.out.println("Lista de vuelos:");
            for (Vuelo vuelo : vuelos) {
                System.out.println(vuelo);
            }
        }
    }
    
    
    
    
}
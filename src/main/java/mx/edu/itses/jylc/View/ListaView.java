/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.edu.itses.jylc.View;
import javax.swing.JOptionPane;
import mx.edu.itses.jylc.Controller.VuelosController;
import mx.edu.itses.jylc.Model.Vuelo;

/**
 *
 * @author josue
 */
public class ListaView {
    
public void   CRUDEVuelos( ){
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            new  CRUDEVuelos().setVisible(true);
            }
        });
    }
//Crear 
    public void createVuelo(String nombre, String origen, String destino, String fecha_llegada, String num_pasajeros){
    java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CREATEForm().setVisible(true);
            }
        });
    }
    public void mostrar(){
    java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new     ViewForm().setVisible(true);
            }
        });
    }

   
  //mensaje
    public static void mensaje(Vuelo model){
    String mensaje = "Su vuelo se guardo con exito";
     JOptionPane.showMessageDialog(null, mensaje);
    }

           
}

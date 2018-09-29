/*
 * Esteban Islas Santos.
 * Universidad Tecnológica de Tulancingo. 
 */
package model;

import javax.swing.JOptionPane;

/**
 *
 * @author ESTEBAN
 */
public class ModelBlocBase {

    private String nombre = "";
    private String apellido = "";
    private String path = "C:\\Users\\USUARIO\\Pictures\\base.csv";
    private int contador;

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    
    public String separarCadena(String nom, String ape){
        String cadena = "";
        cadena = nom + "," + ape;
        return cadena;
    }
    
    public void primerRegistro(String cadena) {
        String separar = cadena;
        String[] saltoLinea = separar.split("\n");
        String[] sep_coma = saltoLinea[0].split(",");
        this.setNombre(sep_coma[0]);
        this.setApellido(sep_coma[1]);
        
        /*nombre = resul2[0];
        apellido += resul2[1];
        System.out.println(nombre);
        System.out.println(apell);*/
    } 
    
    public void ultimoRegistro(String cadena) {
        String separar = cadena;
        String[] saltoLinea = separar.split("\n");
        int i = (saltoLinea.length - 1);
        String[] sep_coma = saltoLinea[i].split(",");
        this.setNombre(sep_coma[0]);
        this.setApellido(sep_coma[1]);
        System.out.println(i);
        
    }
    
    public void sigultRegistro(String cadena, int contador){
        try{
        String separar = cadena;
        String[] saltoLinea = separar.split("\n");
        String[] sep_coma = saltoLinea[contador].split(",");
        int i = (saltoLinea.length - 1);
        this.setNombre(sep_coma[0]);
        this.setApellido(sep_coma[1]);
        } catch(Exception err){
            System.err.println("error "+err.getMessage());
            JOptionPane.showMessageDialog(null, "Error Model: " + err.getMessage());
        }
    }
}

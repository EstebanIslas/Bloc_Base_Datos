/*
 * Esteban Islas Santos.
 * Universidad Tecnológica de Tulancingo. 
 */
package model;

/**
 *
 * @author ESTEBAN
 */
public class ModelBlocBase {

    private String nombre = "";
    private String apellido = "";
    private String path = "C:\\Users\\USUARIO\\Pictures\\base.csv";

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
        
    }

}

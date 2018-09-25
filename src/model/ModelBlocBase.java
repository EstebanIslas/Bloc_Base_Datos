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

}

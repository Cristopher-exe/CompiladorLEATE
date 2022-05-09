/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

/**
 *
 * @author chico
 */
public class Etiquetas {
    private String etiqueta = "";
    private String comparacion = "";
    private int caso = 0;

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public String getComparacion() {
        return comparacion;
    }

    public void setComparacion(String comparacion) {
        this.comparacion = comparacion;
    }

    public Etiquetas(String etiqueta, String comparacion, int caso) {
        this.comparacion = comparacion;
        this.etiqueta = etiqueta;
        this.caso = caso;
    }
    
    
}

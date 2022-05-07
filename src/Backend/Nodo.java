/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

/**
 *
 * @author chico
 */
public class Nodo {
    //Atributos
    private String dato;
    private Nodo padre;
    private Nodo izquierdo;
    private Nodo derecho;
    private String codigoIntermedio;
    private String lugar;

    public String getCodigo() {
        return codigoIntermedio;
    }

    public void setCodigo(String codigoIntermedi) {
        this.codigoIntermedio = codigoIntermedi;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }
    
    public Nodo(String info){
        this.dato = info;
    }
    
    public Nodo(Nodo derecho, String dato, Nodo izquierdo){
        this.derecho = derecho;
        this.dato = dato;
        this.izquierdo = izquierdo;
        this.padre = null;
        this.codigoIntermedio="";
        this.lugar="";
    }
    
    public Nodo getPadre(){
        return padre;
    }
    
    public void setpadre(Nodo padre){
       this.padre = padre;
    }

    public Nodo getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(Nodo izquierdo) {
        this.izquierdo = izquierdo;
    }

    public Nodo getDerecho() {
        return derecho;
    }

    public void setDerecho(Nodo derecho) {
        this.derecho = derecho;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }
}

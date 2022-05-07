/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

/**
 *
 * @author chico
 */
public class atributosIdentificador {
    String tdato, amb;
    double valor; 
    int pos;
    
    public atributosIdentificador(String tdato, double valor, int pos, String amb){
        this.tdato = tdato;
        this.valor = valor;
        this.pos = pos;
        this.amb = amb;
    }

    public String getTdato() {
        return tdato;
    }

    public void setTdato(String tdato) {
        this.tdato = tdato;
    }

    public String getAmb() {
        return amb;
    }

    public void setAmb(String amb) {
        this.amb = amb;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }
    
    
}

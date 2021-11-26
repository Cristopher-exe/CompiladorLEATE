/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

/**
 *
 * @author Cristopher
 */
public enum Tokens {
    Reservada("Reservada"),
    TK_Sig_Punt("Signo Puntuación"),
    TK_Sig_Agrup("Signo Agrupación"),
    TK_Op_Incremento("Operador Incremento"),
    TK_Op_Disminucion("Operador Disminución"),
    TK_Op_Relacional("Operador Relacional"),
    TK_Op_Arit("Operador Aritmetico"),
    TK_Op_Logi("Operador Logico"),
    TK_Op_Desigual("Operador Desigual"),
    TK_Op_Asig("Operador Asignación"),
    //TK_Boleanos("Boleano"),
    IDENTIFICADOR("Identificador"),
    Num("Num"),
    //CADENA("Cadena"),
    ERRORL_000("Error Lexico 000"),
    ERRORL_001("Error Lexico 001"),
    ERRORL_002("Error Lexico 002"),
    ERRORL_003("Error Lexico 003"),
    ERRORL_004("Error Lexico 004"),
    ERRORL_005("Error Lexico 005"),
    ERRORL_006("Error Lexico 006"),
    ERRORL_007("Error Lexico 007"),
    ERRORL_008("Error Lexico 008"),
    ERRORL_009("Error Lexico 009"),
    ERRORL_010("Error Lexico 010");
    
    String nombre;
    Tokens(String pNombre){nombre = pNombre;}
    public String getNombre() { return nombre; }    
}

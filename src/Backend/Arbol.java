/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 *
 * @author chico
 */
public class Arbol {
    
    Stack<Nodo> ArbolNodo;
    Stack<String> caracter;
    final String espacios="\t";
    final String aritmeticos = "=+-*/()";
    final String relacionales = "><!";
    final String variables="abcdefghijklmnopqrstuvwxyz";
    private Nodo raiz;
    HashMap<String, String> tablaSimbolos;
    HashMap<String, String> erroresSemanticos;
    HashMap<String, String> producciones;
    HashMap<String, String> reglasSemanticas;
    int paso;
    String r, reglaSemantica;
    ArrayList<String> reglasEjecutadas;
    
    public Arbol(){
        caracter =  new Stack<String>();
        ArbolNodo = new Stack<Nodo>();
        tablaSimbolos = new HashMap<>();
        erroresSemanticos = new HashMap<>();
        producciones = new HashMap<>();
        reglasSemanticas = new HashMap<>();
        paso = 0;
        reglaSemantica="";
        r="";
        reglasEjecutadas = new ArrayList<String>();
        //tablaSimbolosSemántica = new HashMap<String,TablaSimbolos>();
    }

public void agregaValex(String lexema, String valor){
        tablaSimbolos.put(lexema,valor);
    }
    
    public String regresaValex(String lexema){
        return tablaSimbolos.get(lexema);
    }
    
    public String getReglasEjecutadas(){
        String reglasE="";
        for(int i=0;i<reglasEjecutadas.size();i++){
            System.out.println("Reglas ejecutadas: "+reglasEjecutadas.get(i)+"\n");
            reglasE+=reglasEjecutadas.get(i)+"\n";
        }
        return reglasE;
    }

private void guardar(){
    String reglaE = "";
    Nodo izquierdo = (Nodo) ArbolNodo.pop();
    Nodo derecho = (Nodo) ArbolNodo.pop();
    String operador = caracter.peek();
    ArbolNodo.push(new Nodo(derecho, caracter.pop(), izquierdo));
    switch(operador){
        case "+":
            reglaE = "E.nodo = new Nodo('+',E1.nodo,T.nodo)";
            reglasEjecutadas.add("p"+paso+" "+reglaE);
            break;
        case "*":
            reglaE = "E.nodo = new Nodo('*',E1.nodo,T.nodo)";
            reglasEjecutadas.add("p"+paso+" "+reglaE);
            break;
        case "-":
            reglaE = "E.nodo = new Nodo('-',E1.nodo,T.nodo)";
            reglasEjecutadas.add("p"+paso+" "+reglaE);
            break;
        case "/":
            reglaE = "E.nodo = new Nodo('/',E1.nodo,T.nodo)";
            reglasEjecutadas.add("p"+paso+" "+reglaE);
            break;
        case "=":
            reglaE = "E.nodo = new Nodo('=',E1.nodo,T.nodo)";
            reglasEjecutadas.add("p"+paso+" "+reglaE);
            break;
        case "!=":
            reglaE = "E.nodo = new Nodo('!=',E1.nodo,T.nodo)";
            reglasEjecutadas.add("p"+paso+" "+reglaE);
            break;
        case "==":
            reglaE = "E.nodo = new Nodo('==',E1.nodo,T.nodo)";
            reglasEjecutadas.add("p"+paso+" "+reglaE);
            break;
        case "<":
            reglaE = "E.nodo = new Nodo('<',E1.nodo,T.nodo)";
            reglasEjecutadas.add("p"+paso+" "+reglaE);
            break;
        case ">":
            reglaE = "E.nodo = new Nodo('>',E1.nodo,T.nodo)";
            reglasEjecutadas.add("p"+paso+" "+reglaE);
            break;
        case "<=":
            reglaE = "E.nodo = new Nodo('<=',E1.nodo,T.nodo)";
            reglasEjecutadas.add("p"+paso+" "+reglaE);
            break;
        case ">=":
            reglaE = "E.nodo = new Nodo('>=',E1.nodo,T.nodo)";
            reglasEjecutadas.add("p"+paso+" "+reglaE);
            break;
    }
}

public Nodo crear(String expresion){
    raiz = new Nodo("");
    StringTokenizer tokenizer;
    String token;
    tokenizer = new StringTokenizer(expresion,espacios+aritmeticos+relacionales,true);
    while(tokenizer.hasMoreTokens()){
        token = tokenizer.nextToken();
        if(espacios.indexOf(token)>=0){
            //Se deja en blanco para ignorar espacios
        } else if (aritmeticos.indexOf(token)<0 && relacionales.indexOf(token)<0 && !token.equals("}")){
            ArbolNodo.push(new Nodo(token));
            paso++;
            String regla ="T.nodo = new Hoja(id<"+token+">,id.entrada)";
            reglasEjecutadas.add("P"+paso+" "+regla);
        } else if(token.equals(")")){
            while(!caracter.empty()&&!caracter.peek().equals("(")){
                guardar();
                raiz = (Nodo) ArbolNodo.peek();
            }
        } else if (token.equals("}")){
            caracter.push(token);
        } else {
            if(!token.equals("(")&&!caracter.empty()){
                String exa = (String) caracter.peek();
                while(!exa.equals("(")&&caracter.empty()&&aritmeticos.indexOf(exa)>=aritmeticos.indexOf(token)){
                    guardar();
                    if(!caracter.empty()){
                        exa=(String) caracter.peek();
                    }
                }
            }
            if (token.contains("!") || token.contains(">") || token.contains("<")){
                if(tokenizer.nextToken().equals("=")){
                    token = token.toString()+"=";
                }
            }
            caracter.push(token);
        }
    }
    while(!caracter.empty()){
        if(caracter.peek().equals("(")){
            caracter.pop();
        } else {
            guardar();
            raiz = (Nodo) ArbolNodo.peek();
        }
    }
    return raiz;
}
    
}

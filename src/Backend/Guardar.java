/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;


import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;


/**
 *
 * @author Cristopher
 */
public class Guardar {
    
    public String prueba = "";
    private String URL="";
    static File file;
    
    static String URL2="";
    static File file2;

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public Guardar() {
    }
    
    
    
    public void guardar(String texto){
        
        try{
            //si no hay ruta
            if(getURL().isEmpty()){   
                JFileChooser guardar = new JFileChooser();
                /*Se crea el filtro. El primer parámetro es el mensaje que se muestra,
                  el segundo es la extensión de los ficheros que se van a mostrar*/
                FileFilter filtro = new FileNameExtensionFilter("Archivos de texto (.txt)", "txt");
                //Se le asigna al JFileChooser el filtro
                guardar.setFileFilter(filtro);
                //mostrar la ventana para guardar el archivo txt
                guardar.showSaveDialog(null);
                //capturar la ruta
                guardar.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                //asignar la nueva ruta
                File archivo = guardar.getSelectedFile();
                //convertir la ruta a String (porque la ruta debe ser en String)
                setURL(archivo.toString());
                //creamos el metodo FILE y le agregamos la ruta
                file = new File(getURL());
                //se crear el txt en la ruta
                file.createNewFile();
                //el txt se llena del texto obtenido en el JTextPanel
                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(texto);
                bw.close();
            //Si la ruta ya existe (el archivo ya esta creado) se sobreescribe
            }else{ 
                file = new File(getURL());
                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(texto);
                bw.close();
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null,"No se selecciono ningun fichero");
        }
            
        
   }
    
    public void guardarComo(String texto){
        try {
                JFileChooser guardar = new JFileChooser();
                /*Se crea el filtro. El primer parámetro es el mensaje que se muestra,
                  el segundo es la extensión de los ficheros que se van a mostrar*/
                FileFilter filtro = new FileNameExtensionFilter("Archivos de texto (.txt)", "txt");
                //Se le asigna al JFileChooser el filtro
                guardar.setFileFilter(filtro);
                //mostrar la ventana para guardar el archivo txt
                guardar.showSaveDialog(null);
                //capturar la ruta
                guardar.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                //asignar la nueva ruta
                File archivo = guardar.getSelectedFile();
                //convertir la ruta a String (porque la ruta debe ser en String)
                URL = archivo.toString();
                //creamos el metodo FILE y le agregamos la ruta
                file2 = new File(URL);
                //se crear el txt en la ruta
                file2.createNewFile();
                //el txt se llena del texto obtenido en el JTextPanel
                FileWriter fw = new FileWriter(file2);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(texto);
                bw.close();
              
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"No se selecciono ningun fichero");
        }
    }
}

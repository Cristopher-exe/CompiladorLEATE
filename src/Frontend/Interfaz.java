/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frontend;
import Backend.Guardar;
import Frontend.NumeroLinea;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
/**
 *
 * @author Cristopher
 */
public class Interfaz extends javax.swing.JFrame {

    NumeroLinea nl;
    Guardar gdar = new Guardar();
    
    public Interfaz() {
        initComponents();
        this.setTitle("Compilador LEATE");
        setIconImage(new ImageIcon(getClass().getResource("/Frontend/Imagenes/Logo.png")).getImage());
        PanelSalida.setEditable(false);
        //Agregamos el numero de linea al panelfuente
        nl = new NumeroLinea(PanelFuente);
        jScrollPanelFuente.setRowHeaderView(nl);
        //Impedir el redimencionamiento de la interfaz
        this.setResizable(false);
        //Centrar la ventana
        this.setLocationRelativeTo(null);
        colors();
        cerrar();
    }

     //METODO PARA ENCONTRAR LAS ULTIMAS CADENAS
    private int findLastNonWordChar(String text, int index) {
        while (--index >= 0) {
            //  \\W = [A-Za-Z0-9]
            if (String.valueOf(text.charAt(index)).matches("\\W")) {
                break;
            }
        }
        return index;
    }   
    
    //METODO PARA ENCONTRAR LAS PRIMERAS CADENAS 
    private int findFirstNonWordChar(String text, int index) {
        while (index < text.length()) {
            if (String.valueOf(text.charAt(index)).matches("\\W")) {
                break;
            }
            index++;
        }
        return index;
    }

    //METODO PARA PINTAS LAS PALABRAS RESEVADAS
    private void colors() {

        final StyleContext cont = StyleContext.getDefaultStyleContext();

        //COLORES 
        final AttributeSet attred = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, new Color(255, 0, 35));
        final AttributeSet attgreen = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, new Color(0, 255, 54));
        final AttributeSet attblue = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, new Color(0, 147, 255));
        final AttributeSet attblack = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, new Color(0, 0, 0));
        final AttributeSet attorange = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, new Color(255, 127, 0));

        //STYLO 
        DefaultStyledDocument doc = new DefaultStyledDocument() {
            public void insertString(int offset, String str, AttributeSet a) throws BadLocationException {
                super.insertString(offset, str, a);

                String text = getText(0, getLength());
                int before = findLastNonWordChar(text, offset);
                if (before < 0) {
                    before = 0;
                }
                int after = findFirstNonWordChar(text, offset + str.length());
                int wordL = before;
                int wordR = before;

                while (wordR <= after) {
                    if (wordR == after || String.valueOf(text.charAt(wordR)).matches("\\W")) {
                        if (text.substring(wordL, wordR).matches("(\\W)*(for|while|if|else|event|KeyPlayed|start)")) { 
                            setCharacterAttributes(wordL, wordR - wordL, attred, false);
                        } else if (text.substring(wordL, wordR).matches("(\\W)*(int|long|Final|pulsa|caso|KP_Z|KP_X|KP_C|KP_V|KP_B|KP_N|KP_M)")) {
                            setCharacterAttributes(wordL, wordR - wordL, attblue, false);
                        } else if (text.substring(wordL, wordR).matches("(\\W)*(retnot|delay_ms|output_N|output_high|output_low|Display)")) {
                            setCharacterAttributes(wordL, wordR - wordL, attorange, false);
                        } else {
                            setCharacterAttributes(wordL, wordR - wordL, attblack, false);
                        }
                        wordL = wordR;

                    }
                    wordR++;
                }
            }

            public void romeve(int offs, int len) throws BadLocationException {
                super.remove(offs, len);

                String text = getText(0, getLength());
                int before = findLastNonWordChar(text, offs);
                if (before < 0) {
                    before = 0;
                }
            }
        };
        
        JTextPane txt = new JTextPane(doc);
        String temp = PanelFuente.getText();
        PanelFuente.setStyledDocument(txt.getStyledDocument());
        PanelFuente.setText(temp);

    }    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        Fondo = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        btnNuevo = new javax.swing.JButton();
        btnAbrir = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnGuardarComo = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        PanelSalida = new javax.swing.JTextArea();
        jScrollPanelFuente = new javax.swing.JScrollPane();
        PanelFuente = new javax.swing.JTextPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        btnmenuNuevo = new javax.swing.JMenuItem();
        btnmenuAbrir = new javax.swing.JMenuItem();
        btnmenuGuardar = new javax.swing.JMenuItem();
        btnmenuGuardarComo = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        btnMenuSalir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();

        jMenuItem4.setText("jMenuItem4");

        jMenuItem6.setText("jMenuItem6");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1028, 694));
        setMinimumSize(new java.awt.Dimension(12, 12));
        setPreferredSize(new java.awt.Dimension(1007, 710));
        setResizable(false);

        Fondo.setBackground(new java.awt.Color(255, 255, 255));
        Fondo.setMinimumSize(new java.awt.Dimension(1028, 700));
        Fondo.setPreferredSize(new java.awt.Dimension(1007, 710));
        Fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jToolBar1.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar1.setRollover(true);
        jToolBar1.setPreferredSize(new java.awt.Dimension(100, 40));

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Frontend/Imagenes/Nuevo1.png"))); // NOI18N
        btnNuevo.setToolTipText("Nuevo");
        btnNuevo.setBorder(null);
        btnNuevo.setBorderPainted(false);
        btnNuevo.setContentAreaFilled(false);
        btnNuevo.setFocusable(false);
        btnNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevo.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Frontend/Imagenes/Nuevo1-select.png"))); // NOI18N
        btnNuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jToolBar1.add(btnNuevo);

        btnAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Frontend/Imagenes/Abrir.png"))); // NOI18N
        btnAbrir.setToolTipText("Abrir");
        btnAbrir.setBorder(null);
        btnAbrir.setBorderPainted(false);
        btnAbrir.setContentAreaFilled(false);
        btnAbrir.setFocusable(false);
        btnAbrir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAbrir.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Frontend/Imagenes/Abrir select.png"))); // NOI18N
        btnAbrir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });
        jToolBar1.add(btnAbrir);

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Frontend/Imagenes/guardar.png"))); // NOI18N
        btnGuardar.setToolTipText("Guardar");
        btnGuardar.setBorder(null);
        btnGuardar.setBorderPainted(false);
        btnGuardar.setContentAreaFilled(false);
        btnGuardar.setFocusable(false);
        btnGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGuardar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Frontend/Imagenes/guardar select.png"))); // NOI18N
        btnGuardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnGuardar);

        btnGuardarComo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Frontend/Imagenes/guardar como.png"))); // NOI18N
        btnGuardarComo.setToolTipText("Guardar Como");
        btnGuardarComo.setBorder(null);
        btnGuardarComo.setBorderPainted(false);
        btnGuardarComo.setContentAreaFilled(false);
        btnGuardarComo.setFocusable(false);
        btnGuardarComo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGuardarComo.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Frontend/Imagenes/guardar como select.png"))); // NOI18N
        btnGuardarComo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGuardarComo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarComoActionPerformed(evt);
            }
        });
        jToolBar1.add(btnGuardarComo);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Frontend/Imagenes/analisis lexico.png"))); // NOI18N
        jButton5.setToolTipText("Analisis Lexico");
        jButton5.setBorder(null);
        jButton5.setBorderPainted(false);
        jButton5.setContentAreaFilled(false);
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Frontend/Imagenes/analisis lexico select.png"))); // NOI18N
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton5);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Frontend/Imagenes/Analisis sintactico.png"))); // NOI18N
        jButton6.setToolTipText("Analisis Sintactico");
        jButton6.setBorder(null);
        jButton6.setBorderPainted(false);
        jButton6.setContentAreaFilled(false);
        jButton6.setFocusable(false);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setName(""); // NOI18N
        jButton6.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Frontend/Imagenes/Analisis sintactico - select.png"))); // NOI18N
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton6);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Frontend/Imagenes/Barra de aceesos rapidos 3.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setMinimumSize(new java.awt.Dimension(480, 50));
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton1);

        Fondo.add(jToolBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1300, 50));

        PanelSalida.setBackground(new java.awt.Color(255, 255, 255));
        PanelSalida.setColumns(20);
        PanelSalida.setRows(5);
        PanelSalida.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 51), 3));
        jScrollPane1.setViewportView(PanelSalida);

        Fondo.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 1000, 200));

        PanelFuente.setBackground(new java.awt.Color(255, 255, 255));
        PanelFuente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51), 3));
        PanelFuente.setFont(new java.awt.Font("Consolas", 0, 16)); // NOI18N
        jScrollPanelFuente.setViewportView(PanelFuente);

        Fondo.add(jScrollPanelFuente, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 1000, 410));

        getContentPane().add(Fondo, java.awt.BorderLayout.CENTER);

        jMenu1.setText("Archivo");

        btnmenuNuevo.setText("Nuevo");
        btnmenuNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmenuNuevoActionPerformed(evt);
            }
        });
        jMenu1.add(btnmenuNuevo);

        btnmenuAbrir.setText("Abrir");
        btnmenuAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmenuAbrirActionPerformed(evt);
            }
        });
        jMenu1.add(btnmenuAbrir);

        btnmenuGuardar.setText("Guardar");
        btnmenuGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmenuGuardarActionPerformed(evt);
            }
        });
        jMenu1.add(btnmenuGuardar);

        btnmenuGuardarComo.setText("Guardar como");
        btnmenuGuardarComo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmenuGuardarComoActionPerformed(evt);
            }
        });
        jMenu1.add(btnmenuGuardarComo);
        jMenu1.add(jSeparator1);

        btnMenuSalir.setText("Salir");
        btnMenuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuSalirActionPerformed(evt);
            }
        });
        jMenu1.add(btnMenuSalir);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Compilar");

        jMenuItem8.setText("Analisis Lexico");
        jMenu2.add(jMenuItem8);

        jMenuItem9.setText("Analisis Sintactico");
        jMenu2.add(jMenuItem9);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Tablas");

        jMenuItem10.setText("Variables");
        jMenu3.add(jMenuItem10);

        jMenuItem11.setText("Lexemas");
        jMenu3.add(jMenuItem11);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Acerca de");
        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        //validar si el panel esta vacio antes de crear un nuevo archivo
        if(PanelFuente.getText().isEmpty()){
            PanelFuente.setText("");
            gdar.setURL("");
        }else{
            int num = JOptionPane.showConfirmDialog(null,"¿Deseas guardar el archivo?");
            if(num == 0){
                gdar.guardar(PanelFuente.getText());
                PanelFuente.setText("");
                gdar.setURL("");
                JOptionPane.showMessageDialog(null,"Guardado con exito");
            }else if(num == 1) {
                PanelFuente.setText("");
                gdar.setURL("");
            }
        } 
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed
        //codigo para validar antes de abrir
        if(PanelFuente.getText().isEmpty()){
           abrirsintexto();           
        }else{            
            int num = JOptionPane.showConfirmDialog(null,"¿Deseas guardar el archivo antes de abrir uno nuevo?");
            if(num == 0){
                gdar.guardar(PanelFuente.getText());
                PanelFuente.setText("");
                gdar.setURL("");
                JOptionPane.showMessageDialog(null,"Guardado con exito");
                abrirsintexto();
            }else if(num == 1) {
                PanelFuente.setText("");
                gdar.setURL("");
                abrirsintexto();   
            }
        }
    }//GEN-LAST:event_btnAbrirActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        /*
            Manda a llamar el metodo y la clase para abrir el panel de guardar
        */
        gdar.guardarComo(PanelFuente.getText());
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnGuardarComoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarComoActionPerformed
        /*
            Manda a llamar el metodo y la clase para abrir el panel de guardar
        */
        gdar.guardarComo(PanelFuente.getText());
    }//GEN-LAST:event_btnGuardarComoActionPerformed

    private void btnMenuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuSalirActionPerformed
        //validar antes de salir
        if(PanelFuente.getText().isEmpty()){
            dispose();
        }else{
            int num = JOptionPane.showConfirmDialog(null,"¿Deseas guardar el archivo antes de salir?");
            if(num == 0){
                gdar.guardar(PanelFuente.getText());
                dispose();
            }else if(num == 1) {
                dispose();    
            }
        }
    }//GEN-LAST:event_btnMenuSalirActionPerformed

    private void btnmenuNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmenuNuevoActionPerformed
        //validar si el panel esta vacio antes de crear un nuevo archivo
        if(PanelFuente.getText().isEmpty()){
            PanelFuente.setText("");
            gdar.setURL("");
        }else{
            int num = JOptionPane.showConfirmDialog(null,"¿Deseas guardar el archivo?");
            if(num == 0){
                gdar.guardar(PanelFuente.getText());
                PanelFuente.setText("");
                gdar.setURL("");
                JOptionPane.showMessageDialog(null,"Guardado con exito");
            }else if(num == 1) {
                PanelFuente.setText("");
                gdar.setURL("");
            }
        } 
    }//GEN-LAST:event_btnmenuNuevoActionPerformed

    private void btnmenuAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmenuAbrirActionPerformed
        //codigo para validar antes de abrir
        if(PanelFuente.getText().isEmpty()){
           abrirsintexto();           
        }else{            
            int num = JOptionPane.showConfirmDialog(null,"¿Deseas guardar el archivo antes de abrir uno nuevo?");
            if(num == 0){
                gdar.guardar(PanelFuente.getText());
                PanelFuente.setText("");
                gdar.setURL("");
                JOptionPane.showMessageDialog(null,"Guardado con exito");
                abrirsintexto();
            }else if(num == 1) {
                PanelFuente.setText("");
                gdar.setURL("");
                abrirsintexto();   
            }
        }
    }//GEN-LAST:event_btnmenuAbrirActionPerformed

    private void btnmenuGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmenuGuardarActionPerformed
        /*
            Manda a llamar el metodo y la clase para abrir el panel de guardar
        */
        gdar.guardarComo(PanelFuente.getText());
    }//GEN-LAST:event_btnmenuGuardarActionPerformed

    private void btnmenuGuardarComoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmenuGuardarComoActionPerformed
        /*
            Manda a llamar el metodo y la clase para abrir el panel de guardar
        */
        gdar.guardarComo(PanelFuente.getText());
    }//GEN-LAST:event_btnmenuGuardarComoActionPerformed

    public void abrirsintexto(){
        //Metodo si no hay texto en el panel fuente para el boton abrir
           JFileChooser abrir = new JFileChooser();
           FileFilter filtro = new FileNameExtensionFilter("Archivos de texto (.txt)", "txt");
           abrir.setFileFilter(filtro);
           abrir.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);    
            
           try {
                int num = abrir.showOpenDialog(this);
                if(num == 0){
                    File archivo = abrir.getSelectedFile();
                    URL = archivo.toString();
           
                    BufferedReader br = new BufferedReader(new FileReader(URL));
           
                    String l="";
                    String aux="";
           
                    while(true){
                        aux=br.readLine();
                        if(aux!=null)
                            l=l+aux+"\n";
                        else
                            break;
                    }
                    PanelFuente.setText(l);
                    br.close();
                    gdar.setURL(URL);
                }else{
                    JOptionPane.showMessageDialog(this,"No se selecciono ningun archivo");
                }        
            } catch (Exception ex) { //FileNotFoundException
                JOptionPane.showMessageDialog(this,"No se selecciono ningun archivo");
            }
    }
    
    public void cerrar(){
        //Validar cierre del programa para la X
        try {
            this.setDefaultCloseOperation(Interfaz.DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e){
                    if(PanelFuente.getText().isEmpty()){
                        System.exit(0);
                    }else{
                         int num = JOptionPane.showConfirmDialog(null,"¿Deseas guardar el archivo antes de salir?");
                         if(num == 0){
                            gdar.guardar(PanelFuente.getText());
                            System.exit(0);
                        }else if(num == 1) {
                            System.exit(0); 
                        }
                    }
                }
            });
            this.setVisible(true);
        } catch (Exception e) {
        }
    }
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }

    //variable que contendra la ruta del archivo
    static String URL="";    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Fondo;
    private javax.swing.JTextPane PanelFuente;
    private javax.swing.JTextArea PanelSalida;
    private javax.swing.JButton btnAbrir;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnGuardarComo;
    private javax.swing.JMenuItem btnMenuSalir;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JMenuItem btnmenuAbrir;
    private javax.swing.JMenuItem btnmenuGuardar;
    private javax.swing.JMenuItem btnmenuGuardarComo;
    private javax.swing.JMenuItem btnmenuNuevo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPanelFuente;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
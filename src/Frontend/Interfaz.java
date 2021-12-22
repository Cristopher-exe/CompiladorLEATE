/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frontend;

import Backend.Guardar;
import Frontend.Ventana;
import Frontend.NumeroLinea;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import Backend.*;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.runtime.Symbol;
import Frontend.V_Identificadores;
import Frontend.Acercade;
import java.util.ArrayList;

/**
 *
 * @author Cristopher
 */
public class Interfaz extends javax.swing.JFrame {

    NumeroLinea nl;
    Guardar gdar = new Guardar();
    public Ventana v = new Ventana(this, rootPaneCheckingEnabled);
    public V_Identificadores ventanaid = new V_Identificadores(this, rootPaneCheckingEnabled);
    Acercade ac = new Acercade(this, rootPaneCheckingEnabled);
    public static String errores_Producidos = "";
    public static boolean banderax = false;
    public static ArrayList<String> nm = new ArrayList<String>();

    //Ruta del lexer (Solo se ejecuta una vez o cada que se modifique el Lexer.flex por eso esta en comentario)
    String rutaLexer = "D:\\Cristopher\\Documentos\\NetBeansProjects\\Compilador_LEATE\\src\\Backend\\Lexer.flex";

    String ruta2 = "D:\\Cristopher\\Documentos\\NetBeansProjects\\Compilador_LEATE\\src\\Backend\\LexerCup.flex";
    String[] rutas = {"-parser", "Sintax", "D:\\Cristopher\\Documentos\\NetBeansProjects\\Compilador_LEATE\\src\\Backend\\Sintax.cup"};

    public Interfaz() throws Exception {
        initComponents();
        this.setTitle("Compilador LEATE");
        setIconImage(new ImageIcon(getClass().getResource("/Frontend/Imagenes/lOGO1.png")).getImage());
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
        //Crear el LEXER (Solo se ejecuta una vez o cada que se modifique el Lexer.flex por eso esta en comentario)
        //generarLexer(rutaLexer);
        //Generar(rutaLexer, ruta2, rutas);
    }

    public static void generarLexer(String ruta) {
        File archivo = new File(ruta);
        JFlex.Main.generate(archivo);

    }

    public static void Generar(String ruta1, String ruta2, String[] rutaS) throws IOException, Exception {
        File archivo;
        archivo = new File(ruta1);
        JFlex.Main.generate(archivo);
        archivo = new File(ruta2);
        JFlex.Main.generate(archivo);
        java_cup.Main.main(rutaS);

        Path rutaSym = Paths.get("D:\\Cristopher\\Documentos\\NetBeansProjects\\Compilador_LEATE\\src\\Backend\\sym.java");
        if (Files.exists(rutaSym)) {
            Files.delete(rutaSym);
        }

        Files.move(
                Paths.get("D:\\Cristopher\\Documentos\\NetBeansProjects\\Compilador_LEATE\\sym.java"),
                Paths.get("D:\\Cristopher\\Documentos\\NetBeansProjects\\Compilador_LEATE\\src\\Backend\\sym.java")
        );

        Path rutaSin = Paths.get("D:\\Cristopher\\Documentos\\NetBeansProjects\\Compilador_LEATE\\src\\Backend\\Sintax.java");
        if (Files.exists(rutaSin)) {
            Files.delete(rutaSin);
        }
        Files.move(
                Paths.get("D:\\Cristopher\\Documentos\\NetBeansProjects\\Compilador_LEATE\\Sintax.java"),
                Paths.get("D:\\Cristopher\\Documentos\\NetBeansProjects\\Compilador_LEATE\\src\\Backend\\Sintax.java")
        );
    }

    public static void pruebaAnalisis(String x, Object tt) {
        PanelSalida.setText("Funciona:" + x + tt);
    }

    public void tablaLexemas() throws IOException {
        Object[] O = new Object[3];
        Object[] I = new Object[4];
        v.lex.setRowCount(0);
        ventanaid.identi.setRowCount(0);

        try {
            gdar.guardar(PanelFuente.getText());
            Reader lector = new BufferedReader(new FileReader(gdar.getURL()));
            lexer lex = new lexer(lector);
            String result = "";
            while (true) {
                Tokens tokens = lex.yylex();
                if (tokens == null) {
                    PanelSalida.setText(result);
                    return;
                }
                switch (tokens) {
                    case ERRORL_001:
                        result += "*Error Lexico 001. " + "Linea " + lex.line + ": Identificador no valido" + "[" + lex.lexeme + "]." + " Un Identificador no debe comenzar con uno o más digito.\n";
                        break;
                    case ERRORL_002:
                        result += "*Error Lexico 002. " + "Linea " + lex.line + ": Identificador no valido" + "[" + lex.lexeme + "]." + " Un Identificador no puede comenzar con un simbolo especial.\n";
                        break;
                    case ERRORL_003:
                        result += "*Error Lexico 003. " + "Linea " + lex.line + ": Numero no valido" + "[" + lex.lexeme + "]." + " La estructura del número es incorrecta, no puede haber más de dos puntos en la expresión.\n";
                        break;
                    case ERRORL_004:
                        result += "*Error Lexico 004. " + "Linea " + lex.line + ": Numero no valido" + "[" + lex.lexeme + "]." + " La estructura del numero es incorrecta.\n";
                        break;
                    case ERRORL_005:
                        result += "*Error Lexico 005. " + "Linea " + lex.line + ": Numero no valido" + "[" + lex.lexeme + "]." + " La estructura del número es incorrecta, no se puede combinar puntos con letras y números.\n";
                        break;
                    case ERRORL_006:
                        result += "*Error Lexico 006. " + "Linea " + lex.line + ": Numero no valido" + "[" + lex.lexeme + "]." + " No pueden ir números con letras después del punto.\n";
                        break;
                    case ERRORL_007:
                        result += "*Error Lexico 007. " + "Linea " + lex.line + ": Identificador no valido" + "[" + lex.lexeme + "]." + " No se admiten puntos(.) en el nombre del identificador.\n";
                        break;
                    case ERRORL_008:
                        result += "*Error Lexico 008. " + "Linea " + lex.line + ": Numero no valido" + "[" + lex.lexeme + "]." + " El numero no puede terminar con un punto\n";
                        break;
                    case ERRORL_009:
                        result += "*Error Lexico 009. " + "Linea " + lex.line + ": Numero no valido" + "[" + lex.lexeme + "]." + " No se admiten comas(,) en la estructura de los numeros\n";
                        break;
                    case ERRORL_010:
                        result += "*Error Lexico 010. " + "Linea " + lex.line + ": Identificador no valido" + "[" + lex.lexeme + "]." + " No se admiten puntos(.) en el nombre del identificador.\n";
                        break;
                    case ERRORL_011:
                        result += "*Error Lexico 011. " + "Linea " + lex.line + ": Numero no valido" + "[" + lex.lexeme + "]." + " Un numero no debe comenzar con simbolos especiales.\n";
                        break;
                    case ERRORL_012:
                        result += "*Error Lexico 012. " + "Linea " + lex.line + ": Numero no valido" + "[" + lex.lexeme + "]." + " Un numero no debe contener simbolos especiales.\n";
                        break;
                    case ERRORL_013:
                        result += "*Error Lexico 013. " + "Linea " + lex.line + ": Numero no valido" + "[" + lex.lexeme + "]." + " Un numero no debe comenzar con guion bajo.\n";
                        break;
                    case ERRORL_014:
                        result += "*Error Lexico 014. " + "Linea " + lex.line + ": Identificador Ilegal" + "[" + lex.lexeme + "]." + " El identificador no debe comenzar con guion bajo.\n";
                        break;
                    case ERRORL_015:
                        result += "*Error Lexico 015. " + "Linea " + lex.line + ": Numero no valido" + "[" + lex.lexeme + "]." + " Un numero no debe contener letras.\n";
                        break;
                    case ERRORL_016:
                        result += "*Error Lexico 016. " + "Linea " + lex.line + ": Identificador ilegal" + "[" + lex.lexeme + "]." + " Un identificador no debe contener puntos.\n";
                        break;
                    case ERRORL_000:
                        result += "*Error Lexico no Identificado. " + "Linea " + lex.line + " [" + lex.lexeme + "]." + " Revise su codigo.\n";
                        break;
                    case retnot:
                        O[0] = lex.line;
                        O[1] = lex.lexeme;
                        O[2] = "Palabra Reservada";
                        v.lex.addRow(O);
                        break;
                    case For:
                        O[0] = lex.line;
                        O[1] = lex.lexeme;
                        O[2] = "Palabra Reservada";
                        v.lex.addRow(O);
                        break;
                    case While:
                        O[0] = lex.line;
                        O[1] = lex.lexeme;
                        O[2] = "Palabra Reservada";
                        v.lex.addRow(O);
                        break;
                    case If:
                        O[0] = lex.line;
                        O[1] = lex.lexeme;
                        O[2] = "Palabra Reservada";
                        v.lex.addRow(O);
                        break;
                    case delay_ms:
                        O[0] = lex.line;
                        O[1] = lex.lexeme;
                        O[2] = "Palabra Reservada";
                        v.lex.addRow(O);
                        break;
                    case star:
                        O[0] = lex.line;
                        O[1] = lex.lexeme;
                        O[2] = "Palabra Reservada";
                        v.lex.addRow(O);
                        break;
                    case Else:
                        O[0] = lex.line;
                        O[1] = lex.lexeme;
                        O[2] = "Palabra Reservada";
                        v.lex.addRow(O);
                        break;
                    case T_dato:
                        O[0] = lex.line;
                        O[1] = lex.lexeme;
                        O[2] = "Tipo de dato";
                        v.lex.addRow(O);
                        break;
                    case pulsa:
                        O[0] = lex.line;
                        O[1] = lex.lexeme;
                        O[2] = "Palabra Reservada";
                        v.lex.addRow(O);
                        break;
                    case output_N:
                        O[0] = lex.line;
                        O[1] = lex.lexeme;
                        O[2] = "Palabra Reservada";
                        v.lex.addRow(O);
                        break;
                    case Kp_Teclado:
                        O[0] = lex.line;
                        O[1] = lex.lexeme;
                        O[2] = "Palabra Reservada";
                        v.lex.addRow(O);
                        break;
                    case KeyPlayed:
                        O[0] = lex.line;
                        O[1] = lex.lexeme;
                        O[2] = "Palabra Reservada";
                        v.lex.addRow(O);
                        break;
                    case Display:
                        O[0] = lex.line;
                        O[1] = lex.lexeme;
                        O[2] = "Palabra Reservada";
                        v.lex.addRow(O);
                        break;
                    case Final:
                        O[0] = lex.line;
                        O[1] = lex.lexeme;
                        O[2] = "Palabra Reservada";
                        v.lex.addRow(O);
                        break;
                    case event:
                        O[0] = lex.line;
                        O[1] = lex.lexeme;
                        O[2] = "Palabra Reservada";
                        v.lex.addRow(O);
                        break;
                    case caso:
                        O[0] = lex.line;
                        O[1] = lex.lexeme;
                        O[2] = "Palabra Reservada";
                        v.lex.addRow(O);
                        break;
                    case output_high:
                        O[0] = lex.line;
                        O[1] = lex.lexeme;
                        O[2] = "Palabra Reservada";
                        v.lex.addRow(O);
                        break;
                    case output_low:
                        O[0] = lex.line;
                        O[1] = lex.lexeme;
                        O[2] = "Palabra Reservada";
                        v.lex.addRow(O);
                        break;
                    case pines_B:
                        O[0] = lex.line;
                        O[1] = lex.lexeme;
                        O[2] = "Palabra Reservada";
                        v.lex.addRow(O);
                        break;
                    case Sig_Agru:
                        O[0] = lex.line;
                        O[1] = lex.lexeme;
                        O[2] = "Signo de agrupació";
                        v.lex.addRow(O);
                        break;
                    case dosPuntos:
                        O[0] = lex.line;
                        O[1] = lex.lexeme;
                        O[2] = "Signo de agrupació";
                        v.lex.addRow(O);
                        break;
                    case Llave_a:
                        O[0] = lex.line;
                        O[1] = lex.lexeme;
                        O[2] = "Signo de agrupació";
                        v.lex.addRow(O);
                        break;
                    case Llave_c:
                        O[0] = lex.line;
                        O[1] = lex.lexeme;
                        O[2] = "Signo de agrupació";
                        v.lex.addRow(O);
                        break;
                    case Corchete_a:
                        O[0] = lex.line;
                        O[1] = lex.lexeme;
                        O[2] = "Signo de agrupació";
                        v.lex.addRow(O);
                        break;
                    case Corchete_c:
                        O[0] = lex.line;
                        O[1] = lex.lexeme;
                        O[2] = "Signo de agrupació";
                        v.lex.addRow(O);
                        break;
                    case parentesis_a:
                        O[0] = lex.line;
                        O[1] = lex.lexeme;
                        O[2] = "Signo de agrupació";
                        v.lex.addRow(O);
                        break;
                    case parentesis_c:
                        O[0] = lex.line;
                        O[1] = lex.lexeme;
                        O[2] = "Signo de agrupació";
                        v.lex.addRow(O);
                        break;
                    case TK_punto:
                        O[0] = lex.line;
                        O[1] = lex.lexeme;
                        O[2] = "Signo de agrupació";
                        v.lex.addRow(O);
                        break;
                    case Op_incremento:
                        O[0] = lex.line;
                        O[1] = lex.lexeme;
                        O[2] = "Operador incremento";
                        v.lex.addRow(O);
                        break;
                    case Op_decremento:
                        O[0] = lex.line;
                        O[1] = lex.lexeme;
                        O[2] = "Operador decremento";
                        v.lex.addRow(O);
                        break;
                    case Op_relacional:
                        O[0] = lex.line;
                        O[1] = lex.lexeme;
                        O[2] = "Operador relacional";
                        v.lex.addRow(O);
                        break;
                    case Op_Suma:
                        O[0] = lex.line;
                        O[1] = lex.lexeme;
                        O[2] = "Operador aritmetico";
                        v.lex.addRow(O);
                        break;
                    case Op_Resta:
                        O[0] = lex.line;
                        O[1] = lex.lexeme;
                        O[2] = "Operador aritmetico";
                        v.lex.addRow(O);
                        break;
                    case Op_Multiplicacion:
                        O[0] = lex.line;
                        O[1] = lex.lexeme;
                        O[2] = "Operador aritmetico";
                        v.lex.addRow(O);
                        break;
                    case Op_asig:
                        O[0] = lex.line;
                        O[1] = lex.lexeme;
                        O[2] = "Operador asignación";
                        v.lex.addRow(O);
                        break;
                    case P_coma:
                        O[0] = lex.line;
                        O[1] = lex.lexeme;
                        O[2] = "Operador fin de sentencia";
                        v.lex.addRow(O);
                        break;
                    case Identificador:
                        O[0] = lex.line;
                        O[1] = lex.lexeme;
                        O[2] = tokens;
                        v.lex.addRow(O);
                        break;
                    case Numero:
                        O[0] = lex.line;
                        O[1] = lex.lexeme;
                        O[2] = tokens;
                        v.lex.addRow(O);
                        break;
                    default:
                        //System.out.print("aqui");
                        break;
                }
            }//while
        } catch (Exception e) {
            Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void analisisSintactico() {

        String ST = PanelFuente.getText();
        Sintax s = new Sintax(new Backend.LexerCup(new StringReader(ST)));
        PanelSalida.setText("");
        ventanaid.identi.setRowCount(0);
        nm.clear();

        try {
            banderax = false;
            s.banderaErrorGeneral = false;

            s.parse();
            if (banderax == true) {
                PanelSalida.setText(s.msj_ErroresProducidos);
                //System.out.print(s.errores_sin);
            } else if (s.banderaErrorGeneral == true) {
                PanelSalida.setText(s.msj_ErrorGeneral.toString());
            } else {
                PanelSalida.setText("Analisis Correcto");
            }
        } catch (Exception e) {
        }
    }

    public void cambiarAmbitos() {
        System.out.println(ventanaid.identi.getRowCount() + ", " + nm.size());
        for (int i = 0; i < ventanaid.identi.getRowCount(); i++) {
            for (int j = 0; j < nm.size(); j++) {
                if (ventanaid.identi.getValueAt(i, 4).equals(j + "")) {
                    ventanaid.identi.setValueAt(nm.get(j), i, 4);
                }
            }
        }
    }

    public String obtenerTipo(int linea, String lexema) {
        String tipo = "";
        String[] lineas;
        lineas = PanelFuente.getText().split("\n");
        String[] cadenas;
        cadenas = lineas[linea - 1].split(" ");
        for (int i = 0; i < cadenas.length; i++) {
            if (cadenas[i].equals(lexema)) {
                for (int j = 0; j < i; j++) {
                    tipo += cadenas[j] + " ";
                }
            }
        }
        if (!tipo.equals("")) {
            tipo.substring(0, tipo.length());
        }
        return tipo;
    }

    public String obtenerValor(int linea, String lexema) {
        String valor = "";

        String[] lineas;
        lineas = PanelFuente.getText().split("\n");
        String[] cadenas;
        cadenas = lineas[linea - 1].split(" ");
        for (int i = 0; i < cadenas.length; i++) {
            if (cadenas[i].equals("=")) {
                valor = cadenas[i + 1];
            }
        }

        if (!valor.equals("")) {
            valor = valor.substring(0, valor.length() - 1);
        }

        return valor;
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
        final AttributeSet attopurple = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, new Color(163, 73, 164));

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
                        if (text.substring(wordL, wordR).matches("(\\W)*(For|While|If|Else|event|KeyPlayed|;)")) {
                            setCharacterAttributes(wordL, wordR - wordL, attred, false);
                        } else if (text.substring(wordL, wordR).matches("(\\W)*(PIN_B6|star|int|long|Final|KP_Z|KP_X|KP_C|KP_V|KP_B|KP_N|KP_M|PIN_B0|PIN_B1|PIN_B2|PIN_B3|PIN_B4|PIN_B5)")) {
                            setCharacterAttributes(wordL, wordR - wordL, attblue, false);
                        } else if (text.substring(wordL, wordR).matches("(\\W)*(caso|retnot|delay_ms|output_N|output_high|output_low|Display|pulsa|!|=)")) {
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
        btnAnalisisLexico = new javax.swing.JButton();
        btnAnalisisSintactico = new javax.swing.JButton();
        btnCompilar = new javax.swing.JButton();
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
        btnLimpiarPS = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        btnMenuSalir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        btnMenuVariables = new javax.swing.JMenuItem();
        bntMenuIdentificadores = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        btnMenuLEATE = new javax.swing.JMenuItem();

        jMenuItem4.setText("jMenuItem4");

        jMenuItem6.setText("jMenuItem6");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(2000, 2000));
        setMinimumSize(new java.awt.Dimension(12, 12));
        setResizable(false);

        Fondo.setBackground(new java.awt.Color(255, 255, 255));
        Fondo.setMinimumSize(new java.awt.Dimension(12, 12));
        Fondo.setPreferredSize(new java.awt.Dimension(1000, 690));
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

        btnAnalisisLexico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Frontend/Imagenes/analisis lexico.png"))); // NOI18N
        btnAnalisisLexico.setToolTipText("Analisis Lexico");
        btnAnalisisLexico.setBorder(null);
        btnAnalisisLexico.setBorderPainted(false);
        btnAnalisisLexico.setContentAreaFilled(false);
        btnAnalisisLexico.setFocusable(false);
        btnAnalisisLexico.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAnalisisLexico.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Frontend/Imagenes/analisis lexico select.png"))); // NOI18N
        btnAnalisisLexico.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAnalisisLexico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalisisLexicoActionPerformed(evt);
            }
        });
        jToolBar1.add(btnAnalisisLexico);

        btnAnalisisSintactico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Frontend/Imagenes/Analisis sintactico.png"))); // NOI18N
        btnAnalisisSintactico.setToolTipText("Analisis Sintactico");
        btnAnalisisSintactico.setBorder(null);
        btnAnalisisSintactico.setBorderPainted(false);
        btnAnalisisSintactico.setContentAreaFilled(false);
        btnAnalisisSintactico.setFocusable(false);
        btnAnalisisSintactico.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAnalisisSintactico.setName(""); // NOI18N
        btnAnalisisSintactico.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Frontend/Imagenes/Analisis sintactico - select.png"))); // NOI18N
        btnAnalisisSintactico.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAnalisisSintactico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalisisSintacticoActionPerformed(evt);
            }
        });
        jToolBar1.add(btnAnalisisSintactico);

        btnCompilar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Frontend/Imagenes/compilar.png"))); // NOI18N
        btnCompilar.setToolTipText("Compilar");
        btnCompilar.setBorder(null);
        btnCompilar.setContentAreaFilled(false);
        btnCompilar.setFocusPainted(false);
        btnCompilar.setFocusable(false);
        btnCompilar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCompilar.setMaximumSize(new java.awt.Dimension(60, 50));
        btnCompilar.setMinimumSize(new java.awt.Dimension(60, 50));
        btnCompilar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Frontend/Imagenes/compilar-select.png"))); // NOI18N
        btnCompilar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCompilar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompilarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnCompilar);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Frontend/Imagenes/fondo  de aceesos rapidos.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setMaximumSize(new java.awt.Dimension(563, 50));
        jButton1.setMinimumSize(new java.awt.Dimension(480, 50));
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton1);

        Fondo.add(jToolBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1300, 50));

        PanelSalida.setColumns(20);
        PanelSalida.setRows(5);
        PanelSalida.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 51), 3));
        jScrollPane1.setViewportView(PanelSalida);

        Fondo.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 1000, 210));

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

        btnLimpiarPS.setText("Limpiar Panel Salida");
        btnLimpiarPS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarPSActionPerformed(evt);
            }
        });
        jMenu1.add(btnLimpiarPS);
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

        btnMenuVariables.setText("Lexemas");
        btnMenuVariables.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuVariablesActionPerformed(evt);
            }
        });
        jMenu3.add(btnMenuVariables);

        bntMenuIdentificadores.setText("Identificadores");
        bntMenuIdentificadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntMenuIdentificadoresActionPerformed(evt);
            }
        });
        jMenu3.add(bntMenuIdentificadores);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Acerca de");

        btnMenuLEATE.setText("Sobre LEATE");
        btnMenuLEATE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuLEATEActionPerformed(evt);
            }
        });
        jMenu4.add(btnMenuLEATE);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        //validar si el panel esta vacio antes de crear un nuevo archivo
        if (PanelFuente.getText().isEmpty()) {
            PanelFuente.setText("");
            PanelSalida.setText("");
            gdar.setURL("");
        } else {
            int num = JOptionPane.showConfirmDialog(null, "¿Deseas guardar el archivo?");
            if (num == 0) {
                gdar.guardar(PanelFuente.getText());
                PanelFuente.setText("");
                gdar.setURL("");
                JOptionPane.showMessageDialog(null, "Guardado con exito");
            } else if (num == 1) {
                PanelFuente.setText("");
                PanelSalida.setText("");
                gdar.setURL("");
            }
        }
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed
        //codigo para validar antes de abrir
        if (PanelFuente.getText().isEmpty()) {
            abrirsintexto();
        } else {
            int num = JOptionPane.showConfirmDialog(null, "¿Deseas guardar el archivo antes de abrir uno nuevo?");
            if (num == 0) {
                gdar.guardar(PanelFuente.getText());
                PanelFuente.setText("");
                gdar.setURL("");
                JOptionPane.showMessageDialog(null, "Guardado con exito");
                abrirsintexto();
            } else if (num == 1) {
                PanelFuente.setText("");
                PanelSalida.setText("");
                gdar.setURL("");
                abrirsintexto();
            }
        }
    }//GEN-LAST:event_btnAbrirActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        /*
            Manda a llamar el metodo y la clase para abrir el panel de guardar
         */
        gdar.guardar(PanelFuente.getText());
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnGuardarComoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarComoActionPerformed
        /*
            Manda a llamar el metodo y la clase para abrir el panel de guardar
         */
        gdar.guardarComo(PanelFuente.getText());
    }//GEN-LAST:event_btnGuardarComoActionPerformed

    private void btnMenuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuSalirActionPerformed
        //validar antes de salir
        if (PanelFuente.getText().isEmpty()) {
            dispose();
        } else {
            int num = JOptionPane.showConfirmDialog(null, "¿Deseas guardar el archivo antes de salir?");
            if (num == 0) {
                gdar.guardar(PanelFuente.getText());
                dispose();
            } else if (num == 1) {
                dispose();
            }
        }
    }//GEN-LAST:event_btnMenuSalirActionPerformed

    private void btnmenuNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmenuNuevoActionPerformed
        //validar si el panel esta vacio antes de crear un nuevo archivo
        if (PanelFuente.getText().isEmpty()) {
            PanelFuente.setText("");
            gdar.setURL("");
        } else {
            int num = JOptionPane.showConfirmDialog(null, "¿Deseas guardar el archivo?");
            if (num == 0) {
                gdar.guardar(PanelFuente.getText());
                PanelFuente.setText("");
                gdar.setURL("");
                JOptionPane.showMessageDialog(null, "Guardado con exito");
            } else if (num == 1) {
                PanelFuente.setText("");
                gdar.setURL("");
            }
        }
    }//GEN-LAST:event_btnmenuNuevoActionPerformed

    private void btnmenuAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmenuAbrirActionPerformed
        //codigo para validar antes de abrir
        if (PanelFuente.getText().isEmpty()) {
            abrirsintexto();
        } else {
            int num = JOptionPane.showConfirmDialog(null, "¿Deseas guardar el archivo antes de abrir uno nuevo?");
            if (num == 0) {
                gdar.guardar(PanelFuente.getText());
                PanelFuente.setText("");
                gdar.setURL("");
                JOptionPane.showMessageDialog(null, "Guardado con exito");
                abrirsintexto();
            } else if (num == 1) {
                PanelFuente.setText("");
                gdar.setURL("");
                abrirsintexto();
            }
        }
    }//GEN-LAST:event_btnmenuAbrirActionPerformed

    public void prueba(int xx, int yyy) {
        int x = 6;
        int y = 8;
    }

    public void prueba2(int xx, int yy) {
        int x = 6;
        int y = 8;
    }

    private void btnmenuGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmenuGuardarActionPerformed
        /*
            Manda a llamar el metodo y la clase para abrir el panel de guardar
         */
        gdar.guardar(PanelFuente.getText());
    }//GEN-LAST:event_btnmenuGuardarActionPerformed

    private void btnmenuGuardarComoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmenuGuardarComoActionPerformed
        /*
            Manda a llamar el metodo y la clase para abrir el panel de guardar
         */
        gdar.guardarComo(PanelFuente.getText());
    }//GEN-LAST:event_btnmenuGuardarComoActionPerformed

    private void btnAnalisisLexicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalisisLexicoActionPerformed

        PanelSalida.setText("");
        try {
            tablaLexemas();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al llenar las tablas");
        }
        v.setVisible(true);

        ventanaid.setVisible(true);
    }//GEN-LAST:event_btnAnalisisLexicoActionPerformed

    private void btnAnalisisSintacticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalisisSintacticoActionPerformed
        analisisSintactico();
        cambiarAmbitos();
        ventanaid.setVisible(true);
    }//GEN-LAST:event_btnAnalisisSintacticoActionPerformed

    private void btnMenuVariablesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuVariablesActionPerformed
        v.setVisible(true);

    }//GEN-LAST:event_btnMenuVariablesActionPerformed

    private void bntMenuIdentificadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntMenuIdentificadoresActionPerformed
        ventanaid.setVisible(true);
    }//GEN-LAST:event_bntMenuIdentificadoresActionPerformed

    private void btnMenuLEATEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuLEATEActionPerformed
        ac.setVisible(true);

    }//GEN-LAST:event_btnMenuLEATEActionPerformed

    private void btnCompilarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompilarActionPerformed
        PanelSalida.setText("");
        String ST = PanelFuente.getText();
        Sintax s = new Sintax(new Backend.LexerCup(new StringReader(ST)));
        String msj_lexicos = "";
        ventanaid.identi.setRowCount(0);
        nm.clear();
        try {
            banderax = false;
            s.banderaErrorGeneral = false;
            //Ejecutar el analisis lexico
            tablaLexemas();
            s.parse();
            cambiarAmbitos();
            if (banderax == true) {
                msj_lexicos = PanelSalida.getText();
                PanelSalida.setText(msj_lexicos + s.msj_ErroresProducidos);
                //System.out.print(s.errores_sin);
            } else if (s.banderaErrorGeneral == true) {
                msj_lexicos = PanelSalida.getText();
                PanelSalida.setText(msj_lexicos + s.msj_ErrorGeneral.toString());
            } else {
                PanelSalida.setText("Analisis Correcto");
            }
            
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al llenar las tablas");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error de programa");
        }
        
        v.setVisible(true);
        ventanaid.setVisible(true);
    }//GEN-LAST:event_btnCompilarActionPerformed

    private void btnLimpiarPSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarPSActionPerformed
        PanelSalida.setText("");
    }//GEN-LAST:event_btnLimpiarPSActionPerformed

    public void abrirsintexto() {
        //Metodo si no hay texto en el panel fuente para el boton abrir
        JFileChooser abrir = new JFileChooser();
        FileFilter filtro = new FileNameExtensionFilter("Archivos de texto (.txt)", "txt");
        abrir.setFileFilter(filtro);
        abrir.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        try {
            int num = abrir.showOpenDialog(this);
            if (num == 0) {
                File archivo = abrir.getSelectedFile();
                URL = archivo.toString();

                BufferedReader br = new BufferedReader(new FileReader(URL));

                String l = "";
                String aux = "";

                while (true) {
                    aux = br.readLine();
                    if (aux != null) {
                        l = l + aux + "\n";
                    } else {
                        break;
                    }
                }
                PanelFuente.setText(l);
                br.close();
                gdar.setURL(URL);
            } else {
                JOptionPane.showMessageDialog(this, "No se selecciono ningun archivo");
            }
        } catch (Exception ex) { //FileNotFoundException
            JOptionPane.showMessageDialog(this, "No se selecciono ningun archivo");
        }
    }

    public void cerrar() {
        //Validar cierre del programa para la X
        try {
            this.setDefaultCloseOperation(Interfaz.DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    if (PanelFuente.getText().isEmpty()) {
                        System.exit(0);
                    } else {
                        int num = JOptionPane.showConfirmDialog(null, "¿Deseas guardar el archivo antes de salir?");
                        if (num == 0) {
                            gdar.guardar(PanelFuente.getText());
                            System.exit(0);
                        } else if (num == 1) {
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
                try {
                    new Interfaz().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    //variable que contendra la ruta del archivo
    static String URL = "";

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JPanel Fondo;
    public static javax.swing.JTextPane PanelFuente;
    public static javax.swing.JTextArea PanelSalida;
    private javax.swing.JMenuItem bntMenuIdentificadores;
    private javax.swing.JButton btnAbrir;
    private javax.swing.JButton btnAnalisisLexico;
    private javax.swing.JButton btnAnalisisSintactico;
    private javax.swing.JButton btnCompilar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnGuardarComo;
    private javax.swing.JMenuItem btnLimpiarPS;
    private javax.swing.JMenuItem btnMenuLEATE;
    private javax.swing.JMenuItem btnMenuSalir;
    private javax.swing.JMenuItem btnMenuVariables;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JMenuItem btnmenuAbrir;
    private javax.swing.JMenuItem btnmenuGuardar;
    private javax.swing.JMenuItem btnmenuGuardarComo;
    private javax.swing.JMenuItem btnmenuNuevo;
    private javax.swing.JButton jButton1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JScrollPane jScrollPanelFuente;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}

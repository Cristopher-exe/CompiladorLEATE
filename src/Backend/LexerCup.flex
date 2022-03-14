
package Backend;
import java_cup.runtime.Symbol;

%%
%class LexerCup
%type java_cup.runtime.Symbol
%cup
%full
%line
%char
%ignorecase

// |---------------------EXPRESIONES---------------------|
LETRA = [a-zA-Z]
DIGITO = [0-9]
SIGNO = ["+","-"]
ESPACIO = [ \t,\r,\n,\f,\r\n]+
COMENTUNILINEA = "#".*

%{
    public Symbol symbol(int type, Object value){
        return new Symbol(type, yyline, yycolumn, value);
    }
    public Symbol symbol(int type){
        return new Symbol(type, yyline, yycolumn);
    }
%}
%%

{ESPACIO} {/*Ignorar*/}
{COMENTUNILINEA} {/*Ignorar*/}

/*Palabras Reservadas*/
(retnot) {return new Symbol(sym.retnot, yychar, yyline, yytext());}

(For) {return new Symbol(sym.For, yychar, yyline, yytext());}

(While) {return new Symbol(sym.While, yychar, yyline, yytext());}

(If) {return new Symbol(sym.If, yychar, yyline, yytext());}

(delay_ms) {return new Symbol(sym.delay_ms, yychar, yyline, yytext());}

(star) {return new Symbol(sym.star, yychar, yyline, yytext());}

(Else) {return new Symbol(sym.Else, yychar, yyline, yytext());}

(pulsa) {return new Symbol(sym.pulsa, yychar, yyline, yytext());}

(output_N) {return new Symbol(sym.output_N, yychar, yyline, yytext());}

/* CONSTANTES DE TECLADO*/

(KP_Z|KP_X|KP_C|KP_V|KP_B|KP_N|KP_M) {return new Symbol(sym.Kp_Teclado, yychar, yyline, yytext());}

(KeyPlayed) {return new Symbol(sym.KeyPlayed, yychar, yyline, yytext());}

(Display) {return new Symbol(sym.Display, yychar, yyline, yytext());}

(Final) {return new Symbol(sym.Final, yychar, yyline, yytext());}

(event) {return new Symbol(sym.event, yychar, yyline, yytext());}

(caso) {return new Symbol(sym.caso, yychar, yyline, yytext());}

(output_high) {return new Symbol(sym.output_high, yychar, yyline, yytext());}

(output_low) {return new Symbol(sym.output_low, yychar, yyline, yytext());}


/*--------------------------------------------------PINES-----------------------*/
(PIN_B0 | PIN_B1 | PIN_B2 | PIN_B3 | PIN_B4 | PIN_B5 | PIN_B6) {return new Symbol(sym.pines_B, yychar, yyline, yytext());}

/* Tipos de datos */
( int | long | bool ) {return new Symbol(sym.T_dato, yychar, yyline, yytext());}

/* Valores booleanos */

( verdadero ) {return new Symbol(sym.Valor_ver, yychar, yyline, yytext());}

( falso ) {return new Symbol(sym.Valor_fal, yychar, yyline, yytext());}

/* Operador Igual */
( "=" ) {return new Symbol(sym.Op_asig, yychar, yyline, yytext());}

/* Operador Suma */
( "+" ) {return new Symbol(sym.Op_Suma, yychar, yyline, yytext());}

/* Operador Resta */
( "-" ) {return new Symbol(sym.Op_Resta, yychar, yyline, yytext());}

/* Operador Multiplicacion */
( "*" ) {return new Symbol(sym.Op_Multiplicacion, yychar, yyline, yytext());}

/* Operador Division */
( "/" ) {return new Symbol(sym.Op_Division, yychar, yyline, yytext());}

/*Operadores Relacionales */
( ">" | "<" | "==" | "!=" | ">=" | "<=") {return new Symbol(sym.Op_relacional, yychar, yyline, yytext());}

/* Operadores Incremento y decremento */
( "++" | "--" ) {return new Symbol(sym.Op_in_de_cremento, yychar, yyline, yytext());}

/* Parentesis de apertura */
( "(" ) {return new Symbol(sym.parentesis_a, yychar, yyline, yytext());}

/* Parentesis de cierre */
( ")" ) {return new Symbol(sym.parentesis_c, yychar, yyline, yytext());}

/* Llave de apertura */
( "{" ) {return new Symbol(sym.Llave_a, yychar, yyline, yytext());}

/* Llave de cierre */
( "}" ) {return new Symbol(sym.Llave_c, yychar, yyline, yytext());}

/* Corchete de apertura */
( "[" ) {return new Symbol(sym.Corchete_a, yychar, yyline, yytext());}

/* Corchete de cierre */
( "]" ) {return new Symbol(sym.Corchete_c, yychar, yyline, yytext());}

/* Punto y coma */
( ";" ) {return new Symbol(sym.P_coma, yychar, yyline, yytext());}

(":") {return new Symbol(sym.dosPuntos, yychar, yyline, yytext());}

(".") {return new Symbol(sym.TK_punto, yychar, yyline, yytext());}

("?") {return new Symbol(sym.Sig_Agru, yychar, yyline, yytext());}

//PRODUCCIONES PARA ERRORES

// |-------------------- RECONOCER EXPRESIONES --------------------| //
//Identificadores
{LETRA}({LETRA}|{DIGITO}|_)* {return new Symbol(sym.Identificador, yychar, yyline, yytext());}

//Num
{DIGITO}+|({SIGNO}{DIGITO}+) |({DIGITO}+"."{DIGITO}+) | (({DIGITO}+"."{DIGITO}+)([eE][-+]?{DIGITO}+)) {return new Symbol(sym.Numero, yychar, yyline, yytext());}

/* Error de analisis */
 . {return new Symbol(sym.ERRORL_000, yychar, yyline, yytext());}




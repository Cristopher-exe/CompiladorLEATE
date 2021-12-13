
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
SIMBOLO = [@!$%&?¡]
ACENTO = [ñÑáéíóúÁÉÍÓÚ]
COMENTUNILINEA = "#".*

%{
    public Symbol symbol(int type, object value){
        return new Symbol(type, yyline, yycolumn, value);
    }
    public Symbol symbol(int type){
        return new Symbol(type, yyline, yycolumn);
    }
%}
%

{ESPACIO} {/*Ignorar*/}
{COMENTUNILINEA} {/*Ignorar*/}

/*Palabras Reservadas*/
(retnot) {return new Symbol(sym.retnot, yychar, yyline, yytext());}

(for) {return new Symbol(sym.for, yychar, yyline, yytext());}

(while) {return new Symbol(sym.while, yychar, yyline, yytext());}

(if) {return new Symbol(sym.if, yychar, yyline, yytext());}

(delay_ms) {return new Symbol(sym.delay_ms, yychar, yyline, yytext());}

(start) {return new Symbol(sym.start, yychar, yyline, yytext());}

(else) {return new Symbol(sym.else, yychar, yyline, yytext());}

(pulsa) {return new Symbol(sym.pulsa, yychar, yyline, yytext());}

(output_N) {return new Symbol(sym.output_N, yychar, yyline, yytext());}

(KP_Z) {return new Symbol(sym.KP_Z, yychar, yyline, yytext());}

(KP_X) {return new Symbol(sym.KP_X, yychar, yyline, yytext());}

(KP_C){return new Symbol(sym.KP_C, yychar, yyline, yytext());}

(KP_V) {return new Symbol(sym.KP_V, yychar, yyline, yytext());}

(KP_B) {return new Symbol(sym.KP_B, yychar, yyline, yytext());}

(KP_N) {return new Symbol(sym.KP_N, yychar, yyline, yytext());}

(KP_M) {return new Symbol(sym.KP_M, yychar, yyline, yytext());}

(KeyPlayed) {return new Symbol(sym.KeyPlayed, yychar, yyline, yytext());}

(Display) {return new Symbol(sym.Display, yychar, yyline, yytext());}

(Final) {return new Symbol(sym.Final, yychar, yyline, yytext());}

(event) {return new Symbol(sym.event, yychar, yyline, yytext());}

(caso) {return new Symbol(sym.caso, yychar, yyline, yytext());}

(output_high) {return new Symbol(sym.output_high, yychar, yyline, yytext());}

(output_low) {return new Symbol(sym.output_low, yychar, yyline, yytext());}

(PIN_B0) {return new Symbol(sym.PIN_B0, yychar, yyline, yytext());}

(PIN_B1) {return new Symbol(sym.PIN_B1, yychar, yyline, yytext());}

(PIN_B2) {return new Symbol(sym.PIN_B2, yychar, yyline, yytext());}
 
(PIN_B3) {return new Symbol(sym.PIN_B3, yychar, yyline, yytext());}

(PIN_B4) {return new Symbol(sym.PIN_B4, yychar, yyline, yytext());}

(PIN_B5) {return new Symbol(sym.PIN_B5, yychar, yyline, yytext());}

(PIN_B6) {return new Symbol(sym.PIN_B6, yychar, yyline, yytext());}

/* Tipos de datos */
( int | long ) {return new Symbol(sym.T_dato, yychar, yyline, yytext());}

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
( "++" | "--" ) {return new Symbol(sym.Op_incremento, yychar, yyline, yytext());}

/* Parentesis de apertura */
( "(" ) {return new Symbol(sym.Parentesis_a, yychar, yyline, yytext());}

/* Parentesis de cierre */
( ")" ) {return new Symbol(sym.Parentesis_c, yychar, yyline, yytext());}

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

(",") {return new Symbol(sym.coma, yychar, yyline, yytext());}

// |-------------------- RECONOCER EXPRESIONES --------------------| //
//Identificadores
{LETRA}({LETRA}|{DIGITO}|_)+ {return new Symbol(sym.Identificador, yychar, yyline, yytext());}

//Num
{DIGITO}+|({SIGNO}{DIGITO}+) |({DIGITO}+"."{DIGITO}+) | (({DIGITO}+"."{DIGITO}+)([eE][-+]?{DIGITO}+)) {return new Symbol(sym.Numero, yychar, yyline, yytext());}

/* Error de analisis */
 . {return new Symbol(sym.ERROR, yychar, yyline, yytext());}




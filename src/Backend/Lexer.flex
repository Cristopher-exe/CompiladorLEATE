package Backend;
import static Backend.Tokens.*;

%%
%class lexer
%type Tokens
%ignorecase
%{
    public String lexeme;
    public int line;
%}
%init{
    yyline = 1;
%init}
%line

// |---------------------EXPRESIONES---------------------|
LETRA = [a-zA-Z]
DIGITO = [0-9]
SIGNO = ["+","-"]
ESPACIO = [ \t,\r,\n,\f,\r\n]+
SIMBOLO = [@!$%&¡]
ACENTO = [ñÑáéíóúÁÉÍÓÚ]
COMENTUNILINEA = "#".*
%%

{ESPACIO} {/*Ignorar*/}
{COMENTUNILINEA} {/*Ignorar*/}

//PALABRAS RESERVADAS
retnot {lexeme=yytext(); line=yyline; return retnot;}
For {lexeme=yytext(); line=yyline; return For;}
While {lexeme=yytext(); line=yyline; return While;}
If {lexeme=yytext(); line=yyline; return If;}
delay_ms {lexeme=yytext(); line=yyline; return delay_ms;}
star {lexeme=yytext(); line=yyline; return star;}
Else {lexeme=yytext(); line=yyline; return Else;}
int {lexeme=yytext(); line=yyline; return T_dato;}
long {lexeme=yytext(); line=yyline; return T_dato;}
bool {lexeme=yytext(); line=yyline; return T_dato;}
verdadero {lexeme=yytext(); line=yyline; return Valor_ver;}
falso {lexeme=yytext(); line=yyline; return Valor_fal;}
pulsa {lexeme=yytext(); line=yyline; return pulsa;}
output_N {lexeme=yytext(); line=yyline; return output_N;}
KP_Z {lexeme=yytext(); line=yyline; return Kp_Teclado;}
KP_X {lexeme=yytext(); line=yyline; return Kp_Teclado;}
KP_C {lexeme=yytext(); line=yyline; return Kp_Teclado;}
KP_V {lexeme=yytext(); line=yyline; return Kp_Teclado;}
KP_B {lexeme=yytext(); line=yyline; return Kp_Teclado;}
KP_N {lexeme=yytext(); line=yyline; return Kp_Teclado;}
KP_M {lexeme=yytext(); line=yyline; return Kp_Teclado;}
KeyPlayed {lexeme=yytext(); line=yyline; return KeyPlayed;}
Display {lexeme=yytext(); line=yyline; return Display;}
Final {lexeme=yytext(); line=yyline; return Final;}
event {lexeme=yytext(); line=yyline; return event;}
caso {lexeme=yytext(); line=yyline; return caso;}
output_high {lexeme=yytext(); line=yyline; return output_high;}
output_low {lexeme=yytext(); line=yyline; return output_low;}
PIN_B0 {lexeme=yytext(); line=yyline; return pines_B;}
PIN_B1 {lexeme=yytext(); line=yyline; return pines_B;}
PIN_B2 {lexeme=yytext(); line=yyline; return pines_B;}
PIN_B3 {lexeme=yytext(); line=yyline; return pines_B;}
PIN_B4 {lexeme=yytext(); line=yyline; return pines_B;}
PIN_B5 {lexeme=yytext(); line=yyline; return pines_B;}
PIN_B6 {lexeme=yytext(); line=yyline; return pines_B;}

";" {lexeme=yytext(); line=yyline; return P_coma;}
"." {lexeme=yytext(); line=yyline; return TK_punto;}
":" {lexeme=yytext(); line=yyline; return dosPuntos;}
"{" {lexeme=yytext(); line=yyline; return Llave_a;}
"}" {lexeme=yytext(); line=yyline; return Llave_c;}
"[" {lexeme=yytext(); line=yyline; return Corchete_a;}
"]" {lexeme=yytext(); line=yyline; return Corchete_c;}
"(" {lexeme=yytext(); line=yyline; return parentesis_a;}
")" {lexeme=yytext(); line=yyline; return parentesis_c;}
"¿" {lexeme=yytext(); line=yyline; return Sig_Agru;}
"?" {lexeme=yytext(); line=yyline; return Sig_Agru;}
"++" {lexeme=yytext(); line=yyline; return Op_incremento;}
"--" {lexeme=yytext(); line=yyline; return Op_decremento;}
">=" {lexeme=yytext(); line=yyline; return Op_relacional;} 
">" {lexeme=yytext(); line=yyline; return Op_relacional;}
"<=" {lexeme=yytext(); line=yyline; return Op_relacional;}
"<" {lexeme=yytext(); line=yyline; return Op_relacional;}
"==" {lexeme=yytext(); line=yyline; return Op_relacional;}

"+" {lexeme=yytext(); line=yyline; return Op_Suma;}
"-" {lexeme=yytext(); line=yyline; return Op_Resta;}
"*" {lexeme=yytext(); line=yyline; return Op_Multiplicacion;}
"/" {lexeme=yytext(); line=yyline; return Op_Division;}

"!="  {lexeme=yytext(); line=yyline; return Op_relacional;}
"=" {lexeme=yytext(); line=yyline; return Op_asig;}

// |-------------------- RECONOCER EXPRESIONES --------------------| //
//Identificadores
{LETRA}({LETRA}|{DIGITO}|_)* {lexeme=yytext(); line=yyline; return Identificador;}

//Num
{DIGITO}+|({SIGNO}{DIGITO}+) |({DIGITO}+"."{DIGITO}+) | (({DIGITO}+"."{DIGITO}+)([eE][-+]?{DIGITO}+)) {lexeme=yytext(); line=yyline; return Numero;}

// // |-------------------- RECONOCER ERRORES --------------------| //
// Identificadores
//identificador no comienza con digito
{DIGITO}+({LETRA}|{DIGITO}|_)+ {lexeme=yytext(); line=yyline; return ERRORL_001;}

//identificador no debe contener simbolos especiales
({ACENTO}|{SIMBOLO})(({LETRA}|{SIMBOLO}|{ACENTO}))+ {lexeme=yytext(); line=yyline; return ERRORL_002;}

// Flotantes
// 12.12.12...
{DIGITO}+"."{DIGITO}+("."{DIGITO}*)+ {lexeme=yytext(); line=yyline; return ERRORL_003;}

// .12e12 / .12e / .12  | 12.23e-23.12
("."{DIGITO}+([eE][-+]{DIGITO}*)) | ({DIGITO}+"."{DIGITO}+([eE][-+])({DIGITO}*"."{DIGITO}*))* {lexeme=yytext(); line=yyline; return ERRORL_004;}

// 12ab.12 | ab12.12
({DIGITO}+{LETRA}+"."{DIGITO}+) | ({LETRA}+{DIGITO}+"."{DIGITO}+) {lexeme=yytext(); line=yyline; return ERRORL_005;}

// 12.12ab | 12.ab12
({DIGITO}+"."{DIGITO}+{LETRA}+) | ({DIGITO}+"."{LETRA}+{DIGITO}+) {lexeme=yytext(); line=yyline; return ERRORL_006;}

// ab.12ab | ab.ab12
({LETRA}+"."{DIGITO}+{LETRA}+) | ({LETRA}+"."{LETRA}+{DIGITO}+) {lexeme=yytext(); line=yyline; return ERRORL_007;}

// 12. | 12e.
({DIGITO}+{LETRA}*"."{LETRA}+)|({DIGITO}+{LETRA}*".") {lexeme=yytext(); line=yyline; return ERRORL_008;}

// 3,14
({DIGITO}+","{DIGITO}+) {lexeme=yytext(); line=yyline; return ERRORL_009;}

//
({LETRA}+"."{DIGITO}+) {lexeme=yytext(); line=yyline; return ERRORL_010;}

//Nuevos Errores
//Un numero no debe comenzar con simbolos especiales
({ACENTO}|{SIMBOLO}){DIGITO}+|({SIGNO}{DIGITO}+) |({DIGITO}+"."{DIGITO}+) | (({DIGITO}+"."{DIGITO}+)([eE][-+]?{DIGITO}+)) {lexeme=yytext(); line=yyline; return ERRORL_011;}

////Un numero no debe contener simbolos especiales
{DIGITO}+({ACENTO}|{SIMBOLO}){DIGITO}+|({SIGNO}{DIGITO}+) {lexeme=yytext(); line=yyline; return ERRORL_012;}

////Un numero no debe comenzar con guion bajo
"_"{DIGITO}+|({SIGNO}"_"{DIGITO}+) |("_"{DIGITO}+"."{DIGITO}+) | (("_"{DIGITO}+"."{DIGITO}+)([eE][-+]?{DIGITO}+)) {lexeme=yytext(); line=yyline; return ERRORL_013;}

//Un identificador no comienza con guin bajo
"_"{DIGITO}+({LETRA}|{DIGITO}|"_")* {lexeme=yytext(); line=yyline; return ERRORL_014;}

//Un numero no debe contener letras
({DIGITO}+{LETRA}+) {lexeme=yytext(); line=yyline; return ERRORL_015;}

//Un identificador no puede contener puntos
{LETRA}"."({LETRA}|{DIGITO}|_)*|{LETRA}({LETRA}"."|{DIGITO}|_)*|{LETRA}({LETRA}|{DIGITO}"."|_)* {lexeme=yytext(); line=yyline; return ERRORL_016;}
///Error por defecto
. {lexeme=yytext(); line=yyline; return ERRORL_000;} 
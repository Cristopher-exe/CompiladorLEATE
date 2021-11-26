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
SIMBOLO = [@!$%&?¡]
ACENTO = [ñÑáéíóúÁÉÍÓÚ]
COMENTUNILINEA = "#".*
COMENMULTILINEA = ['!/\*.*?\*/!s']
%%

{ESPACIO} {/*Ignorar*/}
{COMENTUNILINEA} {/*Ignorar*/}
COMENMULTILINEA {/*Ignorar*/}

retnot|for|while|if|delay_ms|start|else|int|long|pulsa|output_N|KP_Z|KP_X|KP_C|
KP_V|KP_B|KP_N|KP_M|KeyPlayed|Display|Final|event|caso|output_high|output_low|
PIN_BO|PIN_B1|PIN_B2|PIN_B3|PIN_B4|PIN_B5|PIN_B6 {lexeme=yytext(); line=yyline; return Reservada;}

";" {lexeme=yytext(); line=yyline; return TK_Sig_Punt;}
"." {lexeme=yytext(); line=yyline; return TK_Sig_Punt;}
":" {lexeme=yytext(); line=yyline; return TK_Sig_Punt;}
"'" {lexeme=yytext(); line=yyline; return TK_Sig_Punt;}
"," {lexeme=yytext(); line=yyline; return TK_Sig_Punt;}
"{" {lexeme=yytext(); line=yyline; return TK_Sig_Agrup;}
"}" {lexeme=yytext(); line=yyline; return TK_Sig_Agrup;}
"[" {lexeme=yytext(); line=yyline; return TK_Sig_Agrup;}
"]" {lexeme=yytext(); line=yyline; return TK_Sig_Agrup;}
"(" {lexeme=yytext(); line=yyline; return TK_Sig_Agrup;}
")" {lexeme=yytext(); line=yyline; return TK_Sig_Agrup;}
"¿" {lexeme=yytext(); line=yyline; return TK_Sig_Agrup;}
"?" {lexeme=yytext(); line=yyline; return TK_Sig_Agrup;}
"++" {lexeme=yytext(); line=yyline; return TK_Op_Incremento;}
"--" {lexeme=yytext(); line=yyline; return TK_Op_Disminucion;}
">=" {lexeme=yytext(); line=yyline; return TK_Op_Relacional;} 
">" {lexeme=yytext(); line=yyline; return TK_Op_Relacional;}
"<=" {lexeme=yytext(); line=yyline; return TK_Op_Relacional;}
"<" {lexeme=yytext(); line=yyline; return TK_Op_Relacional;}
"==" {lexeme=yytext(); line=yyline; return TK_Op_Relacional;}

"+" {lexeme=yytext(); line=yyline; return TK_Op_Arit;}
"-" {lexeme=yytext(); line=yyline; return TK_Op_Arit;}
"*" {lexeme=yytext(); line=yyline; return TK_Op_Arit;}
"/" {lexeme=yytext(); line=yyline; return TK_Op_Arit;}

"!="  {lexeme=yytext(); line=yyline; return TK_Op_Desigual;}
"=" {lexeme=yytext(); line=yyline; return TK_Op_Asig;}

// |-------------------- RECONOCER EXPRESIONES --------------------| //
//Identificadores
{LETRA}({LETRA}|{DIGITO}|_)+ {lexeme=yytext(); line=yyline; return IDENTIFICADOR;}

//Num
{DIGITO}+|({SIGNO}{DIGITO}+) |({DIGITO}+"."{DIGITO}+) | (({DIGITO}+"."{DIGITO}+)([eE][-+]?{DIGITO}+)) {lexeme=yytext(); line=yyline; return Num;}

// // |-------------------- RECONOCER ERRORES --------------------| //
// Identificadores
//identificador no comienza con digito
{DIGITO}+({LETRA}|{DIGITO})+ {lexeme=yytext(); line=yyline; return ERRORL_001;}

//identificador no lleva simbolos
({ACENTO}|{SIMBOLO})(({LETRA}|{DIGITO}|{SIMBOLO}|{ACENTO}))+ {lexeme=yytext(); line=yyline; return ERRORL_002;}


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
({DIGITO}+{LETRA}*".")|({DIGITO}+{LETRA}*"."{LETRA}+) {lexeme=yytext(); line=yyline; return ERRORL_008;}

// 3,14
({DIGITO}+","{DIGITO}+) {lexeme=yytext(); line=yyline; return ERRORL_009;}

//
({LETRA}+"."{DIGITO}+) {lexeme=yytext(); line=yyline; return ERRORL_010;}

//Error por defecto
. {lexeme=yytext(); line=yyline; return ERRORL_000;} 
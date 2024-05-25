package Analizador;

import compilerTools.TextColor;
import java.awt.Color;
import static Analizador.Tokens.*;
%%
%class LexerColor
%type TextColor
%char
L=[a-zA-Z_]+
D=[0-9]+
espacio=[ \t \r]+
%{
    private TextColor textColor(long start, int size, Color color){
        return new TextColor((int) start, size, color);
    }
%}

/* Espacios en blanco */
{espacio} {/*Ignore*/}

/* Marcador break*/
( "break" ) { return textColor(yychar, yylength(), new Color(146, 146, 146));}

/* Marcador system*/
( "system" ) { return textColor(yychar, yylength(), new Color(146, 146, 146));}

/* Tipo de dato String */
( string ) { return textColor(yychar, yylength(), new Color(146, 146, 146));}

/* Marcador de casos*/
( "case" ) { return textColor(yychar, yylength(), new Color(146, 146, 146));}

/* Printf */
( "printf" ) { return textColor(yychar, yylength(), new Color(146, 146, 146));}

/* Scanf */
( "scanf" ) { return textColor(yychar, yylength(), new Color(146, 146, 146));}

/* Comentarios */
( "//"(.)* | "/"(.)* ) {/*Ignore*/}

/* Cadena - texto entre comillas*/
L?\"(\\.|[^\\\"])*\" { return textColor(yychar, yylength(), new Color(146, 146, 146));}

/* Comillas */
( "\"") { return textColor(yychar, yylength(), new Color(146, 146, 146));}

/* Comilla simple*/
( "'") { return textColor(yychar, yylength(), new Color(146, 146, 146));}

/* Marcador de constante*/
( "const" ) { return textColor(yychar, yylength(), new Color(146, 146, 146));}

/* Marcador continue*/
( "continue" ) { return textColor(yychar, yylength(), new Color(146, 146, 146));}

/* Corchete de apertura */
( "[" ) { return textColor(yychar, yylength(), new Color(255, 0, 0));}

/* Corchete de cierre */
( "]" ) { return textColor(yychar, yylength(), new Color(146, 146, 146));}

/* Marcador por defecto*/
( "default" ) { return textColor(yychar, yylength(), new Color(146, 146, 146));}

/* Marcador define*/
( "define" ) { return textColor(yychar, yylength(), new Color(146, 146, 146));}

/* Marcador while*/
( "while" ) { return textColor(yychar, yylength(), new Color(0, 55, 255));}

/* Operador Division*/
( "/" ) { return textColor(yychar, yylength(), new Color(146, 146, 146));}

/* Salto, tabulacion y espacio */
( "\\n" | "\\t" ) {/*Ignore*/}

/* Marcador Do*/
( "do" ) { return textColor(yychar, yylength(), new Color(146, 146, 146));}

/* Double */
(double) { return textColor(yychar, yylength(), new Color(146, 146, 146));}

/* Marcador Else*/
( "else" ) { return textColor(yychar, yylength(), new Color(146, 146, 146));}

/* Ciclo repetitivo for */
( "for" ) { return textColor(yychar, yylength(), new Color(255, 0, 0));}

/* Condicional if */
( "if" ) { return textColor(yychar, yylength(), new Color(146, 146, 146));}

/* Comparador Mayor igual*/
( ">=" ) { return textColor(yychar, yylength(), new Color(146, 146, 146));}

/* Comparador Menor igual*/
( "<=" ) { return textColor(yychar, yylength(), new Color(146, 146, 146));}

/* Operador Más igual*/
( "+=" ) { return textColor(yychar, yylength(), new Color(146, 146, 146));}

/* Operador Menos igual*/
( "-=" ) { return textColor(yychar, yylength(), new Color(146, 146, 146));}

/* Operador Multiplica igual*/
( "*=" ) { return textColor(yychar, yylength(), new Color(146, 146, 146));}

/* Operador Division igual*/
( "/=" ) { return textColor(yychar, yylength(), new Color(146, 146, 146));}

/* Operador Comparador igual*/
( "==" ) { return textColor(yychar, yylength(), new Color(146, 146, 146));}

/* Operador Diferente */
( "!=" ) { return textColor(yychar, yylength(), new Color(146, 146, 146));}

/* Operador Negador*/
( "!" ) { return textColor(yychar, yylength(), new Color(146, 146, 146));}

/* Incremento */
( "++" ) { return textColor(yychar, yylength(), new Color(146, 146, 146));}

/* Decremento*/
( "--" ) { return textColor(yychar, yylength(), new Color(146, 146, 146));}

/* Operador Igual */
( "=" ) { return textColor(yychar, yylength(), new Color(146, 146, 146));}

/* Doble mayor*/
( ">>" ) { return textColor(yychar, yylength(), new Color(146, 146, 146));}

/* Modulo igual*/
( "%=" ) { return textColor(yychar, yylength(), new Color(146, 146, 146));}

/* Doble menor*/
( "<<" ) { return textColor(yychar, yylength(), new Color(146, 146, 146));}

/* Operador Mayor que */
( ">" ) { return textColor(yychar, yylength(), new Color(146, 146, 146));}

/* Operador Menor que */
( "<" ) { return textColor(yychar, yylength(), new Color(146, 146, 146));}

/* Signo dos puntos*/
( ":" ) { return textColor(yychar, yylength(), new Color(146, 146, 146));}

/* operador y logico*/
( "&&" ) { return textColor(yychar, yylength(), new Color(146, 146, 146));}

/* operador bitand*/
( "&" ) { return textColor(yychar, yylength(), new Color(146, 146, 146));}

/* operador o logico*/
( "||" ) { return textColor(yychar, yylength(), new Color(146, 146, 146));}

/* operador bitor*/
( "|" ) { return textColor(yychar, yylength(), new Color(146, 146, 146));}

/* Integer */
(int) { return textColor(yychar, yylength(), new Color(146, 146, 146));}

/* Bool */
(bool) { return textColor(yychar, yylength(), new Color(146, 146, 146));}

/* Long */
(long) { return textColor(yychar, yylength(), new Color(146, 146, 146));}

/* Short*/
(short) { return textColor(yychar, yylength(), new Color(146, 146, 146));}

/* Float*/
(float) { return textColor(yychar, yylength(), new Color(146, 146, 146));}

/* Byte*/
(byte) { return textColor(yychar, yylength(), new Color(146, 146, 146));}

/* Char*/
(char) { return textColor(yychar, yylength(), new Color(146, 146, 146));}

/* Marcador include */
( "include" ) { return textColor(yychar, yylength(), new Color(146, 146, 146));}

/* Marcador namespace */
( "namespace" ) { return textColor(yychar, yylength(), new Color(146, 146, 146));}

/* Marcador std */
( "std" ) { return textColor(yychar, yylength(), new Color(146, 146, 146));}

/* Marcador iosteam */
( "iostream" ) { return textColor(yychar, yylength(), new Color(146, 146, 146));}

/* Marcador using */
( "using" ) { return textColor(yychar, yylength(), new Color(146, 146, 146));}

/* Marcador false*/
( "false" ) { return textColor(yychar, yylength(), new Color(146, 146, 146));}

/* Marcador true*/
( "true" ) { return textColor(yychar, yylength(), new Color(146, 146, 146));}

/* Salto de linea endl*/
( "endl" ) { return textColor(yychar, yylength(), new Color(146, 146, 146));}

/* Salto de linea */
( "\n" ) {return textColor(yychar, yylength(), new Color(146, 146, 146));}

/* Llave de apertura */
( "{" ) { return textColor(yychar, yylength(), new Color(146, 146, 146));}

/* Llave de cierre */
( "}" ) { return textColor(yychar, yylength(), new Color(146, 146, 146));}

/* Marcador de inicio de algoritmo */
( "main" ) { return textColor(yychar, yylength(), new Color(146, 146, 146));}

/* Marcador register*/
( "register" ) { return textColor(yychar, yylength(), new Color(146, 146, 146));}

/* Salida por consola*/
( "cout" ) { return textColor(yychar, yylength(), new Color(146, 146, 146));}

/* Marcador Void*/
( "void" ) { return textColor(yychar, yylength(), new Color(146, 146, 146));}

/* Marcador Typedef*/
( "typedef" ) { return textColor(yychar, yylength(), new Color(146, 146, 146));}

/* Marcador switch*/
( "switch" ) { return textColor(yychar, yylength(), new Color(146, 146, 146));}

/* Marcador unsigned*/
( "unsigned" ) { return textColor(yychar, yylength(), new Color(146, 146, 146));}

/* Entrada por consola */
( "cin" ) { return textColor(yychar, yylength(), new Color(146, 146, 146));}

/* Operador Multiplicación */
( "*" ) { return textColor(yychar, yylength(), new Color(146, 146, 146));}

/* Operador Modulo*/
( "%" ) { return textColor(yychar, yylength(), new Color(146, 146, 146));}

/* Numeral # */
( "#" ) { return textColor(yychar, yylength(), new Color(146, 146, 146));}

/* Parentesis de apertura */
( "(" ) { return textColor(yychar, yylength(), new Color(146, 146, 146));}

/* Parentesis de cierre */
( ")" ) { return textColor(yychar, yylength(), new Color(146, 146, 146));}

/* P_coma */
( ";" ) { return textColor(yychar, yylength(), new Color(146, 146, 146));}

/* punto */
( "." ) { return textColor(yychar, yylength(), new Color(146, 146, 146));}

/* coma */
( "," ) { return textColor(yychar, yylength(), new Color(146, 146, 146));}

/* Operador Resta */
( "-" ) { return textColor(yychar, yylength(), new Color(146, 146, 146));}

/* Return */
( "return" ) { return textColor(yychar, yylength(), new Color(146, 146, 146));}

/* Operador Suma */
( "+" ) { return textColor(yychar, yylength(), new Color(146, 146, 146));}

/* Identificador */
{L}({L}|{D})* { return textColor(yychar, yylength(), new Color(146, 146, 146));}

/* Numero */
("-("{D}+")") | ("-("{D}+.{D}+")") | -({D})+ | {D}+ | {D}+.{D}+ | -{D}+.{D}+ { return Numero;}

/* Error de analisis */
 . {return textColor(yychar, yylength(), new Color(146, 146, 146));}
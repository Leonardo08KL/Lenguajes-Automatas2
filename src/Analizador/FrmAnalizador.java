package Analizador;

import compilerTools.Directory;
import compilerTools.ErrorLSSL;
import compilerTools.Functions;
import compilerTools.Production;
import compilerTools.TextColor;
import compilerTools.Token;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.runtime.Symbol;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jhony Alejandro Caro Junio 2022
 */
public class FrmAnalizador extends javax.swing.JFrame {

    private Script script;
    private ArrayList<TextColor> textsColor;
    private String title;
    private Directory directorio;
    private ArrayList<Token> tokens;
    private ArrayList<ErrorLSSL> errors;
    private Timer timerKeyReleased;
    private ArrayList<Production> identProd;
    private HashMap<String, String> identificadores;
    private boolean codeHasBeenCompiled = false;

    public FrmAnalizador() {
        initComponents();
        init();
        this.script = new Script("C:\\Program Files (x86)\\Embarcadero\\Dev-Cpp\\TDM-GCC-64\\bin\\");
    }

    private void init() {
        title = "Compilador Lenguajes y Automatas 2";
        setLocationRelativeTo(null);
        setTitle(title);
        directorio = new Directory(this, Resultado, title, ".robo");
        addWindowListener(new WindowAdapter() {// Cuando presiona la "X" de la esquina superior derecha
            @Override
            public void windowClosing(WindowEvent e) {
                directorio.Exit();
                System.exit(0);
            }
        });
        Functions.setLineNumberOnJTextComponent(Resultado);
        timerKeyReleased = new Timer((int) (1000 * 0.3), (ActionEvent e) -> {
            timerKeyReleased.stop();
            colorAnalysis();
        });
        Functions.insertAsteriskInName(this, Resultado, () -> {
            timerKeyReleased.restart();
        });
        tokens = new ArrayList<>();
        errors = new ArrayList<>();
        textsColor = new ArrayList<>();
        identProd = new ArrayList<>();
        identificadores = new HashMap<>();
        Functions.setAutocompleterJTextComponent(new String[]{"número", "color", "adelante", "atrás",
            "izquierda", "derecha", "norte", "sur", "este", "oeste", "pintar", "detenerPintar",
            "tomar", "poner", "lanzarMoneda"}, Resultado, () -> {
            timerKeyReleased.restart();
        });
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Resultado = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAnalizarSin = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        BotonSintactico = new javax.swing.JButton();
        BotonAnalisis = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setForeground(java.awt.Color.black);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jScrollPane2.setViewportView(Resultado);

        txtAnalizarSin.setColumns(20);
        txtAnalizarSin.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtAnalizarSin.setRows(5);
        jScrollPane3.setViewportView(txtAnalizarSin);

        tabla.setBackground(new java.awt.Color(204, 255, 204));
        tabla.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tabla.setForeground(new java.awt.Color(0, 0, 0));
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {

            }
        ));
        tabla.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane4.setViewportView(tabla);

        BotonSintactico.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        BotonSintactico.setText("Análisis Sintático");
        BotonSintactico.setActionCommand("Análisis Sintático -");
        BotonSintactico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonSintacticoActionPerformed(evt);
            }
        });

        BotonAnalisis.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        BotonAnalisis.setText("Análisis Léxico");
        BotonAnalisis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAnalisisActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BotonSintactico, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BotonAnalisis, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 816, Short.MAX_VALUE))))
                .addGap(35, 35, 35))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonAnalisis, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonSintactico, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28))
        );

        jMenu1.setText("Archivo");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Exit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void analizarLexico() throws IOException {
        int cont = 1;
        int no = 1;
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"No.", "Token", "Tipo", "LINEA"});
        String expr = (String) Resultado.getText();
        Lexico lexicos = new Lexico(new StringReader(expr));
        String resultado = "NO. LINEA \t\tSIMBOLO\nLINEA " + cont + "\n";

        while (true) {
            Tokens token = lexicos.yylex();
            if (token == null) {
                JTable table = new JTable(model);
                JScrollPane scrollPane = new JScrollPane(table);
                getContentPane().add(scrollPane);
                return;
            }

            Object[] row = new Object[4];
            row[0] = no++;
            row[3] = cont;

            switch (token) {
                // Casos para cada tipo de token
                case STRING_LITERAL:
                    row[1] = "Cadena";
                    row[2] = lexicos.lexemas;
                    break;
                case Comillas:
                    row[1] = "Comillas";
                    row[2] = lexicos.lexemas;
                    break;
                case Comilla_simple:
                    row[1] = "Comilla simple";
                    row[2] = lexicos.lexemas;
                    break;
                case _String:
                    row[1] = "Tipo de dato String";
                    row[2] = lexicos.lexemas;
                    break;
                case If:
                    row[1] = "Reservada if";
                    row[2] = lexicos.lexemas;
                    break;
                case Int:
                    row[1] = "Tipo de dato int";
                    row[2] = lexicos.lexemas;
                    break;
                case Double:
                    row[1] = "Tipo de dato double";
                    row[2] = lexicos.lexemas;
//                    resultado += "  <Tipo de dato double>\t" + lexicos.lexemas + "\n";
                    break;
                case Float:
                    row[1] = "Tipo de dato float";
                    row[2] = lexicos.lexemas;
//                    resultado += "  <Tipo de dato float>\t" + lexicos.lexemas + "\n";
                    break;
                case Bool:
                    row[1] = "Tipo de dato bool";
                    row[2] = lexicos.lexemas;
//                    resultado += "  <Tipo de dato bool>\t" + lexicos.lexemas + "\n";
                    break;
                case Byte:
                    row[1] = "Tipo de dato byte";
                    row[2] = lexicos.lexemas;
//                    resultado += "  <Tipo de dato byte>\t" + lexicos.lexemas + "\n";
                    break;
                case Long:
                    row[1] = "Tipo de dato long";
                    row[2] = lexicos.lexemas;
//                    resultado += "  <Tipo de dato long>\t" + lexicos.lexemas + "\n";
                    break;
                case Scanf:
                    row[1] = "Reservado Scanf";
                    row[2] = lexicos.lexemas;
//                    resultado += "  <Reservado Scanf>\t" + lexicos.lexemas + "\n";
                    break;
                case Printf:
                    row[1] = "Reservado Printf";
                    row[2] = lexicos.lexemas;
//                    resultado += "  <Reservado Printf>\t" + lexicos.lexemas + "\n";
                    break;
                case Short:
                    row[1] = "Tipo de dato short";
                    row[2] = lexicos.lexemas;
//                    resultado += "  <Tipo de dato short>\t" + lexicos.lexemas + "\n";
                    break;
                case Char:
                    row[1] = "Tipo de dato char";
                    row[2] = lexicos.lexemas;
//                    resultado += "  <Tipo de dato char>\t" + lexicos.lexemas + "\n";
                    break;
                case Incremento:
                    row[1] = "Incremento";
                    row[2] = lexicos.lexemas;
//                    resultado += "  <Incremento>\t\t" + lexicos.lexemas + "\n";
                    break;
                case Decremento:
                    row[1] = "Decremento";
                    row[2] = lexicos.lexemas;
//                    resultado += "  <Decremento>\t\t" + lexicos.lexemas + "\n";
                    break;
                case Else:
                    row[1] = "Reservada else";
                    row[2] = lexicos.lexemas;
//                    resultado += "  <Reservada else>\t" + lexicos.lexemas + "\n";
                    break;
                case Endl:
                    row[1] = "Salto de linea";
                    row[2] = lexicos.lexemas;
//                    resultado += "  <Salto de linea>\t" + lexicos.lexemas + "\n";
                    break;
                case Return:
                    row[1] = "Reservada return";
                    row[2] = lexicos.lexemas;
//                    resultado += "  <Reservada return>\t" + lexicos.lexemas + "\n";
                    break;
                case Void:
                    row[1] = "Reservada Void";
                    row[2] = lexicos.lexemas;
//                    resultado += "  <Reservada switch>\t" + lexicos.lexemas + "\n";
                    break;
                case Typedef:
                    row[1] = "Reservada Typedef";
                    row[2] = lexicos.lexemas;
//                    resultado += "  <Reservada switch>\t" + lexicos.lexemas + "\n";
                    break;
                case Switch:
                    row[1] = "Reservada switch";
                    row[2] = lexicos.lexemas;
//                    resultado += "  <Reservada switch>\t" + lexicos.lexemas + "\n";
                    break;
                case Do:
                    row[1] = "Reservada Do";
                    row[2] = lexicos.lexemas;
//                    resultado += "  <Reservada do>\t" + lexicos.lexemas + "\n";
                    break;
                case For:
                    row[1] = "Reservada for";
                    row[2] = lexicos.lexemas;
//                    resultado += "  <Reservada for>\t" + lexicos.lexemas + "\n";
                    break;
                case Igual:
                    row[1] = "Operador igual";
                    row[2] = lexicos.lexemas;
//                    resultado += "  <Operador igual>\t" + lexicos.lexemas + "\n";
                    break;
                case O_logico:
                    row[1] = "Operador logico";
                    row[2] = lexicos.lexemas;
//                    resultado += "  <Operador o logico>\t" + lexicos.lexemas + "\n";
                    break;
                case BitOr:
                    row[1] = "Operador BitOr";
                    row[2] = lexicos.lexemas;
//                    resultado += "  <Operador o logico>\t" + lexicos.lexemas + "\n";
                    break;
                case Y_logico:
                    row[1] = "Operador logico";
                    row[2] = lexicos.lexemas;
//                    resultado += "  <Operador y logico>\t" + lexicos.lexemas + "\n";
                    break;
                case BitAnd:
                    row[1] = "Operador bitand";
                    row[2] = lexicos.lexemas;
//                    resultado += "  <Operador bitand>\t" + lexicos.lexemas + "\n";
                    break;

                case Suma:
                    row[1] = "Operador suma";
                    row[2] = lexicos.lexemas;
//                    resultado += "  <Operador suma>\t" + lexicos.lexemas + "\n";
                    break;
                case Resta:
                    row[1] = "Operador resta";
                    row[2] = lexicos.lexemas;
//                    resultado += "  <Operador resta>\t" + lexicos.lexemas + "\n";
                    break;
                case Multiplicacion:
                    row[1] = "Operador multiplicacion";
                    row[2] = lexicos.lexemas;
//                    resultado += "  <Operador multiplicacion>\t" + lexicos.lexemas + "\n";
                    break;
                case Division:
                    row[1] = "Operador division";
                    row[2] = lexicos.lexemas;
//                    resultado += "  <Operador division>\t" + lexicos.lexemas + "\n";
                    break;
                case ModuloIgual:
                    row[1] = "Operador modulo igual";
                    row[2] = lexicos.lexemas;
//                    resultado += "  <Operador modulo igual>\t" + lexicos.lexemas + "\n";
                    break;
                case Modulo:
                    row[1] = "Operador modulo";
                    row[2] = lexicos.lexemas;
//                    resultado += "  <Operador modulo>\t" + lexicos.lexemas + "\n";
                    break;
                case Diferente:
                    row[1] = "Comparador diferente";
                    row[2] = lexicos.lexemas;
//                    resultado += "  <Comparador diferente>\t" + lexicos.lexemas + "\n";
                    break;
                case Negador:
                    row[1] = "Operador de negacion";
                    row[2] = lexicos.lexemas;
//                    resultado += "  <Operador de negacion>\t" + lexicos.lexemas + "\n";
                    break;
                case DobleMayor:
                    row[1] = "Doble mayor";
                    row[2] = lexicos.lexemas;
//                    resultado += "  <Doble mayor>\t" + lexicos.lexemas + "\n";
                    break;
                case DobleMenor:
                    row[1] = "Doble menor";
                    row[2] = lexicos.lexemas;
//                    resultado += "  <Doble menor>\t" + lexicos.lexemas + "\n";
                    break;
                case MayorQue:
                    row[1] = "Simbolo Mayor que";
                    row[2] = lexicos.lexemas;
//                    resultado += "  <Simbolo Mayor que>\t" + lexicos.lexemas + "\n";
                    break;
                case MenorQue:
                    row[1] = "Simbolo Menor que";
                    row[2] = lexicos.lexemas;
//                    resultado += "  <Simbolo Menor que>\t" + lexicos.lexemas + "\n";
                    break;
                case MayorIgual:
                    row[1] = "Mayor igual";
                    row[2] = lexicos.lexemas;
//                    resultado += "  <Mayor igual>\t\t" + lexicos.lexemas + "\n";
                    break;
                case MenorIgual:
                    row[1] = "Menor igual";
                    row[2] = lexicos.lexemas;
//                    resultado += "  <Menor igual>\t\t" + lexicos.lexemas + "\n";
                    break;
                case MasIgual:
                    row[1] = "Mas igual";
                    row[2] = lexicos.lexemas;
//                    resultado += "  <Mas igual>\t\t" + lexicos.lexemas + "\n";
                    break;
                case MenosIgual:
                    row[1] = "Menos igual";
                    row[2] = lexicos.lexemas;
//                    resultado += "  <Menos igual>\t\t" + lexicos.lexemas + "\n";
                    break;
                case MultiplicacionIgual:
                    row[1] = "Multiplica igual";
                    row[2] = lexicos.lexemas;
//                    resultado += "  <Multiplica igual>\t" + lexicos.lexemas + "\n";
                    break;
                case DivisionIgual:
                    row[1] = "Division igual";
                    row[2] = lexicos.lexemas;
//                    resultado += "  <Division igual>\t" + lexicos.lexemas + "\n";
                    break;
                case Parent_a:
                    row[1] = "Parentesis de apertura";
                    row[2] = lexicos.lexemas;
//                    resultado += "  <Parentesis de apertura>\t" + lexicos.lexemas + "\n";
                    break;
                case Parent_c:
                    row[1] = "Parentesis de cierre";
                    row[2] = lexicos.lexemas;
//                    resultado += "  <Parentesis de cierre>\t" + lexicos.lexemas + "\n";
                    break;
                case Llave_a:
                    row[1] = "Llave de apertura";
                    row[2] = lexicos.lexemas;
//                    resultado += "  <Llave de apertura>\t" + lexicos.lexemas + "\n";
                    break;
                case Llave_c:
                    row[1] = "Llave de cierre";
                    row[2] = lexicos.lexemas;
//                    resultado += "  <Llave de cierre>\t" + lexicos.lexemas + "\n";
                    break;
                case Corchete_a:
                    row[1] = "Corchete de apertura";
                    row[2] = lexicos.lexemas;
//                    resultado += "  <Corchete de apertura>\t" + lexicos.lexemas + "\n";
                    break;
                case Corchete_c:
                    row[1] = "Corchete de cierre";
                    row[2] = lexicos.lexemas;
//                    resultado += "  <Corchete de cierre>\t" + lexicos.lexemas + "\n";
                    break;
                case Main:
                    row[1] = "Reservada main";
                    row[2] = lexicos.lexemas;
//                    resultado += "  <Reservada main>\t" + lexicos.lexemas + "\n";
                    break;
                case While:
                    row[1] = "Reservada while";
                    row[2] = lexicos.lexemas;
//                    resultado += "  <Reservada while>\t" + lexicos.lexemas + "\n";
                    break;
                case Cin:
                    row[1] = "Entrada por consola";
                    row[2] = lexicos.lexemas;
//                    resultado += "  <Entrada por consola>\t" + lexicos.lexemas + "\n";
                    break;
                case Cout:
                    row[1] = "Salida por consola";
                    row[2] = lexicos.lexemas;
//                    resultado += "  <Salida por consola>\t" + lexicos.lexemas + "\n";
                    break;
                case P_coma:
                    row[1] = "Punto y coma";
                    row[2] = lexicos.lexemas;
//                    resultado += "  <Punto y coma>\t" + lexicos.lexemas + "\n";
                    break;
                case Punto:
                    row[1] = "Punto";
                    row[2] = lexicos.lexemas;
//                    resultado += "  <Punto>\t\t" + lexicos.lexemas + "\n";
                    break;
                case Coma:
                    row[1] = "Coma";
                    row[2] = lexicos.lexemas;
//                    resultado += "  <Coma>\t\t" + lexicos.lexemas + "\n";
                    break;
                case DosPuntos:
                    row[1] = "Dos puntos";
                    row[2] = lexicos.lexemas;
//                    resultado += "  <Dos puntos>\t\t" + lexicos.lexemas + "\n";
                    break;
                case Include:
                    row[1] = "Reservado include";
                    row[2] = lexicos.lexemas;
//                    resultado += "  <Reservado include>\t" + lexicos.lexemas + "\n";
                    break;
                case Std:
                    row[1] = "Reservado std";
                    row[2] = lexicos.lexemas;
//                    resultado += "  <Reservado std>\t" + lexicos.lexemas + "\n";
                    break;
                case Namespace:
                    row[1] = "Reservado namespace";
                    row[2] = lexicos.lexemas;
//                    resultado += "  <Reservado namespace>\t" + lexicos.lexemas + "\n";
                    break;
                case Case:
                    row[1] = "Reservado case";
                    row[2] = lexicos.lexemas;
//                    resultado += "  <Reservado case>\t" + lexicos.lexemas + "\n";
                    break;
                case Continue:
                    row[1] = "Reservado continue";
                    row[2] = lexicos.lexemas;
//                    resultado += "  <Reservado continue>\t" + lexicos.lexemas + "\n";
                    break;
                case Break:
                    row[1] = "Reservado continue";
                    row[2] = lexicos.lexemas;
//                    resultado += "  <Reservado continue>\t" + lexicos.lexemas + "\n";
                    break;
                case Iostream:
                    row[1] = "Reservado iostream";
                    row[2] = lexicos.lexemas;
//                    resultado += "  <Reservado iostream>\t" + lexicos.lexemas + "\n";
                    break;
                case Using:
                    row[1] = "Reservado using";
                    row[2] = lexicos.lexemas;
//                    resultado += "  <Reservado using>\t" + lexicos.lexemas + "\n";
                    break;
                case Const:
                    row[1] = "Reservado Const";
                    row[2] = lexicos.lexemas;
//                    resultado += "  <Reservado using>\t" + lexicos.lexemas + "\n";
                    break;
                case Default:
                    row[1] = "Reservado default";
                    row[2] = lexicos.lexemas;
//                    resultado += "  <Reservado default>\t" + lexicos.lexemas + "\n";
                    break;
                case Define:
                    row[1] = "Reservado define";
                    row[2] = lexicos.lexemas;
//                    resultado += "  <Reservado define>\t" + lexicos.lexemas + "\n";
                    break;
                case Unsigned:
                    row[1] = "Reservado unsigned";
                    row[2] = lexicos.lexemas;
//                    resultado += "  <Reservado unsigned>\t" + lexicos.lexemas + "\n";
                    break;
                case Register:
                    row[1] = "Reservado register";
                    row[2] = lexicos.lexemas;
//                    resultado += "  <Reservado register>\t" + lexicos.lexemas + "\n";
                    break;
                case Struct:
                    row[1] = "Reservado struct";
                    row[2] = lexicos.lexemas;
//                    resultado += "  <Reservado struct>\t" + lexicos.lexemas + "\n";
                    break;
                case Numeral:
                    row[1] = "Reservado numeral";
                    row[2] = lexicos.lexemas;
//                    resultado += "  <Reservado numeral>\t" + lexicos.lexemas + "\n";
                    break;
                case Identificador:
                    row[1] = "Identificador";
                    row[2] = lexicos.lexemas;
//                    resultado += "  <Identificador>\t\t" + lexicos.lexemas + "\n";
                    break;
                case Numero:
                    row[1] = "Numero";
                    row[2] = lexicos.lexemas;
//                    resultado += "  <Numero>\t\t" + lexicos.lexemas + "\n";
                    break;
                case ERROR:
                    row[1] = "Simbolo no definido";
                    row[2] = lexicos.lexemas;
//                    resultado += "  <Simbolo no definido>\n";
                    break;
//                default:
//                    // Manejar los tokens que no tienen un caso específico asignado
//                    row[1] = "Token no definido";
//                    row[2] = lexicos.lexemas;
//                    break;
            }

            model.addRow(row);

            if (token == Tokens.Linea) {
                cont++;
            }
            tabla.setModel(model);

        }

    }

    private void colorAnalysis() {
        /* Limpiar el arreglo de colores */
        textsColor.clear();
        /* Extraer rangos de colores */
        LexerColor lexer;
        try {
            File codigo = new File("color.encrypter");
            FileOutputStream output = new FileOutputStream(codigo);
            byte[] bytesText = Resultado.getText().getBytes();
            output.write(bytesText);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(new FileInputStream(codigo), "UTF8"));
            lexer = new LexerColor(entrada);
            while (true) {
                TextColor textColor = lexer.yylex();
                if (textColor == null) {
                    break;
                }
                textsColor.add(textColor);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("El archivo no pudo ser encontrado... " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error al escribir en el archivo... " + ex.getMessage());
        }
        Functions.colorTextPane(textsColor, Resultado, new Color(40, 40, 40));
    }

    private void BotonAnalisisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAnalisisActionPerformed
        try {
            analizarLexico();

        } catch (IOException ex) {
            Logger.getLogger(FrmAnalizador.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BotonAnalisisActionPerformed

    private void BotonSintacticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonSintacticoActionPerformed
        String ST = Resultado.getText();
        Sintaxis s = new Sintaxis(new Analizador.LexicoCup(new StringReader(ST)));

        try {
            s.parse();
            txtAnalizarSin.setText("Analisis realizado correctamente");
            txtAnalizarSin.setForeground(new Color(25, 111, 61));
        } catch (Exception ex) {
            Symbol sym = s.getS();
            txtAnalizarSin.setText("Error de sintaxis. Linea: " + (sym.right + 1) + " Columna: " + (sym.left + 1) + ", Texto: \"" + sym.value + "\"");
            txtAnalizarSin.setForeground(Color.red);
        }
    }//GEN-LAST:event_BotonSintacticoActionPerformed

    private boolean saveFile(File file, String doc) {
        String message = null;
        try {
            FileOutputStream out = new FileOutputStream(file);
            byte[] bytxt = doc.getBytes();
            out.write(bytxt);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String args[]) throws Exception {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmAnalizador.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAnalizador.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAnalizador.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAnalizador.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        ///editor-fold

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmAnalizador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonAnalisis;
    private javax.swing.JButton BotonSintactico;
    private javax.swing.JTextPane Resultado;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tabla;
    private javax.swing.JTextArea txtAnalizarSin;
    // End of variables declaration//GEN-END:variables
}

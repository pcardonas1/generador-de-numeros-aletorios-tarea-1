/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package generador_de_números_aleatorios_umg;
/**
 *
 * @author Pablo
 */
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class GENERADOR_DE_NÚMEROS_ALEATORIOS_UMG {
    private static final int NUMEROS = 1000000;
    private static final int NUMEROS_MINIMO = -10000000;
    private static final int NUMEROS_MAXIMO = 10000000;

    public static void main(String[] args) {
        generar_numeros_aleatorios();
        leerYOrdenarNumeros();
    }

    public static void generar_numeros_aleatorios() {
        try {
            BufferedWriter escritor = new BufferedWriter(new FileWriter("numeros_aleatorios_umg.txt"));
            BufferedWriter escritorOrdenado = new BufferedWriter(new FileWriter("numeros_aleatorios_ordenados_umg.txt"));

            Random generador = new Random();

            for (int i = 0; i < NUMEROS; i++) {
                int numeroAleatorio = generador.nextInt(NUMEROS_MAXIMO - NUMEROS_MINIMO + 1) + NUMEROS_MINIMO;
                escritor.write(Integer.toString(numeroAleatorio));
                escritor.newLine();
            }

            escritor.close();

            System.out.println("su archivo a sido guardado exitosamento " + NUMEROS + " números aleatorios en el archivo.");

        } catch (IOException e) {
            System.out.println("Error al guardar el archivo: " + e.getMessage());
        }
    }

    public static void leerYOrdenarNumeros() {
        try {
            BufferedReader lector = new BufferedReader(new FileReader("numeros_aleatorios_umg.txt"));
            BufferedWriter escritorOrdenado = new BufferedWriter(new FileWriter("numeros_aleatorios_ordenados_umg.txt"));

            ArrayList<Integer> numeros = new ArrayList<>();
            String linea;

            // función de leer numeros 
            while ((linea = lector.readLine()) != null) {
                numeros.add(Integer.parseInt(linea));
            }

            // funcion de ordenar los números
            Collections.sort(numeros);

            // rescribe los numeros en un nuevo documento
            for (int numero : numeros) {
                escritorOrdenado.write(Integer.toString(numero));
                escritorOrdenado.newLine();
            }

            lector.close();
            escritorOrdenado.close();

            System.out.println("Su archivo a sido guardado exitosamente 'numeros_aleatorios_ordenados_umg.txt'.");

        } catch (IOException e) {
            System.out.println("Error al guardar el archivo: " + e.getMessage());
        }
    }
}
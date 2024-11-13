/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rodrigomarta_hundir_la_flota;

import java.util.Scanner;

/**
 *
 * @author martarodrigo
 */
public class RodrigoMarta_Hundir_La_Flota1_nousar {

    /**Aconsegueix que el programa et digui si el vaixell està enfonsat quan encertes totes les
posicions d'on tenies el vaixell marcat, i finalitzi el joc.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclat = new Scanner(System.in);
        char[][] taulell = new char[10][10];
      
        for (int f = 0; f < 10; f++) {
            for (int c = 0; c < 10; c++) {
                taulell[f][c] = '-';
            }
        }

        System.out.println("  1 2 3 4 5 6 7 8 9 10");
        for (int f = 0; f < 10; f++) {
            System.out.print((f + 1) + " ");
            for (int c = 0; c < 10; c++) {
                System.out.print(taulell[f][c] + " ");
            }
            System.out.println();
        }

        System.out.println("\nBATTLESHIP");
        System.out.println("==========");

        System.out.println("We're going to introduce the ship...");
        System.out.print("What's the size of your ship (2,3,4)? ");
        int mida = teclat.nextInt();

        System.out.print("Do you want to fix your ship horizontaly o vertically (v o h)? ");
        char direccio = teclat.next().charAt(0);

        System.out.println("In what position do you want to fix the ship (rows and columns)?");
        int fila = teclat.nextInt();
        int col = teclat.nextInt();

        if ((direccio == 'h' && col + mida <= 11) || (direccio == 'v' && fila + mida <= 11)) {

            for (int i = 0; i < mida; i++) {
                if (direccio == 'h') {
                    taulell[fila - 1][col - 1 + i] = 'X';
                } else {
                    taulell[fila - 1 + i][col - 1] = 'X';
                }
            }

            System.out.println("\n  1 2 3 4 5 6 7 8 9 10");
            for (int f = 0; f < 10; f++) {
                System.out.print((f + 1) + " ");
                for (int c = 0; c < 10; c++) {
                    System.out.print(taulell[f][c] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("No es posible colocar el vaixell en aquesta posició. Torna-ho a provar.");
        }
    }
}

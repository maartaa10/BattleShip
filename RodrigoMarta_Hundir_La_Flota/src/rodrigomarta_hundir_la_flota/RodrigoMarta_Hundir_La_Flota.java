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
public class RodrigoMarta_Hundir_La_Flota {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclat = new Scanner(System.in);
        char[][] taulell = new char[10][10];
        char[][] taulellM = new char[10][10];
        int opcio;
        int contador = 0;
        int mida = 0;
        char direccio = ' ';
        do {
            System.out.println("Menu:");
            System.out.println("1. Introduir un vaixell");
            System.out.println("2. Jugar");
            System.out.println("3. Sortir");
            System.out.print("Escull una opció: ");
            opcio = teclat.nextInt();

            switch (opcio) {
                case 1:
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
                    System.out.println("Introdueix les coordenades del vaixell:");

                    do {
                        System.out.print("Grandària del vaixell (de 2 a 4 posicions): ");
                        mida = teclat.nextInt();
                        teclat.nextLine();
                    } while (mida < 2 || mida > 4);

                    do {
                        System.out.print("El vols ficar en posició vertical o horitzontal (v o h)?: ");
                        direccio = teclat.nextLine().toLowerCase().charAt(0);
                    } while (direccio != 'v' && direccio != 'h');
                    boolean posOK = false;
                    int fila = 0;
                    int col = 0;
                    do {
                        System.out.println("En quina fila i columna vols ficar el vaixell?: ");
                         fila = teclat.nextInt();
                         col = teclat.nextInt();

                        if (fila > 0 && fila <=10 && col > 0 && col <= 10 && ((direccio == 'h' && col + mida <= 10) || (direccio == 'v' && fila + mida <= 10))) {
                            posOK = true;
                        } else {
                            System.out.println("No es possible col·locar el vaixell en aquesta posició. Torna-ho a intentar.");
                        }
                    } while (posOK == false);
                    for (int i = 0; i < mida; i++) {
                        if (direccio == 'h') {
                            taulell[fila - 1][col - 1 + i] = 'X';
                        } else {
                            taulell[fila - 1 + i][col - 1] = 'X';
                        }
                    }
                    System.out.println("\n  1 2 3 4 5 6 7 8 9 10");
                    for (int i = 0; i < 10; i++) {
                        System.out.print((i + 1) + " ");
                        for (int j = 0; j < 10; j++) {
                            System.out.print(taulell[i][j] + " ");
                        }
                        System.out.println();
                    }

                    break;
                case 2:
                    for (int f = 0; f < 10; f++) {
                        for (int c = 0; c < 10; c++) {
                            taulellM[f][c] = '-';
                        }
                    }
                    boolean jugar = true;

                    do {
                        System.out.println("JUGAR");
                        System.out.println("==========");
                        System.out.println("\n  1 2 3 4 5 6 7 8 9 10");
                        for (int i = 0; i < 10; i++) {
                            System.out.print((i + 1) + " ");
                            for (int j = 0; j < 10; j++) {
                                System.out.print(taulellM[i][j] + " ");
                            }
                            System.out.println();
                        }
                        System.out.println("Introdueix les coordenades a disparar:");
                        System.out.print("Fila: ");
                        int filaJoc = teclat.nextInt();
                        System.out.print("Columna: ");
                        int colJoc = teclat.nextInt();
                        if (taulellM[filaJoc - 1][colJoc - 1] == '-') {
                            if (taulell[filaJoc - 1][colJoc - 1] == 'X') {
                                System.out.println("Tocat!");
                                taulellM[filaJoc - 1][colJoc - 1] = 'T';
                                contador++;

                                if (contador == mida) {
                                    jugar = false;
                                    contador = 0;
                                    System.out.println("\n  1 2 3 4 5 6 7 8 9 10");
                                    for (int i = 0; i < 10; i++) {
                                        System.out.print((i + 1) + " ");
                                        for (int j = 0; j < 10; j++) {
                                            System.out.print(taulellM[i][j] + " ");
                                        }
                                        System.out.println();
                                    }
                                    System.out.println("Enhorabona! Has enfonsat el vaixell!");
                                    System.out.println(" YOU'RE THE WINNER! :D ");
                                    System.out.println();
                                }
                            } else {
                                System.out.println("Aigua!");
                                taulellM[filaJoc - 1][colJoc - 1] = 'A';
                            }
                        } else {
                            System.out.println("Aqui ja has disparat. Torna a disparar");
                        }
                    } while (jugar == true);
                    break;
                case 3:
                    System.out.println("Fins aviat! Juga quan vulguis!");
                    break;
                default:
                    System.out.println("Opció no vàlida. Torna a escollir.");
            }

        } while (opcio != 3);
    }
}

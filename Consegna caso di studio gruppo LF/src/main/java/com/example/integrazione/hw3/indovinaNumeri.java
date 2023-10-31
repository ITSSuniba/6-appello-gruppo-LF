package com.example.integrazione.hw3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class indovinaNumeri {

    public static int partiteVinte;  // variabile di classe. Conta il
    // il numero di partite vinte.

    public static void main(String[] a) {

        // scrivi messaggio di inizio gioco
        System.out.println("Giochiamo all'indovino!");
        partiteVinte = 0;

        do {
            System.out.println("Io ho pensato un numero tra 1 e 9."
                    + "\nHai tre tentativi per scoprirlo");
            int numeroPensato = (int)(Math.random()*9 + 1);
            eseguiGioco(numeroPensato);  // chiamata del metodo eseguiGioco(),
            // definito in seguito.

            System.out.println("Vuoi giocare ancora (S/N)? ");
            String risposta = "";

            BufferedReader console = new BufferedReader(
                    new InputStreamReader(System.in));

            try {
                risposta = console.readLine();
            }
            catch (IOException e) {
                System.out.println("Errore di input");
                System.exit(1);
            }
            if (risposta.equalsIgnoreCase("n"))
                break;
            // se l'utente risponde in qq modo che non sia "n" o "N",
            // la risposta viene considerata come un "si".
        } while (true);

        // La variabile "partiteVinte" viene utilizzata qui:
        System.out.println("Hai vinto " + partiteVinte + " partite!");
        System.out.println("Fine Gioco. Ciao!");

    }  // fine main

    public static void eseguiGioco(int numPensato) {

        BufferedReader datiUtente = new BufferedReader(
                new InputStreamReader(System.in));

        int rispUtente = 0;
        boolean vinto = false;

        for (int i = 0; i < 3; i++) {
            System.out.println("Tentativo numero " +
                    (i+1));
            try {
                String risp = datiUtente.readLine();
                rispUtente = Integer.parseInt(risp);
            }
            catch (IOException e) {
                System.out.println("Errore di input");
                System.exit(1);
            }

            if (rispUtente == numPensato) {
                vinto = true;
                break;
            }
            else {
                System.out.println("tentativo sbagliato!");
            }

        }
        if (vinto) {
            System.out.println("Hai vinto!");
            partiteVinte++;  // aggiorno il numero di partite vinte
        }
        else
            System.out.println("Hai perso! Io avevo pensato il numero "
                    + numPensato);
    }  // fine metodo eseguiGioco()
}

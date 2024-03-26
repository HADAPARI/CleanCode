/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cleancode;

import java.util.Scanner;

/**
 *
 * @author inclusiv Academy 06
 */
public class CleanCode {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //int[] entiers = {5,42,12,33,8};
        int[] entiers = saisiEntiers();

        //croissant
        entiers = tri(entiers, "ASC");
        affichage(entiers);

        //décroissant
        entiers = tri(entiers, "DESC");
        affichage(entiers);
    }

    public static int[] saisiEntiers() {

        Scanner scan = new Scanner(System.in);
        String listeString;
        String[] listes;

        do {

            System.out.print("Entrer votre liste (ex:[1,2] ou 1,2) : ");
            listeString = scan.nextLine();

            //suppression des crochés
            listeString = listeString.replace("[", "");
            listeString = listeString.replace("]", "");
            listeString = listeString.trim();

            listes = listeString.split(",");

            //boucle si la liste est vide comme: "[]" ou "[,]" ou " " ou ","
        } while (listeString.length() == 0 || listes.length == 0);

        int[] entiers = new int[listes.length];
        for (int i = 0; i < entiers.length; i++) {
            try {
                entiers[i] = Integer.parseInt(listes[i]);
            } catch (Exception e) {
                System.out.println("la valeur " + listes[i] + " est incompatible");
                return null;
            }
        }

        return entiers;
    }

    // trie le tableau des entiers
    public static int[] tri(int[] entiers, String ordre) {
        if (entiers == null) {
            return entiers;
        }

        for (int i = 0; i < entiers.length; i++) {
            for (int j = i + 1; j < entiers.length; j++) {
                // ordre croissant
                if (ordre.equalsIgnoreCase("ASC")) {
                    //recherche de min pour le mettre en avant
                    if (entiers[j] < entiers[i]) {
                        int tmp = entiers[i];
                        entiers[i] = entiers[j];
                        entiers[j] = tmp;
                    }

                    // ordre décroissant
                } else if (ordre.equalsIgnoreCase("DESC")) {
                    //recherche de max pour le mettre en avant
                    if (entiers[j] > entiers[i]) {
                        int tmp = entiers[i];
                        entiers[i] = entiers[j];
                        entiers[j] = tmp;
                    }
                }
            }
        }

        return entiers;
    }

    //affiche le tableau des entiers
    public static void affichage(int[] entiers) {
        if (entiers == null) {
            return;
        }
        
        System.out.print("Liste triée: ");
        for (int entier : entiers) {
            System.out.print(entier + ", ");
        }
        System.out.println("");
    }
}

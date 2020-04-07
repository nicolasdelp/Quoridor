package be.nicolasdelp.quoridor;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class SaveLoadDeleteGame {

    private final static char[] Alphabet = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
    private final static int décallage = 2;
    private static ArrayList<String> textCrypt = new ArrayList<String>();

    /**
     * Crée une fichier de sauvegarde
     *
     */
    public static void creatFile(String File) {
        try {
            File backup = new File(File);
            if (backup.createNewFile()) {
                System.out.println("Le fichier " + backup.getName() + " a bien été créé !");
            } else {
                System.out.println("Le fichier existe déjà !");
            }
        } catch (IOException exception) {
            System.out.println("Il y a eu une erreur...");
            exception.printStackTrace();
        }
    }

    /**
     * Ecrit dans le fichier de sauvegarde
     *
     */
    public static void writeFile(String File, String text) {
        try {
            FileWriter backup = new FileWriter(File);
            backup.write(text + "\n");
            backup.close();
            System.out.println("Le texte à bien été écrit !");
        } catch (IOException exception) {
            System.out.println("Il y a eu une erreur...");
            exception.printStackTrace();
        }
    }

    /**
     * Lecture du contenu dans le fichier de sauvegarde
     *
     */
    public static void readFile(String File) {
        try {
            File backup = new File(File);
            Scanner read = new Scanner(backup);
            while (read.hasNextLine()) {
                String data = read.nextLine();
                System.out.println(data);
            }
            read.close();
        } catch (FileNotFoundException exception) {
            System.out.println("Il y a eu une erreur...");
            exception.printStackTrace();
        }
    }

    /**
     * Supprime le fichier
     *
     */
    public static void deleteFile(String File) {
        File backup = new File(File);
        if (backup.delete()) {
            System.out.println("Le fichier : " + backup.getName() + " a bien été supprimé !");
        } else {
            System.out.println("Il y a eu une erreur...");
        }
    }

    /**
     * Cryptage de César
     *
     * @param text une chaine de caractère
     * @return une chaine de caractère cryptée
     */
    public static String cryptage(String text) {
        char[] textIn = text.toCharArray();
        char[] textOut = new char[textIn.length];
        for(int i = 0; i < textIn.length; i++){
            int x1 = charPosition(textIn[i], Alphabet);
            int x2 = newCharPosition(x1);
            if(x2 == -1){
                textOut[i] = textIn[i]; //on ne change pas le caractère si c'est pas un chiffre ou une lettre
            }
            else{
                textOut[i] = Alphabet[x2];
            }
        }
        String res = "";
        for(char i: textOut){
            res = res+i;
        }
        return res;
    }

    /**
     * Donne le position d'un caractère dans char[] Alphabet
     *
     * @param x une lettre
     * @return l'index dans char[] Alphabet ou -1 si il n'est pas dans Alphabet
     */
    public static int charPosition(char x, char[] charactere) {
        for (int i = 0; i < charactere.length; i++) {
            if (charactere[i] == x) {
                return i;
            }
        }
        return -1; //élement qui n'est pas dans la liste car on décalle à droite
    }

    /**
     * Donne le nouveau caractère après le décallage
     *
     * @param x l'index de la lettre dans char[] Alphabet
     * @return le nouvel index après décallage
     */
    public static int newCharPosition(int x) {
        int res;
        int positionInitial = x;
        if(positionInitial <= -1) {
            res = -1;   
        } else {
            res = (positionInitial + décallage) % (Alphabet.length);
        }
        return res;
    }

    /**
     * Cryptage de César
     *
     */
    public static void cryptageFile(String startFile, String finishFile) {
        try {
            File backup = new File(startFile);
            Scanner read = new Scanner(backup);
            while (read.hasNextLine()) {
                textCrypt.add(cryptage(read.nextLine())); //cryptage de chaque ligne et stockage dans une ArrayList
            }
            read.close();
            creatFile(finishFile);
            for(int i=0; i<textCrypt.size(); i++){
                writeFile(finishFile, textCrypt.get(i)); //écriture dans le nouveau fichier crypté
            }
        } catch (FileNotFoundException exception) {
            System.out.println("Il y a eu une erreur...");
            exception.printStackTrace();
        }
    }

    public static void main(String[] args) {
        cryptageFile("Backup.txt", "CryptBackup.txt");
    }
}
package main.java.be.nicolasdelp.quoridor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.List;
import java.util.ArrayList;

public class SaveLoadDeleteGame {

    private final static char[] Alphabet = {  'a' ,  '1' ,  'b' , '2', 'c', '3', 'd', '4', 'e', '5', 'f', '6', 'g', '7', 'h', '8', 'i', '9', 'j', 'A', 'k', 'A', 'l', 'B', 'm', 'C', 'n', 'D', 'o', 'E', 'p', 'F', 'q', 'G', 'r', 'H', 's', 'I', 't', 'J', 'u', 'K', 'v', 'L', 'w', 'M', 'x', 'N', 'y', 'O', 'z', 'P', '@', 'Q', '#', 'R', '\\','S', '/', 'T', '!', 'U', '*', 'V', '&', 'W', '<', 'X', '+', 'Y', '-', 'Z' };
    private final static int decallage = Alphabet.length/2;
    private static List<String> textCrypt = new ArrayList<String>();
    private static List<String> textDecrypt = new ArrayList<String>();

    /**
     * Cree une fichier de sauvegarde
     *
     */
    public static void creatFile(String File) {
        File f = new File(File);
        if(!f.exists()){
            try {
                f.createNewFile();
            }catch (IOException exception) {
                System.out.println("Il y a eu une erreur...");
                exception.printStackTrace();
            }
        }
    }

    /**
     * Ecrit dans le fichier de sauvegarde
     *
     */
    public static void writeFile(String File, String text) {
        try {
            FileWriter f = new FileWriter(File);
            BufferedWriter bw = new BufferedWriter(f);
            bw.write(text);
            bw.newLine();
            bw.close();
            f.close();
        } catch (IOException exception) {
            System.out.println("Il y a eu une erreur...");
            exception.printStackTrace();
        }
    }

    /**
     * Lecture du contenu dans le fichier de sauvegarde
     *
     */
    public static void readFile(String File) throws IOException{
        try {
            FileReader f = new FileReader(File);
            BufferedReader br = new BufferedReader(f);
            String line = br.readLine();
            while (line != null) {
                System.out.println(line);
                line = br.readLine();
            }
            br.close();
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
        File f = new File(File);
        if (f.delete()) {
            System.out.println("Le fichier : " + f.getName() + " a bien ete supprime !");
        } else {
            System.out.println("Il y a eu une erreur...");
        }
    }

    /**
     * Cryptage de Cesar
     *
     * @param text une chaine de caractere
     * @return une chaine de caractere cryptee
     */
    public static String cryptage(String text) {
        char[] textIn = text.toCharArray();
        char[] textOut = new char[textIn.length];
        for(int i = 0; i < textIn.length; i++){
            int x1 = charPosition(textIn[i], Alphabet);
            int x2 = newCharPosition(x1);
            if(x2 == -1){
                textOut[i] = textIn[i]; //on ne change pas le caractere si c'est pas un chiffre ou une lettre
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
     * Decryptage de Cesar
     *
     * @param text une chaine de caractere
     * @return une chaine de caractere decryptee
     */
    public static String decryptage(String text) {
        char[] textIn = text.toCharArray();
        char[] textOut = new char[textIn.length];
        for(int i = 0; i < textIn.length; i++){
            int x1 = charPosition(textIn[i], Alphabet);
            int x2 = newCharPosition(x1);
            if(x2 == -1){
                textOut[i] = textIn[i]; //on ne change pas le caractere si c'est pas un chiffre ou une lettre
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
     * Donne le position d'un caractere dans char[] Alphabet
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
        return -1; //element qui n'est pas dans la liste car on decalle à droite
    }

    /**
     * Donne le nouveau caractere apres le decallage
     *
     * @param x l index de la lettre dans char[] Alphabet
     * @return le nouvel index apres decallage
     */
    public static int newCharPosition(int x) {
        int res;
        int positionInitial = x;
        if(positionInitial == -1) {
            res = -1;   
        } else {
            res = ((positionInitial + decallage) % Alphabet.length);
        }
        return res;
    }

    /**
     * Cryptage de Cesar du fichier de sauvegarde
     *
     */
    public static void cryptageFile(String startFile, String finishFile) {
        creatFile(finishFile);
        try {
            FileReader sf = new FileReader(startFile);
            BufferedReader br = new BufferedReader(sf);
            String sline = br.readLine();
            while (sline != null) {
                textCrypt.add(cryptage(sline));
                sline = br.readLine();
            }
            br.close();
            sf.close();

            FileWriter ff = new FileWriter(finishFile);
            BufferedWriter bw = new BufferedWriter(ff);
            for(String fline : textCrypt){
                bw.write(fline);
                bw.newLine();
            }
            bw.close();
            ff.close();
        } catch (IOException exception) {
            System.out.println("Il y a eu une erreur...");
            exception.printStackTrace();
        }
    }

    /**
     * Deryptage de Cesar du fichier de sauvegarde
     *
     */
    public static void decryptageFile(String startFile, String finishFile) {
        creatFile(finishFile);
        try {
            FileReader sf = new FileReader(startFile);
            BufferedReader br = new BufferedReader(sf);
            String sline = br.readLine();
            while (sline != null) {
                textDecrypt.add(decryptage(sline));
                sline = br.readLine();
            }
            br.close();
            sf.close();

            FileWriter ff = new FileWriter(finishFile);
            BufferedWriter bw = new BufferedWriter(ff);
            for(String fline : textDecrypt){
                bw.write(fline);
                bw.newLine();
            }
            bw.close();
            ff.close();
        } catch (IOException exception) {
            System.out.println("Il y a eu une erreur...");
            exception.printStackTrace();
        }
    }

    public static void main(String[] args) {
        cryptageFile("Backup.txt", "File/CryptBackup.txt");
        deleteFile("Backup.txt");
        decryptageFile("CryptBackup.txt", "Backup.txt");
        deleteFile("CryptBackup.txt");
    }
}
package be.nicolasdelp.quoridor;

import java.util.List;
import java.util.LinkedList;

public class Test {

    private static List<String> histoP1 = new LinkedList<String>(); //l'historique des faits de jeux du joueur 1
    private static List<String> histoP2 = new LinkedList<String>(); //l'historique des faits de jeux du joueur 2
    private static List<String> histoP3 = new LinkedList<String>(); //l'historique des faits de jeux du joueur 3
    private static List<String> histoP4 = new LinkedList<String>(); //l'historique des faits de jeux du joueur 4

    public static void getHistoStep(int ID){
        if(ID == 1){
            for(int i=0; i<histoP1.size(); i++){
                System.out.println(histoP1.get(i));
             }
        }
        if(ID == 2){
            for(int i=0; i<histoP2.size(); i++){
                System.out.println(histoP2.get(i));
             }
        }
        if(ID == 3){
            for(int i=0; i<histoP3.size(); i++){
                System.out.println(histoP3.get(i));
             }
        }
        if(ID == 4){
            for(int i=0; i<histoP4.size(); i++){
                System.out.println(histoP4.get(i));
            }
        }
    }

    public static void main(String[] args) {
        histoP1.add("useff");
        histoP1.add("useff");
        histoP1.add("useff");
        histoP1.add("useff");
        histoP2.add("us");
        histoP2.add("us");
        histoP2.add("us");
        histoP2.add("us");
        histoP3.add("usadf");
        histoP3.add("usadf");
        histoP3.add("usadf");
        histoP3.add("usadf");
        histoP4.add("usff");
        histoP4.add("usff");
        histoP4.add("usff");
        histoP4.add("usff");
        getHistoStep(1);
        getHistoStep(2);
        getHistoStep(3);
        getHistoStep(4);
    }

}
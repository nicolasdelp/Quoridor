package be.nicolasdelp.quoridor.objects;

import java.util.ArrayList;

public class Graph {

    private Board board;
    private Node[][] listOfNodes = new Node[17][17]; //plateau quoridor
    private ArrayList<Link> listOfLinks = new ArrayList<Link>();

    public Graph(Board board){
        this.board = board;
        setNodes(); //OK
        makeLinks();
    }

    private void setNodes(){
        for(int i = 0; i<this.board.getLength(); i++){
            for(int j = 0; j <this.board.getWidth(); j++){
                if(this.board.getBoardBoxes()[i][j].getisPawnBox()){
                    this.listOfNodes[i][j] = new Node(new Position(i, j)); //On crée un noeud par case du plateau
                } else{
                    this.listOfNodes[i][j] = null;
                }
            }
        }
    }

    private void makeLinks(){
        for(int j=0; j<17; j+=2){ //X    
            for(int i=1; i<17; i+=2){ //Y
                if(this.board.getBoardBoxes()[j][i].getisOccuped() == false){ //Si il n'y a pas de mur
                    this.listOfLinks.add(new Link(this.listOfNodes[j][i-1], this.listOfNodes[j][i+1])); //Lie 2 noeuds
                    this.listOfLinks.add(new Link(this.listOfNodes[j][i+1], this.listOfNodes[j][i-1])); //Lie 2 noeuds
                }
            }
        }
        for(int i=1; i<17; i+=2){ //X
            for(int j=0; j<17; j+=2){ //Y    
                if(this.board.getBoardBoxes()[i][j].getisOccuped() == false){ //Si il n'y a pas de mur
                    this.listOfLinks.add(new Link(this.listOfNodes[i-1][j], this.listOfNodes[i+1][j])); //Lie 2 noeuds
                    this.listOfLinks.add(new Link(this.listOfNodes[i+1][j], this.listOfNodes[i-1][j])); //Lie 2 noeuds
                }
            }
        }
    }

    public static void main(String[] args){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, Color.Rouge, new Pawn()), new Player("Ordinateur", "Ordi1", 1, Color.Rouge, new Pawn()), new Player("Humain", "Alex", 2, Color.Rouge, new Pawn()), new Player("Ordinateur", "Ordi2", 3, Color.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        Graph g = new Graph(b);
        System.out.println(g.listOfLinks.get(g.listOfLinks.size()-2).getFromNode().getNodePosition().getX());
        System.out.println(g.listOfLinks.get(g.listOfLinks.size()-2).getFromNode().getNodePosition().getY());
        System.out.println(g.listOfLinks.get(g.listOfLinks.size()-2).getToNode().getNodePosition().getX());
        System.out.println(g.listOfLinks.get(g.listOfLinks.size()-2).getToNode().getNodePosition().getY());
    }
}
package be.nicolasdelp.quoridor.objects;

import java.util.ArrayList;

import be.nicolasdelp.quoridor.rules.RuleViolated;

public class Graph {

    private Board board;
    private Node[][] Nodes = new Node[17][17]; //plateau quoridor
    private ArrayList<Link> Links = new ArrayList<Link>();
    private Node currentNode = new Node(new Position(0, 0));

    public Graph(Board board, Player otherPlayer){
        this.board = board;
        setNodes(otherPlayer);
        makeLinks();
    }

    private void setNodes(Player otherPlayer){
        for(int i = 0; i<this.board.getLength(); i++){
            for(int j = 0; j <this.board.getWidth(); j++){
                if(this.board.getBoardBoxes()[i][j].getisPawnBox()){
                    this.Nodes[i][j] = new Node(new Position(i, j));
                } else{
                    this.Nodes[i][j] = null;
                }
            }
        }
        this.Nodes[otherPlayer.getPawn().getPosition().getX()][otherPlayer.getPawn().getPosition().getY()] = null; //On ne crée pas de noeud ou il y  un pion adverse
    }

    private void makeLinks(){ //Création de lien si il n'y a pas de mur entre deux
        for(int j=0; j<17; j+=2){ //X    
            for(int i=1; i<17; i+=2){ //Y
                if(this.board.getBoardBoxes()[j][i].getisOccuped() == false){ //Si il n'y a pas de mur horizontal
                    if(this.Nodes[j][i-1] != null && this.Nodes[j][i+1] != null){
                        this.Links.add(new Link(this.Nodes[j][i-1], this.Nodes[j][i+1], 2)); //Lie 2 noeuds
                        this.Links.add(new Link(this.Nodes[j][i+1], this.Nodes[j][i-1], 2)); //Lie 2 noeuds
                    }
                }
            }
        }
        for(int i=1; i<17; i+=2){ //X
            for(int j=0; j<17; j+=2){ //Y    
                if(this.board.getBoardBoxes()[i][j].getisOccuped() == false){ //Si il n'y a pas de mur vertical
                    if(this.Nodes[i-1][j] != null && this.Nodes[i+1][j] != null){
                        this.Links.add(new Link(this.Nodes[i-1][j], this.Nodes[i+1][j], 1)); //Lie 2 noeuds
                        this.Links.add(new Link(this.Nodes[i+1][j], this.Nodes[i-1][j], 1)); //Lie 2 noeuds
                    }
                }
            }
        }
    }
    
    public boolean dijkstra(Position source, Position target){
        Node finish = this.Nodes[target.getX()][target.getY()]; //Noeud d'arrivée
        this.currentNode = this.Nodes[source.getX()][source.getY()]; //Noeud actuel
        Node minimum;
        boolean go = true;
        int z = 0;
        ArrayList<Node> openList = new ArrayList<Node>(); //Liste des noeuds ouvert
        ArrayList<Node> closeList = new ArrayList<Node>(); //Liste des noeuds a utiliser pour arriver à l'arrivé

        openList.add(this.currentNode); //On ajoute à l'openList le noeud actuel
        closeList.add(this.currentNode);

        while(go){
            for(int i=0; i<this.Nodes.length; i++){
                for(int j=0; j<this.Nodes.length; j++){
                    if(this.Nodes[i][j] != null){
                        if((this.Nodes[i][j].getNodePosition().getX() == this.currentNode.getNodePosition().getX()+2) && (this.Nodes[i][j].getNodePosition().getY() == this.currentNode.getNodePosition().getY())){ //Droite
                            for(int x=0; x<this.Links.size(); x++){
                                if(this.Links.get(x).getFromNode() == this.currentNode && this.Links.get(x).getToNode() == Nodes[i][j]){ //Si il y a un lien entre les deux noeuds
                                    Nodes[i][j].setG(1); //On lui donne un coup
                                    Nodes[i][j].setH(getNodeDistance(Nodes[i][j].getNodePosition(), target)); //On lui donne sa distance par rapport à l'arrivée
                                    Nodes[i][j].setParent(this.currentNode); //On lui assigne son parent
                                    openList.add(Nodes[i][j]);
                                    //System.out.println("Droite");
                                }
                            }
                        }
                    }
                    if(this.Nodes[i][j] != null){
                        if((Nodes[i][j].getNodePosition().getX() == this.currentNode.getNodePosition().getX()-2) && (Nodes[i][j].getNodePosition().getY() == this.currentNode.getNodePosition().getY())){ //Gauche
                            for(int x=0; x<this.Links.size(); x++){
                                if(this.Links.get(x).getFromNode() == this.currentNode && this.Links.get(x).getToNode() == Nodes[i][j]){ //Si il y a un lien entre les deux noeuds
                                    Nodes[i][j].setG(1); //On lui donne un coup
                                    Nodes[i][j].setH(getNodeDistance(Nodes[i][j].getNodePosition(), target)); //On lui donne sa distance par rapport à l'arrivée
                                    Nodes[i][j].setParent(this.currentNode); //On lui assigne son parent
                                    openList.add(Nodes[i][j]);
                                    //System.out.println("Gauche");
                                }
                            }
                        }
                    }
                    if(this.Nodes[i][j] != null){
                        if((Nodes[i][j].getNodePosition().getX() == this.currentNode.getNodePosition().getX()) && (Nodes[i][j].getNodePosition().getY() == this.currentNode.getNodePosition().getY()-2)){ //Haut
                            for(int x=0; x<this.Links.size(); x++){
                                if(this.Links.get(x).getFromNode() == this.currentNode && this.Links.get(x).getToNode() == Nodes[i][j]){ //Si il y a un lien entre les deux noeuds
                                    Nodes[i][j].setG(1); //On lui donne un coup
                                    Nodes[i][j].setH(getNodeDistance(Nodes[i][j].getNodePosition(), target)); //On lui donne sa distance par rapport à l'arrivée
                                    Nodes[i][j].setParent(this.currentNode); //On lui assigne son parent
                                    openList.add(Nodes[i][j]);
                                    //System.out.println("Haut");
                                }
                            }
                        }
                    }
                    if(this.Nodes[i][j] != null){
                        if((Nodes[i][j].getNodePosition().getX() == this.currentNode.getNodePosition().getX()) && (Nodes[i][j].getNodePosition().getY() == this.currentNode.getNodePosition().getY()+2)){ //Bas
                            for(int x=0; x<this.Links.size(); x++){
                                if(this.Links.get(x).getFromNode() == this.currentNode && this.Links.get(x).getToNode() == Nodes[i][j]){ //Si il y a un lien entre les deux noeuds
                                    Nodes[i][j].setG(1); //On lui donne un coup
                                    Nodes[i][j].setH(getNodeDistance(Nodes[i][j].getNodePosition(), target)); //On lui donne sa distance par rapport à l'arrivée
                                    Nodes[i][j].setParent(this.currentNode); //On lui assigne son parent
                                    openList.add(Nodes[i][j]);
                                    //System.out.println("Bas");
                                }
                            }
                        }
                    }
                }
            }
            minimum = openList.get(0);
            for(int i=1; i<openList.size(); i++){
                if(minimum.getF() >= openList.get(i).getF()){ //On récupère le F minimum
                    minimum = openList.get(i);
                }
            }
            for(int i=0; i<openList.size(); i++){
                if(minimum == openList.get(i)){
                    openList.remove(i);
                }
            }
            closeList.add(minimum);
            this.currentNode = closeList.get(closeList.size()-1);
            if(currentNode.getNodePosition().getX() ==  target.getX() && currentNode.getNodePosition().getY() == target.getY()){
                go = false;
                for(int i=1; i<closeList.size(); i++){
                    System.out.println("(" + closeList.get(i).getNodePosition().getX() + "," + closeList.get(i).getNodePosition().getY() + ")");
                }
                return true;
            }
            z++;
            if(z == 500){ //Si il fait 500 déplacements et qu'il ne réussit pas
                return false;
            }
        }
        return false;
    }

    private int getNodeDistance(Position node, Position target){
        int res = Math.abs(target.getX()-node.getX()) + Math.abs(target.getY()-node.getY());
        return res;
    }

    public ArrayList<Link> getListOfLinks(){
        return this.Links;
    }

    public static void main(String[] args){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, Color.Rouge, new Pawn()), new Player("Ordinateur", "Ordi1", 1, Color.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        try {
            b.setWallOnBoard(b.players[0], new Wall(), WallDirection.Vertical, new Position(9,7));
        } catch (RuleViolated e) {
            System.out.println(e);
        }
        Graph g = new Graph(b, b.players[1]);
        System.out.println(g.dijkstra(b.players[0].getPawn().getPosition(), new Position(16,6)));
    }
}
package be.nicolasdelp.quoridor.objects;

import java.util.ArrayList;

/**
 * La class Graph représent un Board sous forme de graphe
 *
 * @author Delplanque Nicolas
 */
public class Graph {

    private Board board;
    private Position wallPosition;
    private WallDirection wallDirection;
    private Node[][] Nodes = new Node[17][17]; //plateau quoridor
    private ArrayList<Link> Links = new ArrayList<Link>();
    private Node currentNode = new Node(new Position(0, 0));

    /**
     * Constructeur
     * 
     */
    public Graph(Board board, Player otherPlayer, Position position, WallDirection direction){
        this.board = board;
        this.wallPosition = position;
        this.wallDirection = direction;
        setNodes(otherPlayer);
        makeLinks();
    }

    /**
     * Création d'un un noeud par case du plateau sauf dans les cases où il y a un pion adverse
     * 
     */
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

    /**
     * Création de lien entre les noeuds si il n'y a pas de mur entre deux
     * 
     */
    private void makeLinks(){
        for(int j=0; j<17; j+=2){ //X    
            for(int i=1; i<17; i+=2){ //Y
                if(this.board.getBoardBoxes()[j][i].getisOccuped() == false){ //Si il n'y a pas de mur horizontal
                    if(this.Nodes[j][i-1] != null && this.Nodes[j][i+1] != null){
                        this.Links.add(new Link(this.Nodes[j][i-1], this.Nodes[j][i+1])); //Lie 2 noeuds
                        this.Links.add(new Link(this.Nodes[j][i+1], this.Nodes[j][i-1])); //Lie 2 noeuds
                    }
                }
            }
        }
        for(int i=1; i<17; i+=2){ //X
            for(int j=0; j<17; j+=2){ //Y    
                if(this.board.getBoardBoxes()[i][j].getisOccuped() == false){ //Si il n'y a pas de mur vertical
                    if(this.Nodes[i-1][j] != null && this.Nodes[i+1][j] != null){
                        this.Links.add(new Link(this.Nodes[i-1][j], this.Nodes[i+1][j])); //Lie 2 noeuds
                        this.Links.add(new Link(this.Nodes[i+1][j], this.Nodes[i-1][j])); //Lie 2 noeuds
                    }
                }
            }
        }
        if(this.wallDirection == WallDirection.Horizontal){ //On supprime les lien entre les noeuds de part et d'autre du mur
            for(int i=0; i<this.Links.size(); i++){
                if(this.Links.get(i).getFromNode() == this.Nodes[this.wallPosition.getX()+1][this.wallPosition.getY()-1] 
                    && this.Links.get(i).getToNode() == this.Nodes[this.wallPosition.getX()+1][this.wallPosition.getY()+1]){
                        this.Links.remove(i);
                }
                if(this.Links.get(i).getFromNode() == this.Nodes[this.wallPosition.getX()+1][this.wallPosition.getY()+1] 
                    && this.Links.get(i).getToNode() == this.Nodes[this.wallPosition.getX()+1][this.wallPosition.getY()-1]){
                        this.Links.remove(i);
                }

                if(this.Links.get(i).getFromNode() == this.Nodes[this.wallPosition.getX()-1][this.wallPosition.getY()-1] 
                    && this.Links.get(i).getToNode() == this.Nodes[this.wallPosition.getX()-1][this.wallPosition.getY()+1]){
                        this.Links.remove(i);
                }
                if(this.Links.get(i).getFromNode() == this.Nodes[this.wallPosition.getX()-1][this.wallPosition.getY()+1] 
                    && this.Links.get(i).getToNode() == this.Nodes[this.wallPosition.getX()-1][this.wallPosition.getY()-1]){
                        this.Links.remove(i);
                }
            }
        }
        if(this.wallDirection == WallDirection.Vertical){
            for(int i=0; i<this.Links.size(); i++){
                if(this.Links.get(i).getFromNode() == this.Nodes[this.wallPosition.getX()-1][this.wallPosition.getY()+1] 
                    && this.Links.get(i).getToNode() == this.Nodes[this.wallPosition.getX()+1][this.wallPosition.getY()+1]){
                        this.Links.remove(i);
                }
                if(this.Links.get(i).getFromNode() == this.Nodes[this.wallPosition.getX()+1][this.wallPosition.getY()+1] 
                    && this.Links.get(i).getToNode() == this.Nodes[this.wallPosition.getX()-1][this.wallPosition.getY()+1]){
                        this.Links.remove(i);
                }

                if(this.Links.get(i).getFromNode() == this.Nodes[this.wallPosition.getX()-1][this.wallPosition.getY()-1] 
                    && this.Links.get(i).getToNode() == this.Nodes[this.wallPosition.getX()+1][this.wallPosition.getY()-1]){
                        this.Links.remove(i);
                }
                if(this.Links.get(i).getFromNode() == this.Nodes[this.wallPosition.getX()+1][this.wallPosition.getY()-1] 
                    && this.Links.get(i).getToNode() == this.Nodes[this.wallPosition.getX()-1][this.wallPosition.getY()-1]){
                        this.Links.remove(i);
                }
            }
        }
    }

    /**
     * PathFinding
     * 
     * @param source la position de départ
     * @param traget la position d'arrivée
     * @return true si il y a un chemin, false si il n'y en a pas
     */
    public boolean pathFinding(Position source, Position target){
        this.currentNode = this.Nodes[source.getX()][source.getY()]; //Noeud actuel (ou il y a le pion)
        Node minimum;
        boolean go = true;
        ArrayList<Node> openList = new ArrayList<Node>(); //Liste des noeuds ouvert
        ArrayList<Node> closeList = new ArrayList<Node>(); //Liste des noeuds utilisés pour arriver à à destination

        openList.add(this.currentNode); //On ajoute à l'openList le noeud actuel
        closeList.add(this.currentNode); //On ajoute à la closeList le noeud de départ
        this.currentNode.setVisited(true); 

        while(go){
            for(int i=0; i<this.Nodes.length; i++){
                for(int j=0; j<this.Nodes.length; j++){
                    if(this.Nodes[i][j] != null){
                        if((this.Nodes[i][j].getNodePosition().getX() == this.currentNode.getNodePosition().getX()+2) && (this.Nodes[i][j].getNodePosition().getY() == this.currentNode.getNodePosition().getY())){ //Droite
                            for(int x=0; x<this.Links.size(); x++){
                                if(this.Links.get(x).getFromNode() == this.currentNode && this.Links.get(x).getToNode() == Nodes[i][j]){ //Si il y a un lien entre les deux noeuds
                                    if(Nodes[i][j].isVisited() == false){
                                        Nodes[i][j].setG(1); //On lui donne un coup
                                        Nodes[i][j].setH(getNodeDistance(Nodes[i][j].getNodePosition(), target)); //On lui donne sa distance par rapport à l'arrivée
                                        Nodes[i][j].setParent(this.currentNode); //On lui assigne son parent
                                        Nodes[i][j].setVisited(true);
                                        openList.add(Nodes[i][j]); //On l'ajoute à l'openList
                                    }
                                }
                            }
                        }
                    }
                    if(this.Nodes[i][j] != null){
                        if((Nodes[i][j].getNodePosition().getX() == this.currentNode.getNodePosition().getX()-2) && (Nodes[i][j].getNodePosition().getY() == this.currentNode.getNodePosition().getY())){ //Gauche
                            for(int x=0; x<this.Links.size(); x++){
                                if(this.Links.get(x).getFromNode() == this.currentNode && this.Links.get(x).getToNode() == Nodes[i][j]){ //Si il y a un lien entre les deux noeuds
                                    if(Nodes[i][j].isVisited() == false){
                                        Nodes[i][j].setG(1); //On lui donne un coup
                                        Nodes[i][j].setH(getNodeDistance(Nodes[i][j].getNodePosition(), target)); //On lui donne sa distance par rapport à l'arrivée
                                        Nodes[i][j].setParent(this.currentNode); //On lui assigne son parent
                                        Nodes[i][j].setVisited(true);
                                        openList.add(Nodes[i][j]); //On l'ajoute à l'openList
                                    }
                                }
                            }
                        }
                    }
                    if(this.Nodes[i][j] != null){
                        if((Nodes[i][j].getNodePosition().getX() == this.currentNode.getNodePosition().getX()) && (Nodes[i][j].getNodePosition().getY() == this.currentNode.getNodePosition().getY()-2)){ //Haut
                            for(int x=0; x<this.Links.size(); x++){
                                if(this.Links.get(x).getFromNode() == this.currentNode && this.Links.get(x).getToNode() == Nodes[i][j]){ //Si il y a un lien entre les deux noeuds
                                    if(Nodes[i][j].isVisited() == false){
                                        Nodes[i][j].setG(1); //On lui donne un coup
                                        Nodes[i][j].setH(getNodeDistance(Nodes[i][j].getNodePosition(), target)); //On lui donne sa distance par rapport à l'arrivée
                                        Nodes[i][j].setParent(this.currentNode); //On lui assigne son parent
                                        Nodes[i][j].setVisited(true);
                                        openList.add(Nodes[i][j]); //On l'ajoute à l'openList
                                    }
                                }
                            }
                        }
                    }
                    if(this.Nodes[i][j] != null){
                        if((Nodes[i][j].getNodePosition().getX() == this.currentNode.getNodePosition().getX()) && (Nodes[i][j].getNodePosition().getY() == this.currentNode.getNodePosition().getY()+2)){ //Bas
                            for(int x=0; x<this.Links.size(); x++){
                                if(this.Links.get(x).getFromNode() == this.currentNode && this.Links.get(x).getToNode() == Nodes[i][j]){ //Si il y a un lien entre les deux noeuds
                                    if(Nodes[i][j].isVisited() == false){
                                        Nodes[i][j].setG(1); //On lui donne un coup
                                        Nodes[i][j].setH(getNodeDistance(Nodes[i][j].getNodePosition(), target)); //On lui donne sa distance par rapport à l'arrivée
                                        Nodes[i][j].setParent(this.currentNode); //On lui assigne son parent
                                        Nodes[i][j].setVisited(true);
                                        openList.add(Nodes[i][j]); //On l'ajoute à l'openList
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if(openList.size() > 0){ //Si il y a toujours un noeud dans l'openList
                minimum = openList.get(0);
            } else {
                return false; //Si il n'y a plus de posibilitées c'est qu'il ne peut pas y arriver
            }
            for(int i=1; i<openList.size(); i++){
                if(minimum.getF() >= openList.get(i).getF()){ //On récupère le F minimum
                    minimum = openList.get(i);
                }
            }
            for(int i=0; i<openList.size(); i++){ //On retire le noeud de l'openList
                if(minimum == openList.get(i)){
                    openList.remove(i);
                }
            }
            closeList.add(minimum); //On ajoute le noeud à la closeList
            this.currentNode = closeList.get(closeList.size()-1); //Le noeud courrant devient le minimum
            if(currentNode.getNodePosition().getX() ==  target.getX() && currentNode.getNodePosition().getY() == target.getY()){ //Si on est arrivée à destination
                go = false; 
                for(int i=1; i<closeList.size(); i++){
                    System.out.println("(" + closeList.get(i).getNodePosition().getX() + "," + closeList.get(i).getNodePosition().getY() + ")");
                }
                return true;
            }
        }
        return false;
    }

    /**
     * Distance de Manhattan
     * 
     * @param node un noeud
     * @param traget le noeud d'arrivé
     * @return la distance entre un noeud et le noeud d'arrivée
     */
    private int getNodeDistance(Position node, Position target){
        int res = Math.abs(target.getX()-node.getX()) + Math.abs(target.getY()-node.getY());
        return res;
    }
}
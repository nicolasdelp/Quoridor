package be.nicolasdelp.quoridor.graph;

import java.util.ArrayList;

import be.nicolasdelp.quoridor.objects.*;

/**
 * La class Graph represent un Board sous forme de graphe
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
    // private ArrayList<Node> path;
    private ArrayList<Node> closeList = new ArrayList<Node>(); //Liste des noeuds utilises pour arriver a destination

    /**
     * Constructeur
     * 
     * @param board un plateau
     * @param otherPlayer le joueur adverse
     */
    public Graph(Board board, Player otherPlayer){
        this.board = board;
        setNodes(otherPlayer);
    }

    /**
     * Cree les lien entre les noeuds + supprime les liens entres les noeuds de part et d'autre du mur
     * 
     * @param direction la direction du mur
     * @param position la position du mur
     */
    public void setWall(WallDirection direction, Position position){
        this.wallDirection = direction;
        this.wallPosition = position;
        makeLinks();
    }

    /**
     * Cree les lien entre les noeuds
     * 
     */
    public void pathForIA(){
        makeLinks();
    }

    /**
     * Creation d'un noeud par case (pour pion) du plateau sauf dans les cases occupees
     * 
     * @param otherPlayer le joueur adverse
     */
    private void setNodes(Player otherPlayer){
        for(int i = 0; i<this.board.getLength(); i++){
            for(int j = 0; j <this.board.getWidth(); j++){
                if(this.board.getBoardBoxes()[i][j].getisPawnBox()){ //Si c'est une case pour pion
                    this.Nodes[i][j] = new Node(new Position(i, j));
                } else{
                    this.Nodes[i][j] = null;
                }
            }
        }
        this.Nodes[otherPlayer.getPawn().getPosition().getX()][otherPlayer.getPawn().getPosition().getY()] = null; //On ne cree pas de noeud ou il y un pion adverse
    }

    /**
     * Creation de lien entre les noeuds si il n'y a pas de mur entre deux
     * 
     */
    private void makeLinks(){
        for(int j=0; j<17; j+=2){ //X    
            for(int i=1; i<17; i+=2){ //Y
                if(this.board.getBoardBoxes()[j][i].getisOccuped() == false){ //Si il n'y a pas de mur horizontal
                    if(this.Nodes[j][i-1] != null && this.Nodes[j][i+1] != null){ //Si il n'y a pas de pion dans les noeuds
                        this.Links.add(new Link(this.Nodes[j][i-1], this.Nodes[j][i+1])); //Lie 2 noeuds
                        this.Links.add(new Link(this.Nodes[j][i+1], this.Nodes[j][i-1])); //Lie 2 noeuds
                    }
                }
            }
        }
        for(int j=1; j<17; j+=2){ //X  
            for(int i=0; i<17; i+=2){ //Y 
                if(this.board.getBoardBoxes()[j][i].getisOccuped() == false){ //Si il n'y a pas de mur vertical
                    if(this.Nodes[j-1][i] != null && this.Nodes[j+1][i] != null){
                        this.Links.add(new Link(this.Nodes[j-1][i], this.Nodes[j+1][i]));
                        this.Links.add(new Link(this.Nodes[j+1][i], this.Nodes[j-1][i]));
                    }
                }
            }
        }
        if(this.wallDirection == WallDirection.Horizontal){ //Si le mur est horizontal
            for(int i=0; i<this.Links.size(); i++){
                if(this.Links.get(i).getFromNode() == this.Nodes[this.wallPosition.getX()+1][this.wallPosition.getY()-1] && this.Links.get(i).getToNode() == this.Nodes[this.wallPosition.getX()+1][this.wallPosition.getY()+1]){
                    this.Links.remove(i);
                }
                if(this.Links.get(i).getFromNode() == this.Nodes[this.wallPosition.getX()+1][this.wallPosition.getY()+1] && this.Links.get(i).getToNode() == this.Nodes[this.wallPosition.getX()+1][this.wallPosition.getY()-1]){
                    this.Links.remove(i);
                }
                if(this.Links.get(i).getFromNode() == this.Nodes[this.wallPosition.getX()-1][this.wallPosition.getY()-1] && this.Links.get(i).getToNode() == this.Nodes[this.wallPosition.getX()-1][this.wallPosition.getY()+1]){
                    this.Links.remove(i);
                }
                if(this.Links.get(i).getFromNode() == this.Nodes[this.wallPosition.getX()-1][this.wallPosition.getY()+1] && this.Links.get(i).getToNode() == this.Nodes[this.wallPosition.getX()-1][this.wallPosition.getY()-1]){
                    this.Links.remove(i);
                }
            }
        }
        if(this.wallDirection == WallDirection.Vertical){ //Si le mur est vertical
            for(int i=0; i<this.Links.size(); i++){
                if(this.Links.get(i).getFromNode() == this.Nodes[this.wallPosition.getX()-1][this.wallPosition.getY()+1] && this.Links.get(i).getToNode() == this.Nodes[this.wallPosition.getX()+1][this.wallPosition.getY()+1]){
                    this.Links.remove(i);
                }
                if(this.Links.get(i).getFromNode() == this.Nodes[this.wallPosition.getX()+1][this.wallPosition.getY()+1] && this.Links.get(i).getToNode() == this.Nodes[this.wallPosition.getX()-1][this.wallPosition.getY()+1]){
                    this.Links.remove(i);
                }
                if(this.Links.get(i).getFromNode() == this.Nodes[this.wallPosition.getX()-1][this.wallPosition.getY()-1] && this.Links.get(i).getToNode() == this.Nodes[this.wallPosition.getX()+1][this.wallPosition.getY()-1]){
                    this.Links.remove(i);
                }
                if(this.Links.get(i).getFromNode() == this.Nodes[this.wallPosition.getX()+1][this.wallPosition.getY()-1] && this.Links.get(i).getToNode() == this.Nodes[this.wallPosition.getX()-1][this.wallPosition.getY()-1]){
                    this.Links.remove(i);
                }
            }
        }
    }

    /**
     * PathFinding
     * 
     * @param source la position de depart
     * @param target la position d'arrivee
     * @return true si il y a un chemin, false si il n'y en a pas
     */
    public boolean pathFinding(Position source, Position target){
        this.currentNode = this.Nodes[source.getX()][source.getY()]; //Noeud actuel (ou est le pion)
        Node minimum;
        ArrayList<Node> openList = new ArrayList<Node>(); //Liste des noeuds ouvert
        boolean go = true;

        openList.add(this.currentNode); //On ajoute a l'openList le noeud actuel
        //closeList.add(this.currentNode); //On ajoute a la closeList le noeud de depart
        this.currentNode.setVisited(true); //Le noeud de depart a ete visite

        while(go){
            for(int i=0; i<this.Nodes.length; i++){ //Pour chaque noeuds
                for(int j=0; j<this.Nodes.length; j++){
                    if(this.Nodes[i][j] != null){ //Si le noeud existe (cad si il n'est pas occupe)
                        if((this.Nodes[i][j].getNodePosition().getX() == this.currentNode.getNodePosition().getX()+2) && (this.Nodes[i][j].getNodePosition().getY() == this.currentNode.getNodePosition().getY())){ //Si le noeud que l'on regarde est celui de droite
                            for(int x=0; x<this.Links.size(); x++){ //On regarde chaque lien cree entre tout les noeuds
                                if(this.Links.get(x).getFromNode() == this.currentNode && this.Links.get(x).getToNode() == this.Nodes[i][j]){ //Si il y a un lien entre les deux noeuds dans les 2 sens 
                                    if(this.Nodes[i][j].isVisited() == false){ //Si le noeud n'a pas deja ete visite
                                        this.Nodes[i][j].setParent(this.currentNode); //On lui assigne son noeud parent
                                        this.Nodes[i][j].setG(this.Nodes[i][j].getParent().getG()+1); //On lui donne un coup
                                        this.Nodes[i][j].setH(getNodeDistance(this.Nodes[i][j].getNodePosition(), target)); //On lui donne sa distance par rapport au noeud d'arrive
                                        this.Nodes[i][j].setVisited(true); //Il a ete visite
                                        openList.add(this.Nodes[i][j]); //On l'ajoute a l'openList
                                    }
                                }
                            }
                        }
                        if((this.Nodes[i][j].getNodePosition().getX() == this.currentNode.getNodePosition().getX()-2) && (this.Nodes[i][j].getNodePosition().getY() == this.currentNode.getNodePosition().getY())){ //Si le noeud que l'on regarde est celui de gauche
                            for(int x=0; x<this.Links.size(); x++){
                                if(this.Links.get(x).getFromNode() == this.currentNode && this.Links.get(x).getToNode() == this.Nodes[i][j]){
                                    if(this.Nodes[i][j].isVisited() == false){
                                        this.Nodes[i][j].setParent(this.currentNode);
                                        this.Nodes[i][j].setG(this.Nodes[i][j].getParent().getG()+1);
                                        this.Nodes[i][j].setH(getNodeDistance(this.Nodes[i][j].getNodePosition(), target));
                                        this.Nodes[i][j].setVisited(true);
                                        openList.add(this.Nodes[i][j]);
                                    }
                                }
                            }
                        }
                        if((this.Nodes[i][j].getNodePosition().getX() == this.currentNode.getNodePosition().getX()) && (this.Nodes[i][j].getNodePosition().getY() == this.currentNode.getNodePosition().getY()-2)){ //Si le noeud que l'on regarde est celui d'en haut
                            for(int x=0; x<this.Links.size(); x++){
                                if(this.Links.get(x).getFromNode() == this.currentNode && this.Links.get(x).getToNode() == this.Nodes[i][j]){
                                    if(this.Nodes[i][j].isVisited() == false){
                                        this.Nodes[i][j].setParent(this.currentNode);
                                        this.Nodes[i][j].setG(this.Nodes[i][j].getParent().getG()+1);
                                        this.Nodes[i][j].setH(getNodeDistance(this.Nodes[i][j].getNodePosition(), target));
                                        this.Nodes[i][j].setVisited(true);
                                        openList.add(this.Nodes[i][j]);
                                    }
                                }
                            }
                        }
                        if((this.Nodes[i][j].getNodePosition().getX() == this.currentNode.getNodePosition().getX()) && (this.Nodes[i][j].getNodePosition().getY() == this.currentNode.getNodePosition().getY()+2)){ //Si le noeud que l'on regarde est celui d'en bas
                            for(int x=0; x<this.Links.size(); x++){
                                if(this.Links.get(x).getFromNode() == this.currentNode && this.Links.get(x).getToNode() == this.Nodes[i][j]){
                                    if(this.Nodes[i][j].isVisited() == false){
                                        this.Nodes[i][j].setParent(this.currentNode);
                                        this.Nodes[i][j].setG(this.Nodes[i][j].getParent().getG()+1);
                                        this.Nodes[i][j].setH(getNodeDistance(this.Nodes[i][j].getNodePosition(), target));
                                        this.Nodes[i][j].setVisited(true);
                                        openList.add(this.Nodes[i][j]);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if(openList.size() > 0){ //Si il y a toujours un noeud dans l'openList
                minimum = openList.get(0); //Le minimum est le noeud de depart
            } else {
                return false; //Si il n'y a plus de posibilitees c'est qu'il n'y a pas de chemin
            }
            for(int i=1; i<openList.size(); i++){ 
                if(minimum.getF() > openList.get(i).getF()){ //On recupere le noeud ayant le F (G + H) minimum de l'openList
                    minimum = openList.get(i);
                }
            }
            for(int i=0; i<openList.size(); i++){ //On retire le noeud ayant le F minimum de l'openList
                if(minimum.equals(openList.get(i))){
                    openList.remove(i);
                }
            }
            closeList.add(minimum); //On ajoute le noeud a la closeList (le chemin a suivre)
            this.currentNode = closeList.get(closeList.size()-1); //Le noeud minimum devient le noeud courant

            if(currentNode.getNodePosition().getX() ==  target.getX() && currentNode.getNodePosition().getY() == target.getY()){ //Si on est arrivee au noeud de destination
                go = false;
                closeList.remove(0); //On enleve le noeud de depart
                return true;
            }
        }
        return false;
    }

    /**
     * Distance de Manhattan
     * 
     * @param node un noeud
     * @param traget le noeud d'arrive
     * @return la distance entre un noeud et le noeud d'arrivee
     */
    private int getNodeDistance(Position node, Position target){
        int res = Math.abs(target.getX()-node.getX()) + Math.abs(target.getY()-node.getY());
        return res;
    }

    /**
     * Accesseur de la closeList (le chemin a suivre)
     * 
     * @return la closeList
     */
    public ArrayList<Node> getPath(){
        return this.closeList;
    }
}
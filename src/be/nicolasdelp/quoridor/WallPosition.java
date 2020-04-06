package be.nicolasdelp.quoridor;

public enum WallPosition {

    Horizontal(0), Vertical(1);

    private int position;

    private WallPosition(int index){
        this.position = index;
    }

    public int getWallPosition(){
        return this.position;
    }

    public static void main(String[] args) {
        WallPosition x = WallPosition.Horizontal;
        System.out.println(x.getWallPosition());
    }

}
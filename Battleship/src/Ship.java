public class Ship {
    String name;
    char character;
    int row; //x and y contains the location of the front of the ship
    int col;
    int length;
    boolean direction; //true = horizontal
    int hitCount = 0;

    String getShipType()
    {
        return name;
    }

    public int getLength(){ return length; }

    public int getRow() { return row; }

    public int getCol() { return col; }

    public boolean getDirection()
    {
        return direction;
    }


    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col){
        this.col  = col;
    }

    public void setDirection(boolean direction) {
        this.direction = direction;
    }

    public boolean isSunk()
    {
        if(hitCount == length)
        {
            return true;
        }
        return false;
    }
}

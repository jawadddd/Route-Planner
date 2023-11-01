public class Node2 {
    public int rowNumber;
    public int colNumber;

    public Node2() {
        this.rowNumber = 0;
        this.colNumber = 0;
    }

    public Node2(int row, int col) {
        this.rowNumber = row;
        this.colNumber = col;
    }
    public void print()
    {
        System.out.print("("+this.rowNumber + "," + this.colNumber + ") ");
    }
}
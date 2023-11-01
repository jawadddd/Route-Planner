public class population {
    public static int chromosomeSize=6;
    public int Value=0;
    
    public  Node2[] coordinates = new Node2[chromosomeSize];
    public population() {
        for(int i=0;i<chromosomeSize;i++)
        {
            coordinates[i] = new Node2(0,0);
        }
    }

    public population(int row1, int col1,int row2, int col2,int row3, int col3,int row4, int col4,int row5, int col5,int row6, int col6) {
        System.out.println("row1,col1:"+row1+col1);
        System.out.println("row2,col2:"+row2+col2);

        this.coordinates[0] = new Node2(row1,col1);
         this.coordinates[1] = new Node2(row2,col2);
         this.coordinates[2] = new Node2(row3,col3);
         this.coordinates[3] = new Node2(row4,col4);
         this.coordinates[4] = new Node2(row5,col5);
         this.coordinates[5] = new Node2(row6,col6);
         
    }
    public void printPop() {
       
         System.out.print("Chromosome:");
        for (int i = 0; i < chromosomeSize; i++) {
            this.coordinates[i].print();
        }
        System.out.println();
    }
    




}

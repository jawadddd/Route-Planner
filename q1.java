import java.util.*;


class Node implements Comparable<Node> {
    int x, y;
    int f, g, h;
    
    Node parent;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.f, other.f);
    }
}

public class q1 {
    private static int ROWS = 40;
    private static int COLS = 40;
    public static int popSize=10;
      public static int startX, startY, endX, endY;
    
  public static population[] chromosome = new population[popSize];
  
    public static int shortestNoOfNodes=0; 
    private static int[][] grid = new int[ROWS][COLS];

    public static void main(String[] args) {
        initializeGrid();
        printGrid();

        int found=0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter start node coordinates (x y):");
        startX = scanner.nextInt();
        startY = scanner.nextInt();

        System.out.println("Enter end node coordinates (x y):");
        endX = scanner.nextInt();
        endY = scanner.nextInt();

        List<Node> path = findPath(startX, startY, endX, endY);

        if (path != null) {
            System.out.println("Path found!");
            markPathOnGrid(path);
            printGrid();
            int no=0;
            no=getNumberOfNodesInPath(path);
            shortestNoOfNodes=no;
            System.out.println("No of nodes in shortest path(A star): "+shortestNoOfNodes);
           int x1=0;
           System.out.println("press 1 to continue:");
           x1=scanner.nextInt();
          
            System.out.println("Now initialize our population (10 rows , 6 cols ) for Genetic approach:");
            initializePopulation();
            printPopulation();
    
          
for(int i=0;i<popSize;i++)
{
     initializeGrid();
        printGrid();


int len1=0;
int len2=0;
int len3=0;
int len4=0;
int len5=0;
int totalLength=0;
List<Node> path1=findPath(chromosome[i].coordinates[0].rowNumber,chromosome[i].coordinates[0].colNumber,chromosome[i].coordinates[1].rowNumber,chromosome[i].coordinates[1].colNumber);
//HERE IN Find path function, i have not used genetic path finding, i have used a start to find path
// but here genetic path finding algo should be used  
if (path1 != null) {
     System.out.println("Path found!");
            markPathOnGrid(path1);
            printGrid();
            len1=0;
            len1=getNumberOfNodesInPath(path1);
 }
 else
 {
     System.out.println("Path not found!");
 }

List<Node> path2=findPath(chromosome[i].coordinates[1].rowNumber,chromosome[i].coordinates[1].colNumber,chromosome[i].coordinates[2].rowNumber,chromosome[i].coordinates[2].colNumber);
 if (path2 != null) {
     System.out.println("Path found!");
            markPathOnGrid(path2);
            printGrid();
            len2=0;
            len2=getNumberOfNodesInPath(path2);
 }
 else
 {
     System.out.println("Path not found!");
 }

List<Node> path3=findPath(chromosome[i].coordinates[2].rowNumber,chromosome[i].coordinates[2].colNumber,chromosome[i].coordinates[3].rowNumber,chromosome[i].coordinates[3].colNumber);
 if (path3 != null) {
     System.out.println("Path found!");
            markPathOnGrid(path3);
            printGrid();
            len3=0;
            len3=getNumberOfNodesInPath(path3);
 }
 else
 {
     System.out.println("Path not found!");
 }

List<Node> path4=findPath(chromosome[i].coordinates[3].rowNumber,chromosome[i].coordinates[3].colNumber,chromosome[i].coordinates[4].rowNumber,chromosome[i].coordinates[4].colNumber);
 if (path4 != null) {
     System.out.println("Path found!");
            markPathOnGrid(path4);
            printGrid();
            len4=0;
            len4=getNumberOfNodesInPath(path4);
 }
 else
 {
     System.out.println("Path not found!");
 }

List<Node> path5=findPath(chromosome[i].coordinates[4].rowNumber,chromosome[i].coordinates[4].colNumber,chromosome[i].coordinates[5].rowNumber,chromosome[i].coordinates[5].colNumber);
 if (path5 != null) {
     System.out.println("Path found!");
            markPathOnGrid(path5);
            printGrid();
            len5=0;
            len5=getNumberOfNodesInPath(path5);
 }
 else
 {
     System.out.println("Path not found!");
 }
totalLength=len1+len2+len3+len4+len5;
     chromosome[i].Value=totalLength;


if(i==9)
{
    for(int j=0;j<popSize;j++)
{
    
    if(chromosome[j].Value<=50)
    {
        found=1;
        break;
    }
}
int temp22=0;
for(int j=0;j<popSize;j++)
{
temp22=j+1;
    
    System.out.println("Fitness Value of chromosome "+temp22+" is :"+chromosome[j].Value);
}
    if(found==1)
    {

    }
    else
    {
        System.out.println("Enter 1 to further mutation and crossover:");
int x2=scanner.nextInt();

//mutation
 Random random = new Random();   
 int randPop=random.nextInt(10);
 int newone=random.nextInt(6);

int newrow=random.nextInt(40);
int newcol=random.nextInt(40);
 chromosome[randPop].coordinates[newone].rowNumber=newrow;
 chromosome[randPop].coordinates[newone].rowNumber=newcol;
 

//crossover

 int randCross1=random.nextInt(10);
 int randCross2=random.nextInt(10);
 int crossPoint=random.nextInt(5);
 int k=crossPoint;
 int temp1=0;
    int temp2=0;
 for(;k<6;k++)
 {//swap
    //I am not creating more populations right now after crossover, i am updating those chromosomes which are being crossed over
    // i should not do like this,1 chromosome should be increased after crossover
    //then based on fitness value of 12 chromosomes, again ten chromosomes should be remained left after leaving last two chromosomes from sorted list of chromosomes in population of size 12 and then again population size will become 10  
temp1=chromosome[randCross1].coordinates[k].rowNumber;
temp2=chromosome[randCross1].coordinates[k].colNumber;
chromosome[randCross1].coordinates[k].rowNumber=chromosome[randCross2].coordinates[k].rowNumber;
chromosome[randCross1].coordinates[k].colNumber=chromosome[randCross2].coordinates[k].colNumber;
chromosome[randCross2].coordinates[k].rowNumber=temp1;
chromosome[randCross2].coordinates[k].colNumber=temp2;
 }




        i=-1;
    }
}


}





            
        } else {
            System.out.println("No path found.");
        }


        scanner.close();
    }

    private static void initializeGrid() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                grid[i][j] = 0;
            }
        }

        // Place obstacles (set cells to 1)
        grid[5][9] = 1;
        grid[15][29] = 1;
        grid[25][39] = 1;
        grid[5][2] = 1;
        grid[15][14] = 1;
        grid[25][30] = 1;
        grid[10][5] = 1;
        grid[20][15] = 1;
        grid[30][25] = 1;
        grid[8][8] = 1;
        grid[12][12] = 1;
        grid[16][16] = 1;
        grid[24][24] = 1;
        grid[28][28] = 1;
    }
    private static int getNumberOfNodesInPath(List<Node> path) {
        if (path != null) {
            return path.size();
        } else {
            return 0;
        }
    }
    private static void printGrid() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (grid[i][j] == 0) {
                    System.out.print("0 ");
                } else {
                    if(grid[i][j] == 2)
                    {
                        System.out.print("# ");                        
                    }
                    else
                    {
                        System.out.print("1 ");
                    }
                }
            }
            System.out.println();
        }
    }

    private static List<Node> findPath(int startX, int startY, int endX, int endY) {
        PriorityQueue<Node> openSet = new PriorityQueue<>();
        Node[][] nodes = new Node[ROWS][COLS];

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                nodes[i][j] = new Node(i, j);
                nodes[i][j].g = Integer.MAX_VALUE;
                nodes[i][j].h = Math.abs(i - endX) + Math.abs(j - endY);
            }
        }

        Node startNode = nodes[startX][startY];
        Node endNode = nodes[endX][endY];

        startNode.g = 0;
        startNode.f = startNode.h;

        openSet.add(startNode);

        while (!openSet.isEmpty()) {
            Node current = openSet.poll();

            if (current == endNode) {
                // Reconstruct path
                List<Node> path = new ArrayList<>();
                Node temp = endNode;
                while (temp != null) {
                    path.add(temp);
                    temp = temp.parent;
                }
                Collections.reverse(path);
                return path;
            }

            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (i == 0 && j == 0) continue;

                    int newX = current.x + i;
                    int newY = current.y + j;

                    if (newX >= 0 && newX < ROWS && newY >= 0 && newY < COLS) {
                        Node neighbor = nodes[newX][newY];

                        if (grid[newX][newY] == 1) // Skip obstacles
                            continue;

                        int tentativeG = current.g + 1;

                        if (tentativeG < neighbor.g) {
                            neighbor.parent = current;
                            neighbor.g = tentativeG;
                            neighbor.f = neighbor.g + neighbor.h;

                            if (!openSet.contains(neighbor)) {
                                openSet.add(neighbor);
                            }
                        }
                    }
                }
            }
        }

        return null; // No path found
    }

    private static void markPathOnGrid(List<Node> path) {
        for (Node node : path) {
            grid[node.x][node.y] = 2; // Mark path with 2
        }
    }
    private static void initializePopulation() {
        int row1,row2,row3,row4,row5,row6;
        int col1,col2,col3,col4,col5,col6;

        for (int i = 0; i < popSize; i++) {
        Random random = new Random();   
                // row1 = startX;
                // col1 = startY;
                // row2 = random.nextInt(40);
                // System.out.print("row2:  "+row2); 

                // col2 = random.nextInt(40);
                // System.out.print("COL2:  "+col2); 

                // row3 = random.nextInt(40);
                // col3 = random.nextInt(40);
                // row4= random.nextInt(40);
                // col4 = random.nextInt(40);
                // row5 = random.nextInt(40);
                // col5 = random.nextInt(40);
                // row6 = endX;
                // col6 = endY;
                
                chromosome[i] = new population(startX,startY,random.nextInt(40),random.nextInt(40),random.nextInt(40),random.nextInt(40),random.nextInt(40),random.nextInt(40),random.nextInt(40),random.nextInt(40),endX,endY);
            
        }
    }

    // Function to print the population matrix
    private static void printPopulation() {
        System.out.println("Population Is :- ");
           chromosome[0].printPop();
                      chromosome[1].printPop();
           chromosome[2].printPop();
                      chromosome[3].printPop();
           chromosome[4].printPop();
                      chromosome[5].printPop();
           chromosome[6].printPop();
                      chromosome[7].printPop();
           chromosome[9].printPop();
                      chromosome[9].printPop();

            System.out.println();
        
    }
}

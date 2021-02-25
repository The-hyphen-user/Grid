//building minefield in java
//daniel wamsher
//started feb 16 2021

//import java.swing*
import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
import java.util.Random;

public class GridMain01 {
    public static Button[][] Grid;


    public static void main(String[] args) {

        boolean menuState = true;

        while (menuState){
            JFrame menu = new JFrame("menu");

menuState = false;
        }





        Scanner in = new Scanner(System.in);

        System.out.println("begin");
        System.out.println("numbers not test corrected");

        System.out.println("rows?");
        int rows = 16;
        //int rows = in.nextInt();

        System.out.println("columns?");
        //int columns = in.nextInt();
        int columns = 16;

        //int[][] Grid = new int[rows][columns];
        System.out.println();

        System.out.printf("number of bombs? (%d-%d suggested)%n",rows*columns/6, rows*columns/4);
        //int bombs = in.nextInt();
        int bombs = 40;



        //Button[][]
         Grid = PlantBombs(rows, columns, bombs);
        CalculateAdjacent(Grid);

        Board mainWindow = new Board(1000,1000,"Mine Field");
        mainWindow.setLayout(new GridLayout(rows,columns,5,5));




        for (int i=0;i<rows;i++){
            for (int j = 0;j<columns;j++) {
                mainWindow.add(Grid[i][j]);
                //Grid[i][j].setText(Integer.toString(Grid[i][j].nearbyBombCount));
                //System.out.print("   I:"+i+" J:"+j);
            }
            //System.out.println(" ");
        }

        System.out.println("got here");
        mainWindow.setVisible(true);










        //Print(Grid);
        //int[][] bombLocations = new int[rows][columns];//not used
        //Button[][] Grid = PlantBombs(rows, columns, bombs);
        //Print(Grid);
        //CalculateAdjacent(Grid);
        //Print(Grid);
        /*
        int boardWidth = 1000;
        int boardHeight = 1000;
        Board mainBoard = new Board(boardWidth,boardHeight, "Title goes here");
        Button temp = new Button("press");
        Button temp2 = new Button(false, 0);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JLabel label = new JLabel();


        label.add(temp);
        label.add(temp2);

        panel.add(label);

        mainBoard.add(panel);

        mainBoard.setVisible(true);
        //mainBoard.getContentPane().add(temp);
        //mainBoard.getContentPane().add(temp2);

        //temp.setTitle("words");

        //mainBoard.addButton(50, 50, temp);
        */


        /*
         Board board = new Board(1000,1000,"Frame title");
         JPanel p = new JPanel();
        p.setLayout(new GridLayout());
        JLabel l = new JLabel("Label Title");
        Button button = new Button();
        button.setText("button");
        p.add(l);
        p.add(button);
        for (int i =0;i<5;i++){
            Button b = new Button();
            b.setText("Button# "+i+1);
            p.add(b);
            System.out.print(i);
        }
        board.add(p);
        board.setSize(1000, 1000);
        //board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //board.setLocationRelativeTo(null);
        board.setVisible(true);
        p.repaint();






checkForZeros(row+1,col);


        checkForZeros(row,col-1);
*/


    }//end of main


    public static void checkForZeros(int row, int col) {


        if (row+1 != Grid.length){
            if (!Grid[row+1][col].getText().equals("0") && Grid[row+1][col].nearbyBombCount == 0){
                Grid[row+1][col].setText("0");
                checkForZeros(row+1,col);
                System.out.println("wooooooords");
                System.out.println(Grid[row+1][col].getText());
            }else {
                Grid[row+1][col].setText(Integer.toString(Grid[row+1][col].nearbyBombCount));
            }
        }
        if (col+1 != Grid[0].length){
            if (!Grid[row][col+1].getText().equals("0") && Grid[row][col+1].nearbyBombCount == 0){
                Grid[row][col+1].setText("0");
                checkForZeros(row,col+1);
                System.out.println("wooooooords");
                System.out.println(Grid[row][col+1].getText());
            } else{
                Grid[row][col+1].setText(Integer.toString(Grid[row][col+1].nearbyBombCount));
            }
        }
        if (col != 0){
            if (!Grid[row][col-1].getText().equals("0") && Grid[row][col-1].nearbyBombCount == 0){
                Grid[row][col-1].setText("0");
                checkForZeros(row,col-1);
                System.out.println("wooooooords");
                System.out.println(Grid[row][col-1].getText());
            } else{
                Grid[row][col-1].setText(Integer.toString(Grid[row][col-1].nearbyBombCount));
            }
        }
        if (row != 0){
            if (!Grid[row-1][col].getText().equals("0") && Grid[row-1][col].nearbyBombCount == 0){
                Grid[row-1][col].setText("0");
                checkForZeros(row-1,col);
                System.out.println("wooooooords");
                System.out.println(Grid[row-1][col].getText());
            } else{
                Grid[row-1][col].setText(Integer.toString(Grid[row-1][col].nearbyBombCount));
            }
        }
        //if (Grid[i+1][j+1] != null && Grid[i+1][j+1].getText().equals("0") && Grid[i][j].nearbyBombCount == 0){}


    }

    public static void Print(Button[][] arr){
        for (int i=0;i<arr.length-1;i++) {
            for (int j=0;j<arr[0].length-1;j++){
                System.out.print(arr[i][j].nearbyBombCount + ":");
                System.out.print(arr[i][j].isBomb + " ");
            }
            System.out.printf("%n");
        }
    }

    public static Button[][] PlantBombs(int row, int col, int bombsToBePlanted){
        Button[][] grid = new Button[row][col];

        for (int i=0;i<grid.length;i++) {
            for (int j=0;j<grid[0].length;j++) {//go through array
                System.out.print("   I:"+i+" J:"+j);
                grid[i][j] = new Button(false, 0,i,j);
                //grid[i][j].setPreferredSize(new Dimension(100, 100));
                //grid[i][j].printIsBomb();
            }
            System.out.println(" ");
        }

        if (false){//if bombs<half spaces
            //make all spots bombs
            //dig up mines
        } else {


            Random rand = new Random();
            int bombsPlanted = 0;
            int rows = grid.length;
            int columns = grid[0].length;
            while (bombsPlanted < bombsToBePlanted) {
                int x =( rand.nextInt(rows));
                //int y = rand.nextInt(columns);
                int y =( rand.nextInt(col));
                if (!grid[x][y].isBomb) {
                    grid[x][y].becomeBomb();
                    grid[x][y].nearbyBombCount = -1;
                    bombsPlanted++;
                    //System.out.println("bomb planted at:" +x+", "+y);
                }

            }
        }


        return grid;
    }



    public static void CalculateAdjacent(Button[][] arr){


        int row = arr.length;
        System.out.println("row:"+row);
        int col = arr[0].length;
        System.out.println("col:"+col);
        for (int i=0;i<row;i++) {
            for (int j=0;j<col;j++) {//go through grid array
                if(!arr[i][j].isBomb) {
                    int nearbyBombCount = 0;
                    //int row = arr.length;
                    //int col = arr[0].length;
                    for (int k = i - 1; k < i + 2; k++) {
                        for (int l = j - 1; l < j + 2; l++) {
                            //System.out.println(i +" "+j+" "+row+" "+col);
                            //System.out.println(k+" "+l);
                                if (k != -1 && l != -1 && k != row && l != col) {//if out of bounds, cpu intensive fix when done

                                    if (arr[k][l].isBomb) {
                                        nearbyBombCount++;
                                    }
                                }
                        }

                    }
                    //done checking surrounding here
                    arr[i][j].nearbyBombCount = nearbyBombCount;
                    //System.out.println(nearbyBombCount);
                }
            }
        }
    }

}


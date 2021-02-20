//building minefield in java
//daniel wamsher
//started feb 16 2021


import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
import java.util.Random;

public class GridMain01 {//push push baby
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("begin");
        System.out.println("numbers not test corrected");

        System.out.println("rows?");
        int rows = 5;
        //int rows = in.nextInt();

        System.out.println("columns?");
        //int columns = in.nextInt();
        int columns = 5;

        //int[][] Grid = new int[rows][columns];
        System.out.println();

        System.out.printf("number of bombs? (%d-%d suggested)%n",rows*columns/6, rows*columns/4);
        //int bombs = in.nextInt();
        int bombs = 6;




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

         Board board = new Board(1000,1000,"Frame title");
         JPanel p = new JPanel();
        p.setLayout(new FlowLayout());
        JLabel l = new JLabel("Label Title");
        JButton button = new JButton();
        button.setText("button");
        p.add(l);
        p.add(button);
        board.add(p);
        board.setSize(1000, 1000);
        //board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //board.setLocationRelativeTo(null);
        board.setVisible(true);
        p.repaint();








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

        for (int i=0;i<grid.length-1;i++) {
            for (int j=0;j<grid[0].length-1;j++) {//go through array
                grid[i][j] = new Button(false, 0);
                //grid[i][j].printIsBomb();
            }
        }



        Random rand = new Random();
        int bombsPlanted = 0;
        int rows = grid.length;
        int columns = grid[0].length;
        while (bombsPlanted<bombsToBePlanted){
            int x = rand.nextInt(rows-1);
            int y = rand.nextInt(columns-1);
            if(grid[x][y].isBomb == false){
                grid[x][y].becomeBomb();
                bombsPlanted++;
            }

        }

        return grid;
    }



    public static Button[][] CalculateAdjacent(Button[][] arr){


        for (int i=0;i<arr.length-1;i++) {
            for (int j=0;j<arr[0].length-1;j++) {//go through grid array
                if(arr[i][j].isBomb == false) {
                    int nearbyBombCount = 0;
                    int row = arr.length;
                    int col = arr[0].length;
                    for (int k = i - 1; k < i + 2; k++) {
                        for (int l = j - 1; l < j + 2; l++) {
                            //System.out.println(i +" "+j+" "+row+" "+col);
                            //System.out.println(k+" "+l);
                                if (k != -1 && l != -1 && k != row-1 && l != col-1) {//if out of bounds, cpu intensive fix when done

                                    if (arr[k][l].isBomb) {
                                        nearbyBombCount++;
                                    }
                                }
                        }

                    }
                    //done checking surrounding here
                    arr[i][j].nearbyBombCount = nearbyBombCount;
                    System.out.println(nearbyBombCount);
                }
            }
        }
        return arr;
    }

}


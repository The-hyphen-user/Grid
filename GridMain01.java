import java.util.Scanner;
import java.util.Random;

public class GridMain01 {//push push baby
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("begin");
        System.out.println("numbers not test corrected");

        System.out.println("rows?");
        int rows = in.nextInt();

        System.out.println("columns?");
        int columns = in.nextInt();

        int[][] Grid = new int[rows][columns];
        System.out.println();

        System.out.printf("number of bombs? (%d suggested)%n",rows*columns/4);
        int bombs = in.nextInt();




        //Print(Grid);
        Grid = PlantBombs(Grid, bombs);
        //Print(Grid);
        CalculateAdjacent(Grid);
        Print(Grid);






    }

    public static void Print(int[][] arr){
        for (int i=0;i<arr.length;i++) {
            for (int j=0;j<arr[0].length;j++){
                System.out.printf(" [%d] ",arr[i][j]);
            }
            System.out.printf("%n");
        }
    }

    public static int[][] PlantBombs(int[][] arr, int bombsToBePlanted){

        Random rand = new Random();
        int bombsPlanted = 0;
        int rows = arr.length;
        int columns = arr[0].length;

        while (bombsPlanted<bombsToBePlanted){
            int x = rand.nextInt(rows);
            int y = rand.nextInt(columns);
            if(arr[x][y] != -1){
                arr[x][y] = -1;
                bombsPlanted++;
            }

        }

        return arr;

    }

    public static int[][] CalculateAdjacent(int[][] arr){
        int row = arr.length-1;
        int col = arr[0].length-1;
        System.out.println(col);


            //arr[0][0];
            if (arr[0][0] != -1){
                int x = 0;
                if(arr[0][0+1] == -1){x++;}  //_+  6
                if(arr[0+1][0] == -1){x++;}  //+_  8
                if(arr[0+1][0+1] == -1){x++;}//++  9
                arr[0][0] = x;
            }


            if (arr[0][col] != -1){
                int j = arr[0].length;
                int x = 0;
                if(arr[i-1][j] == -1){x++;}  //-_  2
                if(arr[i-1][j+1] == -1){x++;}//-+  3
                if(arr[i][j+1] == -1){x++;}  //_+  6
                arr[0][j] = x;
            }



        for (int i=1;i<arr.length-1;i++) {
            for (int j=1;j<arr[0].length-1;j++) {//check mid
                if (arr[i][j] != -1){
                    int x = 0;
                    /*
                     -
                    123
                 -  4_6  +
                    789
                     +
                    */

                    if(arr[i-1][j-1] == -1){x++;}//--  1
                    if(arr[i-1][j] == -1){x++;}  //-_  2
                    if(arr[i-1][j+1] == -1){x++;}//-+  3
                    if(arr[i][j-1] == -1){x++;}  //_-  4
                    if(arr[i][j+1] == -1){x++;}  //_+  6
                    if(arr[i+1][j-1] == -1){x++;}//+-  7
                    if(arr[i+1][j] == -1){x++;}  //+_  8
                    if(arr[i+1][j+1] == -1){x++;}//++  9

                    arr[i][j] = x;

                }








            }

        }

        return arr;

    }

}


import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Button extends JButton implements MouseListener{
    boolean isBomb;
    boolean hasBeenPressed;
    int nearbyBombCount;
    int row;
    int col;



    Button(){
        this.isBomb = false;
        this.hasBeenPressed = false;
        this.addMouseListener(this);
        setSize(100, 100);
    }

    Button(String s){

    }

    Button(boolean bomb, int surrounding, int newRow, int newCol){
        row = newRow;
        col = newCol;
        isBomb = bomb;
        nearbyBombCount = surrounding;
        this.addMouseListener(this);
        setSize(100, 100);
    }

    public void becomeBomb(){
        this.isBomb = true;
    }
    public void countBombs(){//not going to be used

    }

    public void printNearbyBombs(){//prints to console
        System.out.println(this.nearbyBombCount);
    }

    public void printIsBomb(){
        System.out.println(this.isBomb);
    }




    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        //System.out.println("pressed");



    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {


        if (e.getModifiers() == MouseEvent.BUTTON3_MASK) {
            if(getText().equals("F")){
                setText("");
            } else if (getText().equals("")){
                setText("F");
            }
            System.out.println("You right clicked on the button");
        } else if(getText().equals("F")) {
            //do nothing
        } else{


            if (isBomb) {
                System.out.println("BOOM!!!");
                setText("B");

            } else {
                if (!getText().equals("0") && nearbyBombCount == 0) {
                    //check u/d/r/l for other hidden 0's
                    //checkForZeros();
                    System.out.println("0-first time");
                    setText("0");
                    GridMain01.checkForZeros(row, col);


                } else if (getText().equals(null)) {//&& nearbyBombCount == 0
                    System.out.println("words");
                } else {
                    System.out.println(Integer.toString(nearbyBombCount));
                    setText(Integer.toString(nearbyBombCount));
                }
            }


        }
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}

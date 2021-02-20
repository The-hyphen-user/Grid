import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Button extends JButton implements MouseListener{
    boolean isBomb;
    boolean hasBeenPressed;
    int nearbyBombCount;



    Button(){
        this.isBomb = false;
        this.hasBeenPressed = false;
    }

    Button(String s){

    }

    Button(boolean bomb, int surrounding){
        this.isBomb = bomb;
        this.nearbyBombCount = surrounding;
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
        System.out.println("pressed");

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}

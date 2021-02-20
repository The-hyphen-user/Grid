import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Board extends JFrame{




    Board(int width, int height,String title){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(width,height);
        this.setVisible(true);
        this.setTitle(title);
    }



    public void addButton(int x, int y, Button Current){
        Current.setBounds(x, y, 50, 50);
        this.add(Current);

    }







}

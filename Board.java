import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Board extends JFrame{




    Board(int newWidth, int newHeight,String newTitle){
        setTitle(newTitle);
        setSize(newWidth,newHeight);
        //setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }



    public void addButton(int x, int y, Button Current){
        Current.setBounds(x, y, 50, 50);
        this.add(Current);

    }




}

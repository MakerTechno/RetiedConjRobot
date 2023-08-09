package non.maker.controls.general.frame;

import non.maker.controls.general.interfaces.IMovementSupplier;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MovableFrame extends JFrame {
    private IMovementSupplier supplier;
    public MovableFrame(){
        supplier = new IMovementSupplier() {
            @Override
            public int getX() {
                return MovableFrame.this.getX();
            }

            @Override
            public int getY() {
                return 0;
            }

            @Override
            public boolean isDone() {
                return false;
            }

            @Override
            public void setDone(boolean b) {

            }
        };
        generalSetup(this);
        extraSetup(this);
    }

    public void generalSetup(JFrame frame){
        frame.setUndecorated(true);
        frame.setBackground(new Color(0,0,0,0));
        frame.setSize(19,19);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(null);
    }

    public void extraSetup(JFrame frame){
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.BUTTON3_DOWN_MASK){
                    dispose();
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }


}

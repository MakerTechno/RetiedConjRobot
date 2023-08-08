package non.maker.controls.general.frame;

import javax.swing.*;

public class ControlFrame extends JFrame {
    public ControlFrame(){
        generalSetup(this);
        extraSetup(this);
        setVisible(true);
    }

    public void generalSetup(JFrame frame){
        frame.setUndecorated(true);
        frame.setSize(1000,600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void extraSetup(JFrame frame){
        JPanel panelLeft = new JPanel();
        setupClickControlPane(panelLeft);
        frame.add(panelLeft);
    }

    public void setupClickControlPane(JPanel panel){
        panel.setBounds(0,0,370,600);

    }
}

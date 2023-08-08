package non.maker.controls.general.frame;

import non.maker.controls.general.references.ImgReference;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class CoverPane extends JFrame{
    private final JLabel label;
    int coverCount = 0;
    public boolean doneWait = false;
    private final JLabel textSuccess = new JLabel();
    private static final ImageIcon[] i = new ImageIcon[]{
            ImgReference.F_1,
            ImgReference.F_2,
            ImgReference.F_3,
            ImgReference.F_4,
            ImgReference.F_5,
            ImgReference.F_6
    };

    public CoverPane(){
        label = new JLabel();
        generalSetup(this);
        extraSetup(this);
        setVisible(true);
    }

    public void generalSetup(JFrame frame){
        frame.setUndecorated(true);
        frame.setBackground(new Color(0,0,0,0));
        frame.setSize(700,400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(null);
    }

    public void extraSetup(JFrame frame){
        labelSetup(label, frame);
        appIconSetup(new JLabel(), label);
        textBoardSetup(new JLabel(), new JLabel(), label);
        taskSetup(i);
        barTaskSetup();
    }

    public void labelSetup(JLabel label, JFrame holder){
        label.setLocation(0,0);
        label.setSize(holder.getSize());
        holder.add(label);
    }

    public void appIconSetup(JLabel label, JComponent holder){
        label.setIcon(ImgReference.ICON);
        label.setSize(80,80);
        label.setLocation((holder.getWidth()-label.getWidth())/2+3, (holder.getHeight()-label.getHeight())/2-100);
        holder.add(label);
    }

    public void textBoardSetup(JLabel label1,JLabel label2, JComponent holder){
        label1.setText("Maker(R) ToolBox");
        label1.setFont(new Font("等线", Font.BOLD, 20));
        label1.setForeground(Color.WHITE);
        label1.setSize(180, 30);
        label1.setLocation((holder.getWidth()-label1.getWidth())/2+8, (holder.getHeight()-label1.getHeight())/2-30);
        holder.add(label1);

        label2.setText("Powerful tools make things easier than ever before");
        label2.setFont(new Font("等线", Font.ITALIC, 16));
        label2.setForeground(Color.WHITE);
        label2.setSize(380, 30);
        label2.setLocation((holder.getWidth()-label2.getWidth())/2+8, (holder.getHeight()-label2.getHeight())/2+5);
        holder.add(label2);

        textSuccess.setFont(new Font("等线", Font.BOLD, 20));
        textSuccess.setForeground(Color.GREEN);
        textSuccess.setSize(100, 30);
        textSuccess.setLocation((holder.getWidth()-textSuccess.getWidth())/2+8, holder.getHeight()/4*3-30);
        holder.add(textSuccess);
    }


    public void taskSetup(ImageIcon[] imageIcons){
        new Timer().schedule(new TimerTask() {
            private final ImageIcon[] imageIconsC = imageIcons;
            int count = 0;
            int extraCount = 0;
            boolean rollBack = false;
            boolean finaL = false;
            @Override
            public void run() {
                label.setIcon(imageIconsC[count]);
                repaint();

                if (count == 0) rollBack = false;
                else if (count == imageIconsC.length-1) rollBack = true;

                if (extraCount == 60) {
                    if (rollBack) count--;
                    else count++;
                    extraCount = 0;
                } else extraCount++;

                if (!finaL && doneWait){
                    finaL = true;
                    textSuccess.setText("Success");
                    new Thread(()->{
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        setVisible(false);
                        dispose();//Release this frame
                    }).start();
                }
            }
        },0,5);
    }

    public void barTaskSetup(){
        new Timer().schedule(new TimerTask() {
            private boolean constLess = false;
            private boolean barEnd = false;
            private int countNumLess = 0;
            private int countNubPass = 0;
            @Override
            public void run() {
                if (coverCount>=getWidth()/4*2-15 && !barEnd){
                    if (constLess && countNubPass == 0){
                        coverCount++;
                        countNumLess++;
                        countNubPass = countNumLess;
                    }else if (countNubPass == 0){
                        constLess = true;
                    } else {
                        countNubPass--;
                    }
                    if (coverCount >= getWidth()/4*2-1) {
                        doneWait = true;
                        barEnd = true;
                    }
                }else if (barEnd){
                    this.cancel();
                } else {
                    coverCount++;
                }
            }
        },3000, 20);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        int width = this.getWidth();
        int height = this.getHeight();
        g2.setColor(Color.WHITE);
        g2.drawLine(width/4, height/4*3,width/4*3, height/4*3);
        g2.drawLine(width/4-1, height/4*3+1, width/4-1, height/4*3+4);
        g2.drawLine(width/4*3+1, height/4*3+1, width/4*3+1, height/4*3+4);
        g2.drawLine(width/4, height/4*3+5,width/4*3, height/4*3+5);

        g2.drawLine(width/4+1, height/4*3+2,width/4+coverCount, height/4*3+2);
        g2.drawLine(width/4+1, height/4*3+3,width/4+coverCount, height/4*3+3);
    }
}

package non.maker.controls.general;

import non.maker.controls.general.frame.ControlFrame;
import non.maker.controls.general.frame.CoverPane;
import non.maker.robot.macro.click.MainController;
import non.maker.robot.macro.click.SourceCollector;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class Launcher {
    static boolean done;
    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->{
            CoverPane coverPane = new CoverPane();
            new Timer().schedule(new TimerTask() {
                int count;
                @Override
                public void run() {
                    if (coverPane.doneWait){
                        done = true;
                    }
                    if (done) count++;
                    if (count==300){
                        runGUI();
                        cancel();
                    }
                }
            },0 ,10);

        });
    }

    private static void runGUI(){
        new ControlFrame();
    }
}

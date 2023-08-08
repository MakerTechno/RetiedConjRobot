package non.maker.robot.macro.click;

import non.maker.controls.general.interfaces.IMovementSupplier;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.Timer;
import java.util.TimerTask;

public class MainController{
    public final Robot robot;
    public static final long MOUSE_CLICK = InputEvent.MOUSE_EVENT_MASK;
    public MainController(SourceCollector collector) throws AWTException {
        robot = new Robot();

    }

    public void click(){
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
    }

    public void straightSurfaceMoveMouse(IMovementSupplier start, IMovementSupplier end){
        new Timer().schedule(new TimerTask() {
            int xSv = start.getX();
            int ySv = start.getY();
            final int xF = end.getX();
            final int yF = end.getY();
            boolean isMinusX = start.getX()-end.getX()>=0;
            boolean isMinusY = start.getY()-end.getY()>=0;
            @Override
            public void run() {
                if (xSv != xF) {
                    if (isMinusX) {
                        xSv--;
                    } else {
                        xSv++;
                    }
                    robot.mouseMove(xSv, ySv);
                }
                else if (ySv != yF){
                    if (isMinusY) {
                        ySv--;
                    } else {
                        ySv++;
                    }
                    robot.mouseMove(xSv, ySv);
                }
            }
        },0,10);
    }
}

package non.maker.robot.macro.click;

import non.maker.controls.general.interfaces.IMovementSupplier;

import java.util.ArrayList;
import java.util.List;

public class SourceCollector{
    public final List<IMovementSupplier> MOVEMENT_LIST;

    public SourceCollector(){
        MOVEMENT_LIST = new ArrayList<>();
    }

    public void addNewMovementSource(IMovementSupplier supplier){
        MOVEMENT_LIST.add(supplier);
    }

    public void removeUsedTargetCheck(List<IMovementSupplier> list){
        int count = 0;
        for (IMovementSupplier supplier : list){
            if (supplier.isDone()){
                list.remove(count);
            }
            count++;
        }
    }

}

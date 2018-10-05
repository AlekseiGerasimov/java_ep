package composite;

import objects.Unit;

import java.util.ArrayList;
import java.util.List;

public class Composite {
    private List<Unit> unitList;
    private int count;
    public Composite(){
        unitList = new ArrayList<>();
    }
    public void addUnit(Unit unit){
       unitList.add(unit);
    }

    public void removeUnit(Unit unit){
        unitList.remove(unit);
    }

    public void actionUnit(Unit unit, String... commands){
        for(String command : commands){
            count++;
            unit.action(command);
        }
    }

    public int countActions(){
        return count;
    }
}

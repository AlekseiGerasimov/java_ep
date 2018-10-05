package composite;

import gameobjects.Unit;

import java.util.ArrayList;
import java.util.List;

public class CompositeUnit {
    private List<Unit> unitList;
    public CompositeUnit(){
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
            unit.action(command);
        }
    }
}

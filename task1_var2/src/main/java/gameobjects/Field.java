package gameobjects;

import gamesteps.BaseStep;
import gamesteps.HorseStep;
import gamesteps.SimpleStep;
import gamesteps.Step;
import lombok.Getter;
import lombok.Setter;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class Field {
    private Map<Unit,Position> unitList = new HashMap<>();
    private EnumMap<Step, BaseStep> steps;
    private int x;
    private int y;

    public Field(){
        x = 5;
        y = 5;
        steps = fillBaseSteps();
    }

    public Field(int x,int y){
        this.x = x;
        this.y = y;
        steps = fillBaseSteps();
    }

    private EnumMap<Step, BaseStep> fillBaseSteps(){
        EnumMap<Step, BaseStep> step = new EnumMap<>(Step.class);
        step.put(Step.SIMPLESTEP, new SimpleStep());
        step.put(Step.HORSESTEP, new HorseStep());
        return step;
    }

    public boolean changeUnitPosition(Position to){
        if(to.getX()>this.x || to.getY()>this.y || to.getX() < 0 || to.getY() < 0){
            System.out.println("Ошибка, вы вышли за пределы поля");
            return false;
        }
        if(unitList.entrySet().stream().filter(a->a.getValue().
                getX() == to.getX() && a.getValue().getY() == to.getY()).count()>=1){
            System.out.println("Данное поле уже занято, выберите другой тип перемещения");
            return false;
        }
        return true;
    }

    public void addUnit(Unit unit){ unitList.put(unit,new Position()); }

    public void removeUnit(Unit unit){
        unitList.remove(unit);
    }

    public void doSimpleStep(Unit unit) { steps.get(Step.SIMPLESTEP).doStep(this, unit); }

    public void doHorseStep(Unit unit){ steps.get(Step.HORSESTEP).doStep(this,unit); }
}

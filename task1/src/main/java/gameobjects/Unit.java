package gameobjects;

import commands.BaseCommand;
import commands.HorseStepCommand;
import commands.SimpleStepCommand;
import commands.TurnCommand;
import gamesteps.BaseStep;
import gamesteps.HorseStep;
import gamesteps.SimpleStep;
import gamesteps.Step;
import orientation.Orientation;
import baseobjects.Position;
import orientation.*;

import java.util.HashMap;
import java.util.Map;

public abstract class Unit implements Action {
    protected Position position;
    protected Orientation orientation;
    protected Map<Step,BaseStep> stepMap;
    protected Map<Orientation, BaseOrientation> orientationMap;
    protected Map<String, BaseCommand> commandsMap;

    public Unit(){
        position = new Position();
        orientation = Orientation.NORTH;
        fillFields();
    }

    protected void fillFields(){
        fillOrientationMap();
        fillStepMap();
        fillCommandsMap();
    }

    protected void fillStepMap(){
        stepMap = new HashMap<>();
        stepMap.put(Step.SimpleStep,new SimpleStep());
        stepMap.put(Step.HorseStep,new HorseStep());
    }

    protected void fillOrientationMap(){
        orientationMap = new HashMap<>();
        orientationMap.put(Orientation.NORTH,new NorthOrientation());
        orientationMap.put(Orientation.EAST,new EastOrientation());
        orientationMap.put(Orientation.SOUTH,new SouthOrientation());
        orientationMap.put(Orientation.WEST,new WestOrientation());
    }

    protected void fillCommandsMap(){
        commandsMap = new HashMap<>();
        commandsMap.put("F",new SimpleStepCommand());
        commandsMap.put("H",new HorseStepCommand());
        commandsMap.put("T",new TurnCommand());
    }

    public void turnClockwise() {
        orientationMap.get(orientation).changeOrientation(this);
    }

    public void move(){ orientationMap.get(orientation).move(this); }

    public void doStep(Step step){
        stepMap.get(step).doStep(this);
    }

    @Override
    public void action(String command) {
        commandsMap.get(command).doCommand(this);
    }

    public Orientation getOrientation(){
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return position.getX() + " " + position.getY();
    }
}



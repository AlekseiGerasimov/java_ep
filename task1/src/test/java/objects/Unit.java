package objects;

import baseobjects.Field;
import baseobjects.Orientation;
import baseobjects.Position;
import interfaces.Action;
import orientation.*;

import java.util.HashMap;
import java.util.Map;

public abstract class Unit implements Action {
    protected Position position;
    protected Orientation orientation;
    private Map<Orientation, BaseOrientation> orientationMap;
    public Unit(){
        position = new Position(0,0);
        orientation = Orientation.NORTH;
        fillMap();
    }

    /* ---------------------------------------------------------------------------------------- */

    private void fillMap(){
        orientationMap = new HashMap<>(4);
        orientationMap.put(Orientation.NORTH,new NorthOrientation());
        orientationMap.put(Orientation.EAST,new EastOrientation());
        orientationMap.put(Orientation.SOUTH,new SouthOrientation());
        orientationMap.put(Orientation.WEST,new WestOrientation());
    }

    /* ---------------------------------------------------------------------------------------- */

    public void turnClockwise() {
        orientationMap.get(orientation).changeOrientation(this);
    }


    public void move(){
        orientationMap.get(orientation).move(this);
    }

    /* ---------------------------------------------------------------------------------------- */

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

    /* ---------------------------------------------------------------------------------------- */

    public void action(String command) {
        switch(command){
            case "F" :
                Field.setFillCell(this);
                break;
            case "T" : turnClockwise(); break;
            case "H" : Field.horseStep(this);
            default:
                System.out.println("Ошибка");
        }
    }

    /* ---------------------------------------------------------------------------------------- */

    @Override
    public String toString() {
        return position.getX() + " " + position.getY();
    }
}



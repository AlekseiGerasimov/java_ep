package gameobjects;

import java.util.ArrayList;
import java.util.List;

public class Field {
    private List<Unit> unitList = new ArrayList<>();
    private static boolean field[][];
    private static int x;
    private static int y;

    static {
        x = 5;
        y = 5;
        field = new boolean[x][y];
    }
    public Field(){ }

    public Field(int x,int y){ field = new boolean[x][y]; Field.x = x; Field.y = y;}

    public static int getX() {
        return x;
    }

    public static int getY() {
        return y;
    }

    public static boolean[][] getField(){
        return field;
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

package gameobjects;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Field {
    private List<Unit> unitList = new ArrayList<>();
    private static boolean field[][];
    private static int x;
    private static int y;

    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(new File("src/main/resources/application.properties")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        x = Integer.parseInt(properties.getProperty("X"));
        y = Integer.parseInt(properties.getProperty("Y"));
        field = new boolean[x][y];
    }

    public Field(){ }

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

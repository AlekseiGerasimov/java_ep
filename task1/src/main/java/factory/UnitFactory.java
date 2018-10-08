package factory;

import gameobjects.UnitName;
import gameobjects.Soldier;
import gameobjects.Tank;
import gameobjects.Tractor;
import gameobjects.Unit;


public class UnitFactory {
    public static Unit createUnit(UnitName unitName){
        Unit unit = null;
        switch (unitName){
            case TANK: unit = new Tank(); break;
            case TRACTOR: unit = new Tractor(); break;
            case SOLDIER: unit = new Soldier(); break;
            default:
                System.out.println("Ошибка");
        }
        return unit;
    }
}

package factory;

import baseobjects.UnitName;
import objects.Soldier;
import objects.Tank;
import objects.Tractor;
import objects.Unit;


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

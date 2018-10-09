import gameobjects.Field;
import gameobjects.UnitName;
import factory.UnitFactory;
import gameobjects.Unit;

public class Main {
    public static void main(String []args){
        Field field = new Field(10,10);
        Unit unit1 = UnitFactory.createUnit(UnitName.SOLDIER);
        Unit unit = UnitFactory.createUnit(UnitName.TANK);
        Unit unit2 = UnitFactory.createUnit(UnitName.TRACTOR);

        field.addUnit(unit);
        field.addUnit(unit1);
        field.addUnit(unit2);

        field.actionUnit(unit,"H","O","H");
        field.actionUnit(unit1,"F","F","F","T","F","S");
        field.actionUnit(unit2,"H","H");

        System.out.println(unit);
        System.out.println(unit1);
        System.out.println(unit2);

    }
}

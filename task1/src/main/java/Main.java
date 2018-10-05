import baseobjects.UnitName;
import composite.Composite;
import factory.UnitFactory;
import objects.Tank;
import objects.Tractor;
import objects.Unit;

public class Main {
    public static void main(String []args){
        Composite composite = new Composite();
        Unit unit1 = UnitFactory.createUnit(UnitName.SOLDIER);
        Unit unit = UnitFactory.createUnit(UnitName.TANK);
        Unit unit2 = UnitFactory.createUnit(UnitName.TRACTOR);

        composite.addUnit(unit);
        composite.addUnit(unit1);
        composite.addUnit(unit2);

        composite.actionUnit(unit,"F","F","T","O");
        composite.actionUnit(unit1,"H");
        composite.actionUnit(unit2,"H");


        System.out.println(unit);
        System.out.println(unit1);
        System.out.println(unit2);

    }
}

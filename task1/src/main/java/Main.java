import enums.UnitName;
import composite.CompositeUnit;
import factory.UnitFactory;
import gameobjects.Unit;

public class Main {
    public static void main(String []args){
        CompositeUnit compositeUnit = new CompositeUnit();
        Unit unit1 = UnitFactory.createUnit(UnitName.SOLDIER);
        Unit unit = UnitFactory.createUnit(UnitName.TANK);
        Unit unit2 = UnitFactory.createUnit(UnitName.TRACTOR);

        compositeUnit.addUnit(unit);
        compositeUnit.addUnit(unit1);
        compositeUnit.addUnit(unit2);

        compositeUnit.actionUnit(unit,"F","F","T","O");
        compositeUnit.actionUnit(unit1,"H");
        compositeUnit.actionUnit(unit2,"H");


        System.out.println(unit);
        System.out.println(unit1);
        System.out.println(unit2);

    }
}

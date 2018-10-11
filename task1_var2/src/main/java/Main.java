import factory.SoldierFactory;
import factory.TankFactory;
import factory.TractorFactory;
import gameobjects.Field;
import gameobjects.Unit;

public class Main {
    public static void main(String []args){
        Field field = new Field(5,5);
        Unit unit1 = new SoldierFactory().createUnit();
        Unit unit = new TankFactory().createUnit();
        Unit unit2 = new TractorFactory().createUnit();

        field.addUnit(unit);
        field.addUnit(unit1);
        field.addUnit(unit2);

        unit.action("O","T");
        field.doSimpleStep(unit);
        field.doSimpleStep(unit);
        field.doSimpleStep(unit);
        unit.action("T","T","T");
        field.doSimpleStep(unit);

 //       field.doSimpleStep(unit1);
//        field.doSimpleStep(unit2);


        System.out.println(field.getUnitList().get(unit));
        System.out.println(field.getUnitList().get(unit1));
        System.out.println(field.getUnitList().get(unit2));

    }
}

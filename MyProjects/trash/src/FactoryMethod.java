/* Допустим мы занимаемся доставкой товаров по всему миру. Мы можем доставлять товары с помощью машин, кораблей или самолетов
   Реализуем это.
 */


public class FactoryMethod {
    public static void main(String []args) {
        Delivery rus = new DeliveryToRussia();
        Delivery arm = new DeliveryToArmenia();
        Vehicle v1 = rus.getVehicle(Type.CAR);
        Vehicle v2 = rus.getVehicle(Type.SHIP);
        Vehicle v3 = rus.getVehicle(Type.AIRCRAFT);
        Vehicle v4 = arm.getVehicle(Type.CAR);
        Vehicle v5 = arm.getVehicle(Type.AIRCRAFT);
    }
}

/********************************************************************************************************************/

enum Type{
    CAR("Машина"),SHIP("Корабль"),AIRCRAFT("Самолет");
    private String name;
    Type(String name){
        this.name = name;
    }
}

abstract class Vehicle{
    protected int time;
    protected double cost;
    protected Type type;
    protected String name;
    public Vehicle(){
        time = 0;
        cost = 0;
        name = "Объект не создан";
    }
    public void info(){
        System.out.println("Средство: " + type.name() + ". Наименование средства: "+ name + ". Стоимость: " +cost+". Примерно время доставки: " + time);
    }
}

class Car extends Vehicle{
    public Car(){
        super();
        type = Type.CAR;
    }
    public Car(String name){
        this.time = 10;
        this.cost = 1000;
        this.name = name;
        this.type = Type.CAR;
    }
}

class Ship extends Vehicle{
    public Ship(){
        super();
        type = Type.SHIP;
    }
    public Ship(String name){
        this.time = 5;
        this.cost = 3000;
        this.name = name;
        this.type = Type.SHIP;
    }
}

class Aircraft extends Vehicle{
    public Aircraft(){
        super();
        type = Type.SHIP;
    }
    public Aircraft(String name){
        this.time = 2;
        this.cost = 10000;
        this.name = name;
        this.type = Type.AIRCRAFT;
    }
}

/********************************************************************************************************************/

abstract class Delivery{
    protected abstract Vehicle createVehicle(Type type); /// Фабричный метод
    public Vehicle getVehicle(Type type){
        Vehicle vehicle = createVehicle(type);
        if(vehicle != null)
            vehicle.info();
        return vehicle;
    }
}

class DeliveryToRussia extends Delivery{
    public Vehicle createVehicle(Type type){
        Vehicle vehicle;
        switch (type){
            case CAR:
                vehicle = new Car("Машина нашей фирмы в Россию");
                break;
            case SHIP:
                vehicle = new Ship("Корабль нашей фирмы в Россию");
                break;
            case AIRCRAFT:
                vehicle = new Aircraft("Самолет нашей фирмы в Россию");
                break;
            default:
                vehicle = null;
        }
        return vehicle;
    }
}

class DeliveryToArmenia extends Delivery{
    public Vehicle createVehicle(Type type){
        Vehicle vehicle;
        switch (type){
            case CAR:
                vehicle = new Car("Машина нашей фирмы в Армению");
                break;
            case SHIP:
                System.out.println("Доставка в Армению на корабле нет");
                vehicle = null;
                break;
            case AIRCRAFT:
                vehicle = new Aircraft("Самолет нашей фирмы в Армению");
                break;
            default:
                vehicle = null;
        }
        return vehicle;
    }
}

/********************************************************************************************************************/
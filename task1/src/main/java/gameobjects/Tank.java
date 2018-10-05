package gameobjects;

public class Tank extends Unit {
    public Tank(){
        super();
    }
    public void fire(){
        System.out.println("Выстрелил танк");
    }

    @Override
    public void action(String command) {
        switch(command){
            case "F" :
                simpleStep.doStep(this);
                break;
            case "T" :
                turnClockwise();
                break;
            case "H" :
                horseStep.doStep(this);
                break;
            case "O" :
                fire();
                break;
            default:
                System.out.println("Ошибка");
        }
    }
}

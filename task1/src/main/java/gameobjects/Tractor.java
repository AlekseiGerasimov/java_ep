package gameobjects;

public class Tractor extends Unit{
    public Tractor(){
        super();
    }
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
            default:
                System.out.println("Ошибка");
        }
    }
}

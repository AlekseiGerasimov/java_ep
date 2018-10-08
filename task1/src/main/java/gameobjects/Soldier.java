package gameobjects;

import commands.ShootCommand;

public class Soldier extends Unit {
    private int numberRounds;
    public Soldier(){
        super();
        numberRounds = 30;
    }
    public void shoot(){
        if(numberRounds == 0){
            System.out.println("У вас кончились патроны");
            return;
        }
        numberRounds--;
        System.out.println("Выстрелил солдат");
    }

    @Override
    protected void fillCommandsMap() {
        super.fillCommandsMap();
        commandsMap.put("S",new ShootCommand());
    }
}

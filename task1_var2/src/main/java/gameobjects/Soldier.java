package gameobjects;

import commands.BaseCommand;
import commands.ShootCommand;

import java.util.Map;

public class Soldier extends Unit {
    private int numberRounds;
    public Soldier(){
        super();
        numberRounds = 30;
        commandsMap = fillCommandsMap();
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
    protected Map<String, BaseCommand> fillCommandsMap() {
        Map<String, BaseCommand> commandMap = super.fillCommandsMap();
        commandMap.put("S",new ShootCommand());
        return commandMap;
    }

}

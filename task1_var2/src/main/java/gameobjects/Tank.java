package gameobjects;

import commands.BaseCommand;
import commands.FireCommand;

import java.util.Map;

public class Tank extends Unit {
    public Tank(){
        super();
        commandsMap = fillCommandsMap();
    }
    public void fire(){
        System.out.println("Выстрелил танк");
    }

    @Override
    protected Map<String, BaseCommand> fillCommandsMap() {
        Map<String, BaseCommand> commandMap = super.fillCommandsMap();
        commandMap.put("O",new FireCommand());
        return commandMap;
    }
}

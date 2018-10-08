package gameobjects;

import commands.FireCommand;

public class Tank extends Unit {
    public Tank(){
        super();
    }
    public void fire(){
        System.out.println("Выстрелил танк");
    }

    @Override
    protected void fillCommandsMap() {
        super.fillCommandsMap();
        commandsMap.put("O",new FireCommand());
    }
}

package gameobjects;

import commands.BaseCommand;
import commands.TurnCommand;
import lombok.Getter;
import lombok.Setter;
import orientation.*;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public abstract class Unit {
    protected BaseOrientation orientation;
    protected Map<String, BaseCommand> commandsMap;

    public Unit(){
        this.orientation = new NorthOrientation();
        this.commandsMap = fillCommandsMap();
    }

    protected Map<String, BaseCommand> fillCommandsMap(){
        Map<String, BaseCommand> command = new HashMap<>();
        command.put("T",new TurnCommand());
        return command;
    }
    public void turnClockwise() { orientation.changeOrientation(this); }
    public void action(String ...commands) {
        for(String command : commands)
            commandsMap.get(command).doCommand(this);
    }

}



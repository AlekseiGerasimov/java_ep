package commands;

import gameobjects.Unit;

//TODO Во всех классах комманд обработать исключение, при передаче в метод doCommand параметра некорректного типа
public interface BaseCommand {
    void doCommand(Unit unit);
}

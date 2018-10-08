package commands;

import gameobjects.Unit;
import gamesteps.Step;

public class SimpleStepCommand implements BaseCommand {
    @Override
    public void doCommand(Unit unit) {
        unit.doStep(Step.SimpleStep);
    }
}

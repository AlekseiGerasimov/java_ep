package helpers;

import menu.DataMenu;
import operations.BaseOperation;

import java.util.List;
import java.util.Map;
import java.util.TimerTask;

public class TaskRunner extends TimerTask {
    private Map<String,BaseOperation> mapOperation = new Operation().getMapOperation();
    private List<String> tmp = DataMenu.getMenu();

    public TaskRunner(){ }

    @Override
    public void run() {
        for(String str : tmp){
            mapOperation.get(str).doOperation();
        }
    }

}

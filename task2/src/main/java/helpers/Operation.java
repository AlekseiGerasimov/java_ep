package helpers;

import lombok.Getter;
import lombok.Setter;
import objects.BaseObject;
import objects.CPU;
import objects.HDD;
import objects.RAM;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class Operation {
    protected Map<String, BaseObject> mapOperation;
    public Operation(){
        mapOperation = fillMapOperation();
    }

    private Map<String,BaseObject> fillMapOperation(){
        Map<String,BaseObject> operations = new HashMap<>();
        operations.put("1",new CPU());
        operations.put("2",new HDD());
        operations.put("3",new RAM());
        return operations;
    }
    public void addOperation(String numberOperation,BaseObject object) {
        mapOperation.put(numberOperation, object);
    }

    public void removeOperation(String number){
        mapOperation.remove(number);
    }

}

package helpers;

import operations.BaseOperation;
import operations.CPUOperation;
import operations.HDDOperation;
import operations.RAMOperation;

import java.util.HashMap;
import java.util.Map;

public class Operation {
    protected Map<String,BaseOperation> mapOperation;
    public Operation(){
        mapOperation = new HashMap<>();
        mapOperation.put("1",new CPUOperation());
        mapOperation.put("2",new HDDOperation());
        mapOperation.put("3",new RAMOperation());
    }

    public void addOperation(String numberOperation,BaseOperation operation){
        mapOperation.put(numberOperation,operation);
    }

    public void removeOperation(String number){
        mapOperation.remove(number);
    }

    public Map<String, BaseOperation> getMapOperation() {
        return mapOperation;
    }

    public void setMapOperation(Map<String, BaseOperation> mapOperation) {
        this.mapOperation = mapOperation;
    }
}

package objects;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public abstract class BaseObject {
    protected List<Double> list = new ArrayList<>();
    public double avgValue(){
        return list.stream().mapToDouble(a->a).average().getAsDouble();
    }
    public double maxValue() {
        return list.stream().max(Comparator.naturalOrder()).get();
    }
    public double count(){
        return list.stream().count();
    }
}

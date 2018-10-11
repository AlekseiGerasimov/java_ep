package objects;

import com.sun.management.OperatingSystemMXBean;

import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public abstract class BaseObject {
    protected List<Double> list = new ArrayList<>();
    protected OperatingSystemMXBean systemMBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);

    public abstract void writeOnFile();
    public abstract void readFile();

    public double avgValue(){
        readFile();
        return list.stream().mapToDouble(a->a).average().getAsDouble();
    }
    public double maxValue() {
        readFile();
        return list.stream().max(Comparator.naturalOrder()).get();
    }
    public double count(){
        readFile();
        return list.stream().count();
    }
}

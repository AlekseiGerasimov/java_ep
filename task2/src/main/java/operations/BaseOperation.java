package operations;

import com.sun.management.OperatingSystemMXBean;

import java.lang.management.ManagementFactory;

public abstract class BaseOperation {
    protected OperatingSystemMXBean systemMBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);
    public abstract void doOperation();
}

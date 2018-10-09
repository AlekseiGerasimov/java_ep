package operations;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class CPUOperation extends BaseOperation {
    @Override
    public void doOperation() {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("files/CPU.txt",true)))
        {
            bw.write(String.valueOf(systemMBean.getProcessCpuLoad()) + "---" + new Date() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

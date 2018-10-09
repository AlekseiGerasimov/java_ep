package operations;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class RAMOperation extends BaseOperation {
    @Override
    public void doOperation() {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("files/RAM.txt",true)))
        {
            bw.write(String.valueOf(systemMBean.getCommittedVirtualMemorySize()) + "---" + new Date() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

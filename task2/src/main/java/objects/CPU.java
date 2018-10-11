package objects;

import java.io.*;
import java.util.Date;

public class CPU extends BaseObject {
    public CPU(){
    }

    @Override
    public void writeOnFile() {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("files/CPU.txt",true)))
        {
            bw.write(String.valueOf(systemMBean.getProcessCpuLoad()) + "---" + new Date() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void readFile() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("files/CPU.txt"));
            while(br.read()!=-1){
                String []str = br.readLine().split("---");
                list.add(Double.parseDouble(str[0]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

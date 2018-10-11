package objects;

import java.io.*;
import java.util.Date;

public class HDD extends BaseObject {
    public HDD(){
    }

    @Override
    public void writeOnFile() {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("files/HDD.txt",true)))
        {
            bw.write(String.valueOf(systemMBean.getFreePhysicalMemorySize()) + "---" + new Date() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void readFile() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("files/HDD.txt"));
            while(br.read()!=-1){
                String []str = br.readLine().split("---",2);
                list.add(Double.parseDouble(str[0]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

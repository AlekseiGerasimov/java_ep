package objects;

import java.io.*;
import java.util.Date;

public class RAM extends BaseObject {
    public RAM(){
    }

    @Override
    public void writeOnFile() {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("files/RAM.txt",true)))
        {
            bw.write(String.valueOf(systemMBean.getCommittedVirtualMemorySize()) + "---" + new Date() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void readFile() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("files/RAM.txt"));
            while(br.read()!=-1){
                String []str = br.readLine().split("---",2);
                list.add(Double.parseDouble(str[0]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

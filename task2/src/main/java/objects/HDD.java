package objects;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HDD extends BaseObject {
    public HDD(){
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

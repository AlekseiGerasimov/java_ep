package objects;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RAM extends BaseObject {
    public RAM(){
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

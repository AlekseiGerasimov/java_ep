package objects;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CPU extends BaseObject {
    public CPU(){
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

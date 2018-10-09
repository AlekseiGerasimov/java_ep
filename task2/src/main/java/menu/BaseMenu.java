package menu;

import objects.BaseObject;
import objects.CPU;
import objects.HDD;
import objects.RAM;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public abstract class BaseMenu {
    protected Map<String,BaseObject> mapObject;

    public BaseMenu(){
        fillMap();
    }

    private void fillMap(){
        mapObject = new HashMap<>();
        mapObject.put("1",new CPU());
        mapObject.put("2",new HDD());
        mapObject.put("3",new RAM());
    }

    public abstract void show();

    protected boolean checkInputValue(String inputValue,String left,String right){
        if(Pattern.compile("[" + left + "-" + right + "]").matcher(inputValue).matches())
            return true;
        System.out.println("Введите значения в диапозоне от " + left + " до " + right);
        return false;
    }

    protected void generatorMenu(String... menu){
        int number = 1;
        for(String menuItem : menu){
            System.out.println(number++ + ". " + menuItem);
        }
    }

    protected String selectMenu(){
        System.out.println("Выберите значение: ");
        return new Scanner(System.in).nextLine();
    }
}

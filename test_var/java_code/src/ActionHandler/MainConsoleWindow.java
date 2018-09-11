package ActionHandler;

import Common.FactoryHandler;
import Interfaces.ActionsForHandlers;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Класс реализует главное меню программы. Из данного меню происходит переход к необходимому пользователю действию.
 */
public class MainConsoleWindow implements ActionsForHandlers {
    private ActionsForHandlers handler;
    public MainConsoleWindow(){
    }

    public int listActions(){
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("1. Список проектов");
        System.out.println("2. Список пользователей");
        System.out.println("3. Список дефектов");
        System.out.println("4. Загрузка данных из файла в базу данных");
        System.out.println("5. Отчеты");
        System.out.println("6. Прикрепить пользователя к проекту");
        System.out.println("7. Выход");
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("Выберите дальнейшее действие. Для этого введите цифру, соответствующую пункту меню: ");
        Scanner scanner = new Scanner(System.in);
        String input_value;
        while(true){
            input_value = scanner.nextLine();
            if(Pattern.compile("[1-7]").matcher(input_value).matches()){
                break;
            }
            else{
                System.out.print("Введите корректное значение (от 1 до 7): ");
            }
        }
        return Integer.parseInt(input_value);
    }



    public void action(){
        handler = FactoryHandler.getHandler(listActions());
        handler.action();
    }
}

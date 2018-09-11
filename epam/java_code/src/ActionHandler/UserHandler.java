package ActionHandler;

import Interfaces.ActionsForHandlers;
import Objects.User;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Класс обрабатывает действия пользователя по работе с меню "Список пользователей
 */
public class UserHandler implements ActionsForHandlers {
    private User user;

    public UserHandler(){
        user = new User();
    }
    public void action(){
        int input_value;
        Scanner scanner = new Scanner(System.in);;
        do {
            input_value = listActions();
            switch (input_value){
                case 1 :
                    user.listUsers();
                    break;
                case 2 :
                    System.out.println("Введите имя нового пользователя");
                    user.addUser(scanner.nextLine());
                    break;
                case 3 :
                    System.out.println("Введите имя пользователя, которого необходимо удалить");
                    user.removeUser(scanner.nextLine());
                    break;
                case 4 : {
                    System.out.println("Введите текущее имя пользователя:");
                    String currentName = scanner.nextLine();
                    System.out.println("Введите новое имя пользователя:");
                    String newName = scanner.nextLine();
                    user.updateUser(currentName, newName);
                    break;
                }
                default: input_value = 5;
            }
        }while (input_value != 5);
        new MainConsoleWindow().action();
    }
    public int listActions(){
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("1. Все пользователи");
        System.out.println("2. Добавить пользователя");
        System.out.println("3. Удалить пользователя");
        System.out.println("4. Обновить информацию о пользователе");
        System.out.println("5. Выход");
        System.out.println("------------------------------------------------------------------------------------------");
        Scanner scanner = new Scanner(System.in);
        String input_value;
        while(true){
            input_value = scanner.nextLine();
            if(Pattern.compile("[1-5]").matcher(input_value).matches()){
                break;
            }
            else{
                System.out.print("Введите корректное значение (от 1 до 5): ");
            }
        }
        return Integer.parseInt(input_value);
    }
}

package ActionHandler;

import Objects.User;

import java.util.Scanner;
import java.util.regex.Pattern;

public class UserHandler {
    private User user;

    public UserHandler(){
        user = new User();
    }
    public void action(){
        int input_value;
        Scanner scanner;
        do {
            input_value = listProjectAction();
            switch (input_value){
                case 1 :
                    user.listUsers();
                    break;
                case 2 :
                    System.out.println("Введите имя нового пользователя");
                    scanner = new Scanner(System.in);
                    user.addUser(scanner.nextLine());
                    break;
                case 3 :
                    System.out.println("Введите имя пользователя, которого необходимо удалить");
                    scanner = new Scanner(System.in);
                    user.removeUser(scanner.nextLine());
                    break;
                case 4 :
                    System.out.println("Введите сначала старое имя пользователя, а затем его новое имя");
                    scanner = new Scanner(System.in);
                    user.updateUser(scanner.nextLine(),scanner.nextLine());
                    break;
                default: input_value = 5;
            }
        }while (input_value != 5);
        new MainConsoleWindow().action();
    }
    public int listProjectAction(){
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

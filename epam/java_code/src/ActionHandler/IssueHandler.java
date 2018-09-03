package ActionHandler;

import Objects.Issue;
import Objects.User;

import java.util.Scanner;
import java.util.regex.Pattern;

public class IssueHandler {
    private Issue issue;

    public IssueHandler(){
        issue = new Issue();
    }
    public void action(){
        int input_value;
        Scanner scanner;
        do {
            input_value = listProjectAction();
            switch (input_value){
                case 1 :
                    issue.listIssue();
                    break;
                case 2 :
                    System.out.println("Введите имя проекта, имя пользователя и описание дефекта");
                    scanner = new Scanner(System.in);
                    issue.addIssue(scanner.nextLine(),scanner.nextLine(),scanner.nextLine());
                    break;
                case 3 :
                    System.out.println("Введите номер дефекта, который необходимо удалить");
                    scanner = new Scanner(System.in);
                    issue.removeIssue(scanner.nextLine());
                    break;
                case 4 :
                    System.out.println("Введите номер дефекта для обновления, а затем его новое описание");
                    scanner = new Scanner(System.in);
                    issue.updateIssue(scanner.nextLine(),scanner.nextLine());
                    break;
                default: input_value = 5;
            }
        }while (input_value != 5);
        new MainConsoleWindow().action();
    }
    public int listProjectAction(){
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("1. Все дефекты");
        System.out.println("2. Добавить дефект");
        System.out.println("3. Удалить дефект");
        System.out.println("4. Обновить информацию о дефекте");
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

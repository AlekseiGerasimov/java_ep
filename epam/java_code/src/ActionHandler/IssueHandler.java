package ActionHandler;

import Interfaces.ActionsForHandlers;
import Objects.Issue;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Класс обрабатывает действия пользователя по работе с меню "Список дефектов"
 */
public class IssueHandler implements ActionsForHandlers {
    private Issue issue;


    public IssueHandler(){
        issue = new Issue();
    }
    /**
     * В зависимости от выбранного пункта в методе listProjectAction() данный метод вызывает метод объекта класса Issue
     * Работа метода будет продолжатсья до тех пор, пока пользователь не выберет пункт под номером 5.
     * В случае выбора пункта 5 происходит переход в главное меню программы (MainConsoleHandler)
     */
    public void action(){
        int input_value;
        Scanner scanner = new Scanner(System.in);
        do {
            input_value = listActions();
            switch (input_value){
                case 1 :
                    issue.listIssue();
                    break;
                case 2 : {
                    System.out.println("Введите название проекта");
                    String nameProject = scanner.nextLine();
                    System.out.println("Введите имя пользователя");
                    String nameUser = scanner.nextLine();
                    System.out.println("Введите описание дефекта");
                    String issueDescription = scanner.nextLine();
                    issue.addIssue(nameProject, nameUser, issueDescription);
                    break;
                }
                case 3 :
                    System.out.println("Введите номер дефекта, который необходимо удалить");
                    issue.removeIssue(scanner.nextLine());
                    break;
                case 4 : {
                    System.out.println("Введите номер дефекта для обновления");
                    String numberIssue = scanner.nextLine();
                    System.out.println("Введите новое описание дефекта");
                    String issueDescription = scanner.nextLine();
                    issue.updateIssue(numberIssue, issueDescription);
                    break;
                }
                default: input_value = 5;
            }
        }while (input_value != 5);
        new MainConsoleWindow().action();
    }

    /**
     * Метод обрабатывает выбор пользователя пункта меню.
     * В случае выбора некорректного значения в методе требуется повторить ввод
     * @return Номер выбранного пункта
     */
    public int listActions(){
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

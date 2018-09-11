package ActionHandler;

import Interfaces.ActionsForHandlers;
import Objects.Reports;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Класс обрабатывает действия пользователя по работе с меню "Отчеты"
 */
public class ReportHandler implements ActionsForHandlers {
    private Reports reports;

    public ReportHandler(){
        reports = new Reports();
    }
    public void action(){
        int input_value;
        Scanner scanner = new Scanner(System.in);;
        do {
            input_value = listActions();
            switch (input_value){
                case 1 : {
                    System.out.println("Введите имя пользователя");
                    String nameUser = scanner.nextLine();
                    System.out.println("Введите название проекта");
                    String nameProject = scanner.nextLine();
                    reports.createReportBySpecifiedUserBySpecifiedProject(nameUser, nameProject);
                    break;
                }
                case 2 : {
                    System.out.println("Введите название проекта");
                    String nameProject = scanner.nextLine();
                    reports.createReportByAllIssuesByProject(nameProject);
                    break;
                }

                default: input_value = 3;
            }
        }while (input_value != 3);
        new MainConsoleWindow().action();
    }
    public int listActions(){
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("1. Вывести все дефекты от конкретного пользователя по конкретному проекту");
        System.out.println("2. Вывести все дефекты по конкретному проекту");
        System.out.println("3. Выход");
        System.out.println("------------------------------------------------------------------------------------------");
        Scanner scanner = new Scanner(System.in);
        String input_value;
        while(true){
            input_value = scanner.nextLine();
            if(Pattern.compile("[1-3]").matcher(input_value).matches()){
                break;
            }
            else{
                System.out.print("Введите корректное значение (от 1 до 3): ");
            }
        }
        return Integer.parseInt(input_value);
    }
}

package ActionHandler;

import Objects.Issue;
import Objects.Reports;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ReportHandler {
    private Reports reports;

    public ReportHandler(){
        reports = new Reports();
    }
    public void action(){
        int input_value;
        Scanner scanner;
        do {
            input_value = listProjectAction();
            switch (input_value){
                case 1 :
                    System.out.println("Введите имя пользователя и проект по котормоу необходимо вывести дефекты");
                    scanner = new Scanner(System.in);
                    reports.createReportBySpecifiedUserBySpecifiedProject(scanner.nextLine(),scanner.nextLine());
                    break;
                default: input_value = 2;
            }
        }while (input_value != 2);
        new MainConsoleWindow().action();
    }
    public int listProjectAction(){
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("1. Вывести все дефекты от конкретного пользователя по конкретному проекту");
        System.out.println("2. Выход");
        System.out.println("------------------------------------------------------------------------------------------");
        Scanner scanner = new Scanner(System.in);
        String input_value;
        while(true){
            input_value = scanner.nextLine();
            if(Pattern.compile("[1-2]").matcher(input_value).matches()){
                break;
            }
            else{
                System.out.print("Введите корректное значение (от 1 до 2): ");
            }
        }
        return Integer.parseInt(input_value);
    }
}

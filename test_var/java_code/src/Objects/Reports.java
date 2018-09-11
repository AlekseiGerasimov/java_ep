package Objects;

import Common.CommonFunctions;
import Common.MyLogger;
import Interfaces.IReports;
import JDBC.ConnectionDB;

import java.sql.*;
import java.util.logging.Level;

public class Reports implements IReports{
    private Connection connection;

    public Reports(){
    }

    @Override
    public void createReportBySpecifiedUserBySpecifiedProject(String userName, String projectName) {
        if(!CommonFunctions.getListUsers().containsValue(userName)){
            MyLogger.log(Level.INFO,Issue.class.getName(),"addIssue(String nameProject,String nameUser,String descriptionIssue)",
                    "Пользователя " + userName + " не существует в системе");
            return;
        }
        if(!CommonFunctions.getListProjects().containsValue(projectName)){
            MyLogger.log(Level.INFO,Issue.class.getName(),"addIssue(String nameProject,String nameUser,String descriptionIssue)",
                    "Проекта " + projectName + " не существует в системе");
            return;
        }
        String query = "select issue_number,issue_description\n" +
                "from issues i inner join users u \n" +
                "on i.id_user = u.id_user\n" +
                "inner join project p\n" +
                "on i.id_project = p.id_project\n" +
                "where project_name = '" + projectName +
                "' and user_name = '" + userName +"'";
        try{
            connection = ConnectionDB.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet set = statement.executeQuery();
            System.out.printf("%-18s%-3s%-200s%n","Номер дефекта"," | ","Описание дефекта");
            System.out.println("---------------------------------------------");
            while(set.next()){
                System.out.printf("%-18s%-3s%-200s%n",set.getString("issue_number")," | ",set.getString("issue_description"));
            }
        }
        catch (SQLException ex){
            MyLogger.log(Level.WARNING,Reports.class.getName(),"createReportBySpecifiedUserBySpecifiedProject(String userName, String projectName)",
                    "При выполнении запроса: " + query + " " + "возникла ошибка. Проверьте корректность запроса или корректность базы данных для которой происходит подключение");
            System.exit(-1);
        }
    }

    @Override
    public void createReportByAllIssuesByProject(String projectName) {
        if(!CommonFunctions.getListProjects().containsValue(projectName)){
            MyLogger.log(Level.INFO,Issue.class.getName(),"addIssue(String nameProject,String nameUser,String descriptionIssue)",
                    "Проекта " + projectName + " не существует в системе");
            return;
        }
        String query = "select i.issue_number,i.issue_description from issues i inner join project p on i.id_project = p.id_project where p.project_name='"+projectName+"'";
        try{
            connection = ConnectionDB.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet set = statement.executeQuery();
            System.out.printf("%-18s%-3s%-200s%n","Номер дефекта"," | ","Описание дефекта");
            System.out.println("---------------------------------------------");
            while(set.next()){
                System.out.printf("%-18s%-3s%-200s%n",set.getString("issue_number")," | ",set.getString("issue_description"));
            }
        }
        catch (SQLException ex){
            MyLogger.log(Level.WARNING,Reports.class.getName(),"createReportByAllIssuesByProject(String projectName)",
                    "При выполнении запроса: " + query + " " + "возникла ошибка. Проверьте корректность запроса или корректность базы данных для которой происходит подключение");
            System.exit(-1);
        }
    }

}

package Interfaces;

public interface IReports {
    void createReportBySpecifiedUserBySpecifiedProject(String userName,String projectName);
    void createReportByAllIssuesByProject(String projectName);
}

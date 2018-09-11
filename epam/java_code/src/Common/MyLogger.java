package Common;


import java.io.IOException;
import java.util.logging.*;

/**
 * Класс для работа с логированием
 */
public class MyLogger {
    private static Logger logger = getLogger();
    private MyLogger() {}

    /**
     * Создания объекта логера
     * @return Возвращает логер
     */
    private static Logger getLogger(){
        logger = Logger.getLogger("MyLogger");
        logger.setLevel(Level.ALL);
        logger.setUseParentHandlers(false);
        try {
            Handler fileHandler = new FileHandler("logs.txt", true);
            Handler consoleHandler = new ConsoleHandler();
            fileHandler.setLevel(Level.WARNING);
            consoleHandler.setLevel(Level.INFO);
            logger.addHandler(fileHandler);
            logger.addHandler(consoleHandler);
        }
        catch (IOException ex){
            System.err.print("Проверьте путь до файла логов при создании filehandler, возможно путь некорректный");
        }
        return logger;
    }
     /**
     * Логирование данных
     */
    public static void log(Level level,String className,String methodName,String text){
        logger.logp(level,className,methodName,text);
        Handler[] h = logger.getHandlers();
        for(Handler j : h)
            j.flush();
    }
}

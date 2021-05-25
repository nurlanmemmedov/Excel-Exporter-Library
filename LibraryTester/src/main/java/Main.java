import exceptions.ClassNotExportable;
import exceptions.NoExportableDataFound;
import exceptions.NoExportableFieldsFound;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        List<Person> people = new ArrayList<>();
        people.add(new Person(1, "Nurlan", "Mammadov", "Ali", 18));
        people.add(new Person(2, "Emil", "Ahmadli", "Nazim", 26));
        people.add(new Person(3, "Iqbal", "Hesenli", "Hesen", 22));

        try{
            ExcelExporter.toExcel(people, "C:\\Users\\user\\Desktop\\");
        }catch (ClassNotExportable e){
            logger.error(e.getMessage());
        }
        catch (NoExportableFieldsFound e){
            logger.error(e.getMessage());
        }
        catch (NoExportableDataFound e){
            logger.error(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

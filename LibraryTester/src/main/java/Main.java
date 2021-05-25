import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        List<Person> people = new ArrayList<>();
        people.add(new Person(1, "Nurlan", "Mammadov", "Ali", 18));
        people.add(new Person(2, "Emil", "Ahmadli", "Nazim", 26));
        people.add(new Person(3, "Iqbal", "Hesenli", "Hesen", 22));

        ExcelExporter.toExcel(people, "C:\\Users\\user\\Desktop\\");
    }
}

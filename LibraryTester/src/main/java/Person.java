import annotations.ExportField;
import annotations.Exportable;

@Exportable("people")
public class Person {
    private long id;
    private String name;
    private String surname;
    private String fatherName;
    private int age;

    public Person(long id, String name, String surname, String fatherName, int age) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.fatherName = fatherName;
        this.age = age;
    }
}

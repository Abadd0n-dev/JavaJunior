import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employees> employees = Arrays.asList(
                new Employees(22, "Руслан", "Java разработчик"),
                new Employees(25, "Андрей", "С# разработчик")
        );

        SerializableObjectToFile serializableObjectToFile = new SerializableObjectToFile();
        serializableObjectToFile.writingObjectToFile(employees);
        serializableObjectToFile.readingObjectFromFile(serializableObjectToFile.getPath());
    }
}

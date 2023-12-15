import java.io.*;
import java.util.UUID;

public class SerializableObjectToFile {
    private final String path = SerializableObjectToFile.class.getName() + "_" + UUID.randomUUID();

    public String getPath() {
        return path;
    }

    /**
     * Метод записывающий объект в файл
     *
     * @param object записываемый объект
     * @param <T>    класс записываемого объекта
     */
    public <T> void writingObjectToFile(T object) {
        try (FileOutputStream outputStream = new FileOutputStream(path);
             ObjectOutput objectOutput = new ObjectOutputStream(outputStream)) {
            objectOutput.writeObject(object);
        } catch (IOException e) {
            if (e instanceof FileNotFoundException) {
                System.out.println("Файл " + path + " не существует (" + e.getMessage() + ")");
            } else {
                System.out.println("Ошибка записи файла (" + e.getMessage() + ")");
            }
        }
    }

    /**
     * Метод чтения объекта из файла
     *
     * @param pathFile путь к файлу для чтения
     */
    public void readingObjectFromFile(String pathFile) {
        try (FileInputStream inputStream = new FileInputStream(pathFile);
             ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)) {
            System.out.println(objectInputStream.readObject());
            File inputStreamFile = new File(pathFile);
            inputStreamFile.delete();
        } catch (IOException | ClassNotFoundException e) {
            if (e instanceof FileNotFoundException) {
                System.out.println("Файл " + pathFile + " не существует (" + e.getMessage() + ")");
            } else if (e instanceof ClassNotFoundException) {
                System.out.println("Класс считанный из файла " + pathFile + " не найден (" + e.getMessage() + ")");
            } else {
                System.out.println("Ошибка чтения файла (" + e.getMessage() + ")");
            }
        }
    }
}

package Utils;

import Models.IModel;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    public static <T> List<T> readFile(String path, Class<T> tClass) {
        List<T> datas = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                Object obj = tClass.getDeclaredConstructor().newInstance();
                IModel<T> iModel = (IModel<T>) obj;
                iModel.parseData(line);
                datas.add((T) obj);
            }
            fileReader.close();
            bufferedReader.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        return datas;
    }


    public static <T> void saveData(String filePath, List<T> data) {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (T item : data) {
                writer.write(item.toString());
                writer.write(System.lineSeparator());
            }
            System.out.println("Lưu dữ liệu thành công!");
        } catch (IOException e) {
            System.out.println("Lỗi khi lưu dữ liệu: " + e.getMessage());
        }

    }
    //doc file => object
    // deserialize to Object from given file
    public static Object deserialize(String fileName) throws IOException,
            ClassNotFoundException {
        FileInputStream fis = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Object obj = ois.readObject();
        ois.close();
        return obj;
    }

    //ghi object vo file
    // serialize the given object and save it to file
    public static void serialize(Object obj, String fileName)
            throws IOException {
        FileOutputStream fos = new FileOutputStream(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(obj);

        fos.close();
    }

}

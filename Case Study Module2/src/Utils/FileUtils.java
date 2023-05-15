package Utils;

import models.IModel;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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




















}

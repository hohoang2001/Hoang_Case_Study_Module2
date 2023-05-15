package models;

import java.nio.file.Path;

public interface IModel<T> {
    void parseData(String line);

}

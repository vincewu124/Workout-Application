package model;

import java.io.IOException;

public interface Save {
    void save(String nameFile, String body) throws IOException;
}

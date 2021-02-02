package model;

import exception.LoadingException;
import java.io.IOException;
import java.util.List;

public interface Load {
    List<String> load(String wantFile) throws IOException, ClassNotFoundException, LoadingException;
}

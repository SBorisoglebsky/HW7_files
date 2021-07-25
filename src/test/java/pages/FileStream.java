package pages;

import java.io.InputStream;

public class FileStream {

    public InputStream openFile (String fileName){

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream stream = classLoader.getResourceAsStream(fileName);
        return stream;
    }
}

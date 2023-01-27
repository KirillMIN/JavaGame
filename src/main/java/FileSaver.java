import java.io.File;
import java.util.ArrayList;
import java.util.Objects;
import java.util.TreeSet;
import java.util.stream.Stream;

public class FileSaver {

    public static ArrayList<File> chkDir(){
        ArrayList<File> files = new ArrayList<>();
        Stream.of(new File(("D:\\")).listFiles(File::isDirectory))
                .forEach((File f) -> files.add(f));
       return files;
    }


    public static void main(String[] args) {
        FileSaver.chkDir();
    }

}

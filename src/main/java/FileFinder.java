import java.io.File;
import java.util.ArrayList;
import java.util.Objects;

public class FileFinder {
    ArrayList<File> files = new ArrayList<>();

    public static ArrayList<File> chkDir(File file, ArrayList<File> dir){
        try {


            for (File elem : file.listFiles()) {
                if (elem.isDirectory()) {
                    dir.add(new File(elem.getAbsolutePath()));
                    chkDir(elem, dir);
                }

            }
        } catch (Exception e) {
            System.out.println(file + " have not files");
        }
        return dir;
    }

    public static void main(String[] args) {
        ArrayList<File> dirs = new ArrayList<>();
        for(File name: FileFinder.chkDir(new File("D:\\"), dirs)){
            System.out.println(name);
        }

    }
}

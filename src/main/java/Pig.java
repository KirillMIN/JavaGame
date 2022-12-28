import java.io.File;

public class Pig {
    private boolean isFull;

    public void setFull(boolean full) {
        isFull = full;
    }

    public boolean isFull() {
        return isFull;
    }

    public void digest(File file){

    }

    public void oink(){
        if(isFull){
            System.out.println("oink"); // change to picture
        }
    }

    public void changePosition(){ // maybe in another file

    }
}

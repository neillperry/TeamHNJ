import java.util.Random;
public class NumberGen{

    public int random(int min) {
        Random r = new Random();
        return r.nextInt((999999999-1)+1) + min;
    }
}

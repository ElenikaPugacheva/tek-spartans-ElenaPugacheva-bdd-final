package utility;
import base.BaseSetup;
public class RandomEmail extends BaseSetup {
    public static String EmailGenerator(String name){
        int randomNumber = (int) (Math.random()*100);
        return name + randomNumber + "@gmail.com";
    }
}

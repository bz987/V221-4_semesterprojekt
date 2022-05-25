package utility;

public class Utility {

    // takes a value and limits it between a min and max value
    public static int clamp(int value, int min, int max){
        return Math.max(min, Math.min(max, value));
    }


}

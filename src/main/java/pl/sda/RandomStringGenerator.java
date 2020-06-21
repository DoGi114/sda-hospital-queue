package pl.sda;

import java.util.Random;

public class RandomStringGenerator {
    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String generate(){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0 ; i < new Random().nextInt(12)+6; i++){
            stringBuilder.append(ALPHA_NUMERIC_STRING.charAt((int) (Math.random() * ALPHA_NUMERIC_STRING.length())));
        }
        return stringBuilder.toString();
    }
}

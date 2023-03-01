import java.util.Random;

public class Nickname {

    public int getCounterA() {
        return counterA;
    }

    public int getCounterB() {
        return counterB;
    }

    public int getCounterC() {
        return counterC;
    }

    protected int counterA;
    protected int counterB;
    protected int counterC;

    public static String generateText(String letters, int length) {
        Random random = new Random();
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < length; i++) {
            text.append(letters.charAt(random.nextInt(letters.length())));
        }
        return text.toString();
    }

    public void perfectNicknameA (String text) {
        int counter = 0;
        char symbol = 'a';
        char[] chars = text.toCharArray();
        for(int i = 0; i < chars.length; i++) {
            if(chars[i] == symbol) {
                counter++;
            }
            if(counter > chars.length/2) {
                counterA++;
            }
        }
    }

    public void perfectNicknameB (String text) {
        int counter = 0;
        char symbol = 'b';
        char[] chars = text.toCharArray();
        for(int i = 0; i < chars.length; i++) {
            if(chars[i] == symbol) {
                counter++;
            }
            if(counter > chars.length/2) {
                counterB++;
            }
        }
    }

    public void perfectNicknameC (String text) {
        int counter = 0;
        char symbol = 'c';
        char[] chars = text.toCharArray();
        for(int i = 0; i < chars.length; i++) {
            if(chars[i] == symbol) {
                counter++;
            }
            if(counter > chars.length/2) {
                counterC++;
            }
        }
    }
}
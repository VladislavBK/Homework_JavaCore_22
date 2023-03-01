import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(5);
        Nickname nickname = new Nickname();
        String[] texts = new String[100_000];
        for (int i = 0; i < texts.length; i++) {
            texts[i] = Nickname.generateText("abc", 3 + random.nextInt(3));
        }

        new Thread(() -> {
            for(int i = 0; i < 100; i++) {
                for (String text : texts) {
                    nickname.perfectNicknameA(text);
                    try {
                        blockingQueue.put("Текст с А " + nickname.getCounterA());
                        Thread.sleep(150);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(() -> {
            for(int i = 0; i < 100; i++) {
                for (String text : texts) {
                    nickname.perfectNicknameB(text);
                    try {
                        blockingQueue.put("Текст с B " + nickname.getCounterB());
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(() -> {
            for(int i = 0; i < 100; i++) {
                for (String text : texts) {
                    nickname.perfectNicknameC(text);
                    try {
                        blockingQueue.put("Текст с C " + nickname.getCounterC());
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(350);
                System.out.println(blockingQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

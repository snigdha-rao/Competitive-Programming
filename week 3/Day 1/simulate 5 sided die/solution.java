import java.util.Random;

class Solution {

    private static final Random rnd = new Random();

    private static int rand7() {
        return rnd.nextInt(7) + 1;
    }

    public static int rand5() {

        // implement rand5() using rand7()
        int x = rand7();
        while(x > 5){
            x = rand7();
        }

        return x;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.printf("%d ", rand5());
        }
        System.out.println();
    }
}
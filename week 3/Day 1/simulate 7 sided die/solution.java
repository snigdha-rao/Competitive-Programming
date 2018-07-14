import java.util.Random;

class Solution {

    private static final Random rnd = new Random();

    private static int rand5() {
        return rnd.nextInt(5) + 1;
    }

    public static int rand7() {

        while(true){
            int r1 = 5 * (rand5()-1);
            int r2 = rand5();
            r1 = r1+r2;
            if (r1 <= 21)
                return (r1%7+1);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 14; i++) {
            System.out.printf("%d ", rand7());
        }
        System.out.println();
    }
}
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import java.util.*;
import static org.junit.Assert.*;

public class Solution {

    public static void reverseWords(char[] message) {

        // decode the message by reversing the words
        reverse(0, message.length-1, message);
        boolean oneWord = true;
        int left = 0;
        for (int i = 0 ; i < message.length ; i++){
            if (message[i] == ' '){
                oneWord = false;
                reverse(left, i-1, message);
                left = i+1;
            }
        
        }
        if (oneWord){
            reverse(0, message.length-1, message);
            return;
        }
        if (left < message.length-1)
            reverse(left, message.length-1, message);

    }
    
    public static void reverse(int left, int right, char [] message){
        while(left < right){
            char temp = message[left];
            message[left] = message[right];
            message[right] = temp;
            left++;
            right--;
        }
    }


















    // tests

    @Test
    public void oneWordTest() {
        final char[] expected = "vault".toCharArray();
        final char[] actual = "vault".toCharArray();
        reverseWords(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void twoWordsTest() {
        final char[] expected = "cake thief".toCharArray();
        final char[] actual = "thief cake".toCharArray();
        reverseWords(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void threeWordsTest() {
        final char[] expected = "get another one".toCharArray();
        final char[] actual = "one another get".toCharArray();
        reverseWords(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void multipleWordsSameLengthTest() {
        final char[] expected = "the cat ate the rat".toCharArray();
        final char[] actual = "rat the ate cat the".toCharArray();
        reverseWords(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void multipleWordsDifferentLengthsTest() {
        final char[] expected = "chocolate bundt cake is yummy".toCharArray();
        final char[] actual = "yummy is cake bundt chocolate".toCharArray();
        reverseWords(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void emptyStringTest() {
        final char[] expected = "".toCharArray();
        final char[] actual = "".toCharArray();
        reverseWords(actual);
        assertArrayEquals(expected, actual);
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(Solution.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}
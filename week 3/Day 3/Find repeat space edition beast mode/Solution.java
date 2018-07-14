import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class Solution {

    public static int findDuplicate(int[] theArray) {

        // find a number that appears more than once ... in O(n) time
    
        int sum = 0;
        for (int i = 0 ; i < theArray.length ; i++){
            sum += theArray[i];
        }
        int n = sum/(theArray.length-1);
        int count1=0, count2 = 0, count3 = 0;
        for(int i = 0 ; i < theArray.length ; i++){
            if (theArray[i] == n-1)
                count1++;
            else if(theArray[i] == n)
                count2++;
            else if(theArray[i] == n+1)
                count3++;
        }
        if (count1 > 1)
            return n-1;
        else if(count2 > 1)
            return n;
        else if (count3 > 1)
            return n+1;

        return 0;
    }


















    // tests

    @Test
    public void justTheRepeatedNumberTest() {
        final int[] numbers = {1, 1};
        final int expected = 1;
        final int actual = findDuplicate(numbers);
        assertEquals(expected, actual);
    }

    @Test
    public void shortArrayTest() {
        final int[] numbers = {1, 2, 3, 2};
        final int expected = 2;
        final int actual = findDuplicate(numbers);
        assertEquals(expected, actual);
    }

    @Test
    public void mediumArrayTest() {
        final int[] numbers = {1, 2, 5, 5, 5, 5};
        final int expected = 5;
        final int actual = findDuplicate(numbers);
        assertEquals(expected, actual);
    }

    @Test
    public void longArrayTest() {
        final int[] numbers = {4, 1, 4, 8, 3, 2, 7, 6, 5};
        final int expected = 4;
        final int actual = findDuplicate(numbers);
        assertEquals(expected, actual);
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
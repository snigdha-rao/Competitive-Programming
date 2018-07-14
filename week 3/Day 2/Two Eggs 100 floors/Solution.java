import java.util.*;
class Solution{
	public static int eggsAndFloors(boolean [] b){
		int y = 100;
		int k = 14;
		int m = 0;
		int n = 0;
		while(n < y){
			m = n;
			n += k;
			k = k-1;
			if(b[n])
				break;
		}

		for (int i = m ; i <= n ; i++){
			if(b[i]){
				return i-1;
			}
		}
		return -1;

	}
	public static void main(String[] args) {
		Random rand = new Random();
		for (int i = 0 ; i < 10 ; i++){
			int z = rand.nextInt(100) + 1;
			boolean [] b = new boolean[101];
			for (int j = 1 ; j< 101 ; j++)
			{
				if (j < z)
					b[j] = false;
				else
					b[j] = true;

			}

			
			int actual = eggsAndFloors(b);
			System.out.println("--------------------------------------------------------------------");
			System.out.println("Test Case "+i);
			System.out.println("Expected "+(z-1));
			System.out.println("Actual "+actual);
			if(z-1 == actual)
				System.out.println("Passed");
			else
				System.out.println("Failed");
			System.out.println("--------------------------------------------------------------------");


		}

	}
}
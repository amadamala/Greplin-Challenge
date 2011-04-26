import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * 
 * 	Level 2
	
	----------------------------------------

	Congratulations.  You have reached level 2.
	
	To get the password for level 3, write code to find the first prime
	fibonacci number larger than a given minimum.  For example, the first
	prime fibonacci number larger than 10 is 13.

	When you are ready, go here or call this automated
	number (415) 799-9454.
	
	You will receive additional instructions at that time.  For the second portion
	of this task, note that for the number 12 we consider the sum of the prime divisors
	to be 2 + 3 = 5.  We do not include 2 twice even though it divides 12 twice.
	
	Enter the password to access level 3:
	Step 1. Use your code to compute the smallest prime fibonacci number
	        greater than 227,000.  Call this number X.
	
	Step 2. The password for level 3 is the sum of prime divisors of X + 1.
	
	Note: If you call the number instead, it will check your answer for step 1.
	
	The Greplin Programming Challenge
 */
public class FirstPrimeFibonacciLargerThanGivenNumber {

	
	public static void main(String[] args) {
		
		fib(227000);
		if(isPrime(514229)) {
			System.out.println("yes it is prime");
		}
	}
	
	public static void fib(long n) {
		long f1 = 0;
		long f2 = 1;
		long f3 = f1 + f2;
		System.out.print(f1 +" "+ f2 +" ");
		while(true) {
			System.out.print(f3 + " ");
			f1 = f2;
			f2 = f3;
			f3 = f1 + f2;
			
			if(f3 > n && isPrime(f3)) {
				System.out.println("First prime fibonacci larger than given n:: " + f3);
				System.out.println(sumOfPrimeFactors((f3 + 1)));
				break;
			}
		}
	}
	
	public static int sumOfPrimeFactors(long n) {
		int sum = 0;
		Set<Long> set = new HashSet<Long>();
		for(long i = 2; i <= Math.sqrt(n); i++) {
			if(n % i == 0 && isPrime(i)) {
				set.add(new Long(i));
			}
		}
		System.out.println(Arrays.toString(set.toArray()));
		for (Long p : set) {
			sum += p;
		}
		return sum;
	}
	public static boolean isPrime(long n) {
		boolean prime = true;
		for (long i = 3; i <= Math.sqrt(n); i += 2)
			if (n % i == 0) {
				prime = false;
				break;
			}
		if (( n%2 !=0 && prime && n > 2) || n == 2) {
			return true;
		} else {
			return false;
		}
	}

}

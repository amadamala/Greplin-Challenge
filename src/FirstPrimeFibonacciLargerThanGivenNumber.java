import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 	Level 2
	----------------------------------------
	Enter the password to access level 3:
	Step 1. Use your code to compute the smallest prime fibonacci number
	        greater than 227,000.  Call this number X.
	
	Step 2. The password for level 3 is the sum of prime divisors of X + 1.
	
	
	The Greplin Programming Challenge
 */
public class FirstPrimeFibonacciLargerThanGivenNumber {

	
	public static void main(String[] args) {
		fib(227000);
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

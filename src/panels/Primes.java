package panels;

public class Primes {

	//Aqui solo calculamos si un numero es primo o no
	public static boolean isPrime(int n) {
		boolean ret = true;
		for (int i = (n - 1); i > 1; i--) {
			if (n % i == 0) {
				ret = false;
			}
		}
		return ret;
	}

}

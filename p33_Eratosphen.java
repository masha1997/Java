import java.util.*;
import java.lang.*;
import java.io.*;

public class p33_Eratosphen
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner s = new Scanner(System.in);
		int a = s.nextInt(), b = s.nextInt(),
		n = Math.max(a, b), o = Math.min(a, b);
		
		
		boolean prime[] = new boolean[n + 1];
		prime[0] = prime[1] = false;
		for (int i = 2; i <= n; i++)
			prime[i] = true;
		for (int i = 2; i <= n; ++i)
			if (prime[i])
				if (i * 1L * i <= n)
					for (int j = i * i; j <= n; j += i)
						prime[j] = false;
		
		int counter = 0;
		
		for (Integer i = o; i <= n; ++i)
			if (prime[i])
				if (!(i.toString().contains("13")))
					++counter;
			System.out.println (counter);
			
			
		
	}
}
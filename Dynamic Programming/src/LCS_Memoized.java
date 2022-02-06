import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//Memoized Version of Longest Common Subsequence
public class LCS_Memoized {

	static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static int dp[][]; 
    
	public static void main(String[] args) throws IOException {
		
		String s1 = next();
		String s2 = next();
		
		char X[] = new char[s1.length()];
		char Y[] = new char[s2.length()];
		dp= new int[X.length+1][Y.length+1];
		
		for(int i=0;i<dp.length;i++)
			for(int j=0;j<dp[i].length;j++)
			dp[i][j]=-1;
		
		for(int i=0;i<s1.length();i++) 
			X[i]=s1.charAt(i);
		
		for(int i=0;i<s2.length();i++) 
			Y[i]=s2.charAt(i);
		
		
		System.out.println(lcs(X,Y,s1.length()-1,s2.length()-1));
		System.out.println(Arrays.deepToString(dp));
	}
	
	private static int lcs(char[] X, char[] Y, int m, int n) {
		
		if(m==-1 || n==-1)
			return 0;
		
		if(dp[m][n]!=-1)
			return dp[m][n];
		
		if(X[m]==Y[n]) {
			dp[m][n]=1+lcs(X,Y,m-1,n-1);
			return dp[m][n];
		}
		
		else
			return Math.max(lcs(X,Y,m-1,n),lcs(X,Y,m,n-1));
		
	}

	

	static String next () throws IOException {
	       while (st == null || !st.hasMoreTokens())
	            st = new StringTokenizer(br.readLine().trim()); 
	        return st.nextToken();
	    }
	    static long readLong () throws IOException {
	        return Long.parseLong(next());
	    }
	    static int readInt () throws IOException {
	        return Integer.parseInt(next());
	    }
	    static double readDouble () throws IOException {
	        return Double.parseDouble(next());
	    }
	    static String readLine () throws IOException {
	        return br.readLine().trim();
	    }
}

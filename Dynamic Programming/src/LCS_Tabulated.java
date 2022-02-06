import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.youtube.com/watch?v=sSno9rV8Rhg&ab_channel=AbdulBari
public class LCS_Tabulated {

	static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static int dp[][]; 
    
	public static void main(String[] args) throws IOException{
		int s1Length = readInt();
		int s2Length = readInt();
		
		int X[] = new int[s1Length];
		int Y[] = new int[s2Length];
		dp= new int[X.length+1][Y.length+1];
		
		//User input for the values
		for(int i=0;i<s1Length;i++) 
			X[i]=readInt();
		
		for(int i=0;i<s2Length;i++) 
			Y[i]=readInt();
		
		for(int i=0;i<=s1Length;i++)
			dp[i][0]=0;
		
		for(int i=0;i<=s2Length;i++)
			dp[0][i]=0;
		
		for(int i=1;i<X.length;i++) {
			
			for(int j=1;j<Y.length;j++) {
				
				if(X[i]==Y[j])
					dp[i][j]=1+dp[i-1][j-1];
				else
					dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
			}
		}
		
		
		System.out.println(dp[s1Length][s2Length]);

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

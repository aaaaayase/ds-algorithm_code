import java.util.*;
import java.io.*;

public class Main1
{
    public static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static Read in = new Read();

    public static void main(String[] args) throws IOException
    {
        // 写代码
        int n = in.nextInt();
        int[] arr =new int[n+1];
        long temp=0;
        long sum=0;

        for(int i=1;i<=n;i++) {
            arr[i]=in.nextInt();
        }

        for(int i=n;i>=2;i--) {
            temp+=(long)arr[i];
            sum+=(long)(arr[i-1]*temp);
        }


        out.println(sum);
        out.close();
    }
}


class Read // 自定义快速读入
{
    StringTokenizer st = new StringTokenizer("");
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    String next() throws IOException
    {
        while(!st.hasMoreTokens())
        {
            st = new StringTokenizer(bf.readLine());
        }
        return st.nextToken();
    }

    String nextLine() throws IOException
    {
        return bf.readLine();
    }

    int nextInt() throws IOException
    {
        return Integer.parseInt(next());
    }

    long nextLong() throws IOException
    {
        return Long.parseLong(next());
    }

    double nextDouble() throws IOException
    {
        return Double.parseDouble(next());
    }
}

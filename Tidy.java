package practice;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class Tidy 
{
	public static void main(String[]  args) throws IOException
	{
		Scanner input = new Scanner(System.in);
		int n = Integer.parseInt(input.nextLine());
		long[] nums = new long[n]; 
		for(int i=0;i<n;i++)
		{
			nums[i] = Long.parseLong(input.nextLine());
		}
		PrintWriter pw = new PrintWriter(new FileWriter("out.txt"));
		for(int i=0; i<n;i++)
		{			
			pw.println("Case #" + (i+1) + ": " + tidy(nums[i]));			
		}
		pw.close();
	}
	public static long tidy(long n)
	{
		ArrayList<Integer> temp = new ArrayList<>();
		while(n>0)
		{
			temp.add(0,(int)(n%10));
			n/=10;
		}
		int index = temp.size()-1;
		while(index>0)
		{
			if(temp.get(index-1)>temp.get(index))
			{
				for(int j=index;j<temp.size();j++)
				{
					temp.set(j, 9);
				}
				int b = temp.get(index-1);
				temp.set(index-1, b-1);
				int a = temp.get(index-1);
				if(a<0)
				{
					temp.set(index-2, temp.get(index-2)-1);
					a=0;
				}			
			}
			index--;
		}
		long num=0;
		int pow =0;
		for(int i=temp.size()-1;i>=0;i--)
		{
			num+= (long)(temp.get(i)*Math.pow(10, pow));
			pow++;
			
		}
		return num;
		
	}

}

package practice;
import java.util.*;
public class Pancake 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int n = Integer.parseInt(input.nextLine());
		String[] s = new String[n];
		
		for(int i =0; i<n; i++)
		{
			s[i]=input.nextLine();
		}
		//System.out.println("HelloWorld");
		for(int c=0;c<n;c++)
		{
			System.out.println("Case #" + (c+1)+ ": " + flipper(s[c]));
		}
		
		
	}
	public static int flipper(String str)
	{
		int o=0;
		for(int i=0;i<str.length();i++)
		{
			if(str.charAt(i)=='+')
				o++;
		}
		if(o==str.length())
			return 0;
		boolean flipped = false;
		int count=0;
		while(flipped == false)
		{			
			
			for(int i=str.length()-1;i>=0;i--)
			{
				if(str.charAt(i)=='-')
				{
					str = flip(str,i);		
					count++;
				}
				if(str.indexOf('-')==-1)
				{
					flipped=true;
				}
				//System.out.println(str);
				
			}
		}
		return count;		
	}
	public static String flip(String str, int index)
	{
		char[] c = str.toCharArray();
		for(int i=0;i<=index;i++)
		{
			if(c[i]=='+')
			{
				c[i]='-';
			}
			else
			{
				c[i]='+';
			}
		}
		return String.valueOf(c);
	}

}

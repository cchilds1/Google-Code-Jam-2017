package practice;
import java.util.*;
public class Sleep {

	public static void main(String[] args)
	{
		
		Scanner input = new Scanner(System.in);
		int n = Integer.parseInt(input.nextLine());
		int[] nums = new int[n];
		for(int i=0;i<n;i++)
		{
			nums[i] = Integer.parseInt(input.nextLine());			
		}
		for(int j=0; j<n;j++)
		{
			System.out.println("Case #" + (j+1) +": " + fallAsleep(nums[j]));
			
		}
		
	}
	public static String fallAsleep(int num)
	{
		if(num==0)
		{
			return "INSOMNIA";
		}
		int temp =0;
		String str = num +"";
		boolean[] sleep = new boolean[10];
		for(boolean b : sleep)
		{
			b=false;
		}
		boolean asleep = false;
		int l=1;
		while(asleep==false)
		{
			temp = num *l;
			l++;
			str = temp +"";
			for(int c=0;c<str.length();c++)
			{
				
				char m = str.charAt(c);
				if(Character.isDigit(m))
				{
					int n = m-'0';
					sleep[n] = true;
				}
			}
				
			int yay=0;
			for(boolean b : sleep)
			{
				if(b==true)
				{
					yay++;
				}
			}
			if(yay==10)
			{
				asleep=true;
			}
			
		}
		return temp+"";
	}
}

package codeJamPractice;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class LastWord 
{
	public static void main(String[] args) throws IOException
	{
		PrintWriter pw = new PrintWriter(new FileWriter("lastword.txt"));
		Scanner input = new Scanner(System.in);
		int n = Integer.parseInt(input.nextLine());
		for(int i=0;i<n;i++)
		{
			String s = input.nextLine();
			pw.println("Case #" + (i+1) + ": " + lastWord(s));
		}
		pw.close();
	}
	public static String lastWord(String str)
	{
		ArrayList<Character> w = new ArrayList<>();
		w.add(str.charAt(0));
		for(int i=1; i<str.length();i++)
		{
			char c = str.charAt(i);
			if(c>=w.get(0))
			{
				w.add(0,c);
			}
			else
			{
				w.add(c);
			}
		}
		String temp = "";
		for(int i=0;i<str.length();i++)
		{
			temp+= "" + w.get(i);
		}
		return temp;
	}

}

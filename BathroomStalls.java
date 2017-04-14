package practice;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
public class BathroomStalls
{
	public static void main(String[] args) throws IOException
	{
		Scanner input = new Scanner(System.in);
		int numInputs = Integer.parseInt(input.nextLine());
		long[] numStalls = new long[numInputs];
		long[] numPeople = new long[numInputs];
		PrintWriter pw = new PrintWriter(new FileWriter("output3.txt"));
		for(int i=0;i<numInputs;i++)
		{
			String str = input.nextLine().trim();
			numStalls[i] = Long.parseLong(str.substring(0, str.indexOf(' ')));
			numPeople[i] = Long.parseLong(str.substring(str.indexOf(' ')+1));			
		}
		for(int i=0;i<numInputs;i++)
		{
			long stalls = numStalls[i];
			long people = numPeople[i];
			ArrayList<Long> indexes = new ArrayList<>();
			indexes.add((long) 0);
			indexes.add(stalls+1);
			
			while(people>0)
			{
				int g =0;
				long indexA= indexes.get(g);
				long indexB= indexes.get(g+1);
				long tempIndexA = indexB;
				long tempIndexB = indexB;
				long dist = indexB-indexA;
				g+=2;
				int temp = 0;
				while(tempIndexB<stalls+1)
				{
					tempIndexA = tempIndexB;
					tempIndexB = indexes.get(g);
					if(tempIndexB-tempIndexA>dist)
					{
						dist = tempIndexB-tempIndexA;
						indexA = tempIndexA;
						temp = g;
						indexB = tempIndexB;
					}
					g++;
				}
				long index = indexA + dist/2;
				indexes.add(temp, index);
				if(people==1)
				{
					long left = index-indexA-1;
					long right = indexB-index-1;
					long min = Math.min(left, right);
					long max = Math.max(left, right);
					//System.out.println(indexes);
					System.out.println("Case #" + (i+1)+ ": " + max + " " + min);
				}
				people--;				
			}
		}pw.close();
	}

}
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MorseCodeConverter 
{
	private static MorseCodeTree morse = new MorseCodeTree();

	public static String convertToEnglish(String code) 
	{
		String convertEnglish = " ";
		String[] letter;
		String [] word = code.split("/");
		
	
		for(int i = 0; i < word.length; i++) 
		{
			word[i]= word[i].trim();
			letter = word[i].split(" ");
			convertEnglish += " ";
			
			for(int j = 0; j < letter.length; j++) 
			{
				convertEnglish += morse.fetch(letter[j]);
			}
		}
		return convertEnglish.trim();
	}
	
	public static String convertToEnglish(File codeFile) throws FileNotFoundException
	{
		Scanner scanner = new Scanner(codeFile);
		String output = convertToEnglish(scanner.nextLine());
		return output;
	}
	
	public static String printTree() 
	{
		StringBuilder string = new StringBuilder();
		ArrayList<String> arrayList = morse.toArrayList();
		
		for (String i: arrayList) 
		{
			string.append(i).append(" ");
		}
		return string.toString().trim();
	}
}

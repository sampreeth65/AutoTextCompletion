package AutoTextCompletion;

import java.util.List;

public class Main
{
	public static void main(String[] args) 
	{
		ReadFile read = new ReadFile();
		List<String> list = read.findWord("Hello");
		for (String word : list)
			System.out.println(word);
	}

}

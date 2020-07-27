package AutoTextCompletion;

public class Main 
{
	public static void main(String[] args) 
	{
		AutoTextCompletion.Trie trie = new AutoTextCompletion.Trie();
		trie.insert("Hello");
		System.out.println(trie.contains("Hello"));

	}

}

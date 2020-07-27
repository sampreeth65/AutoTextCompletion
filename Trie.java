package AutoTextCompletion;

import java.util.HashMap;




public class Trie 
{
	private class Node
	{
		private char character;
		private HashMap<Character, Node> children = new HashMap<Character, Trie.Node>();
		private boolean isEndOfWord;
		
		public Node(char character)
		{
			this.character = character;
		}
		
		public boolean hasChild(char character) 
		{
            return children.containsKey(character);
        }

        public void addChild(char character) 
        {
            children.put(character, new Node(character));
        }

        public Node getChild(char character) 
        {
            return children.get(character);
        }
        
        @Override
        public String toString() 
        {
        	return "Value" + character;
        }

	}
	
	Node root = new Node(' ');

	public void insert(String word)
	{
		insert(root,word,0);
	}

	private void insert(Node root, String word, int index)
	{
		if (word.length() == index)
		{
			root.isEndOfWord = true;
			return;
		}

		if (!root.hasChild(word.charAt(index)))
			root.addChild(word.charAt(index));

		insert(root.getChild(word.charAt(index)), word, index +1);
	}

	public boolean contains(String word)
	{
		return contains(root,word,0);
	}

	private boolean contains(Node root,String word,int index)
	{
		if (index == word.length())
		{
			return root.isEndOfWord ? true : false;
		}

		if (!root.hasChild(word.charAt(index)))
			return false;

		root = root.getChild(word.charAt(index));
		return contains(root,word,index + 1);
	}
}

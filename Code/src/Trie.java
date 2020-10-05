public class Trie {

	private TrieNode root;
	private int wordcount;

	public Trie(){
		root= new TrieNode('\0');
	}

	public boolean search(String word) {
		return search(root,word);
	}

	private boolean search(TrieNode root, String word) {

		if(word.length()==0)
		{
			return root.isterminating;
		}

		TrieNode child= root.children[word.charAt(0)-'a'];
		if(child==null)
		{
			return false;
		}

		else {
			    return search(child, word.substring(1));
		     }

    
	}

	public void add(String word) {
		if(insert(root,word))
		{
			wordcount++;
		}
	}

	private boolean insert(TrieNode root, String word) {
		if(word.length()==0) {
			if(root.isterminating) {
				return false;
			}
			else {
				return true;
			}
		}

		TrieNode child=root.children[word.charAt(0)-'a'];
		if(child==null)
		{
			child= new TrieNode(word.charAt(0));
			root.children[word.charAt(0)-'a']=child;
			root.childcount++;

		}
		return insert(child,word.substring(1));

	}

	public void delete(String word)
	{
		if(delete(root, word))
		{
			wordcount--;
		}
	}


	private boolean delete(TrieNode root, String word) {

		if(word.length()==0) {
			if(root.isterminating) {
				root.isterminating=false;
				return true;
			}
			else {
				return false;
			}
		}

		TrieNode child=root.children[word.charAt(0)-'a'];
		if(child==null)
		{
			return false;
		}
		else
		{
			boolean result= delete(child, word.substring(1));
			if(result) {
				if(!child.isterminating&&child.childcount==0)
				{
					root.children[word.charAt(0)-'a']=null;
					root.childcount--;
				}
			}
			return result;
		}
	}
	
	public int getwordcount()
	{
		return wordcount;
	}

}





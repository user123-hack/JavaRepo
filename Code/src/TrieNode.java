public class TrieNode {
	
	char data;
	TrieNode[] children;
	boolean isterminating;
	int childcount;
	
	public TrieNode(char data) {
		this.data=data;
		children=new TrieNode[26];
	}
	
	

}

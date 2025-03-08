class Trie {

	public TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	public void insert(String word) {

		//	apple
		int length = word.length();
		int index;

		TrieNode next = root;


		//	a => 1
		//	j => 10
		//	p => 16
		//	length: 5
		for ( int i = 0; i < length; i++ ) {

			//	a => 1
			//	p => 16
			//	l => 12

			index = word.charAt(i) - 'a' + 1;

			if ( next.children[index] == null ) {
				next.children[index] = new TrieNode();
			}

//			System.out.println("next = " + next);
//			System.out.println("next.children[" + index + "] = " + next.children[index]);

			next = next.children[index];
		}

//		System.out.println("next = " + next);

		next.isEndOfWord = true;
	}

	public boolean search(String word) {

		//	apple
		int length = word.length();
		int index;

		TrieNode next = root;

		//	a => 1
		//	j => 10
		//	p => 16
		//	length: 5
		for ( int i = 0; i < length; i++ ) {

			//	a => 1
			//	p => 16
			//	l => 12
			index = word.charAt(i) - 'a' + 1;

			if ( next.children[index] == null ) {
				return false;
			}

			System.out.println("next = " + next);
			System.out.println("next.children[" + index + "] = " + next.children[index]);

			next = next.children[index];
		}

		return next.isEndOfWord;
	}

	public boolean startsWith(String prefix) {

		//	app
		int length = prefix.length();
		int index;

		TrieNode next = root;

		//	a => 1
		//	p => 16
		for ( int i = 0; i < length; i++ ) {

			//	a => 1
			//	p => 16
			//	l => 12
			index = prefix.charAt(i) - 'a' + 1;

			if ( next.children[index] == null ) {
				return false;
			}

			next = next.children[index];
		}

		return true;
	}

	public static void main(String[] args) {

		Trie trie = new Trie();
		trie.insert("apple");
		System.out.println(trie.search("apple"));
//		System.out.println(trie.search("app"));
//		System.out.println(trie.startsWith("app"));
//		trie.insert("app");
//		System.out.println(trie.search("app"));
	}
}

class TrieNode {

	private static final int ALPHABET_SIZE = 26;

	TrieNode[] children = new TrieNode[ALPHABET_SIZE + 1];
	Boolean isEndOfWord;

	public TrieNode() {

		isEndOfWord = false;

		for ( int i = 1; i <= ALPHABET_SIZE; i ++ ) {
			children[i] = null;
		}
	}
}
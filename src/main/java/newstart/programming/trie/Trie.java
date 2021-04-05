package newstart.programming.trie;
/** LeetCode 208
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
public class Trie {
    public boolean isWord;
    public Trie[] childs;

    /** Initialize your data structure here. */
    public Trie() {
        this.childs = new Trie[26];
        isWord = false;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie curr = this;
        for(char ch : word.toCharArray()) {
            if(curr.childs[ch-'a'] == null) {
                curr.childs[ch-'a'] = new Trie();
            }
            curr = curr.childs[ch-'a'];
        }
        curr.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie curr = this;
        for(char ch : word.toCharArray()) {
            if(curr.childs[ch-'a'] == null) {
                return false;
            }
            curr = curr.childs[ch-'a'];
        }
        return curr.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie curr = this;
        for(char ch : prefix.toCharArray()) {
            if(curr.childs[ch-'a'] == null) {
                return false;
            }
            curr = curr.childs[ch-'a'];
        }
        return true;
    }

}

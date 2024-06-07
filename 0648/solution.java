import java.util.List;

class Trie {
    boolean isWord;
    Trie[] children;

    public Trie() {
        this.isWord = false;
        this.children = new Trie[26];
    }

    public void insert(String word) {
        Trie current = this;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                current.children[index] = new Trie();
            }
            current = current.children[index];
            if (current.isWord) {
                break;
            }
        }
        current.isWord = true;
    }
}

class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie root = new Trie();
        for (String word : dictionary) {
            root.insert(word);
        }

        StringBuilder result = new StringBuilder();
        for (String word : sentence.split(" ")) {
            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(findRoot(word, root));
        }
        return result.toString();
    }

    private String findRoot(String word, Trie root) {
        Trie current = root;
        StringBuilder prefix = new StringBuilder();
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] != null) {
                prefix.append(c);
                current = current.children[index];
                if (current.isWord) {
                    return prefix.toString();
                }
            } else {
                break;
            }
        }
        return word;
    }
}

// time O(d * w + s * w)
// space O(d * w + s * w)
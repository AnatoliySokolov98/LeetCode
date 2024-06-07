class TrieNode {
  isWord: boolean;
  children: TrieNode[];

  constructor() {
    this.isWord = false;
    this.children = new Array<TrieNode>(26);
  }
}

class Trie {
  root: TrieNode;

  constructor() {
    this.root = new TrieNode();
  }

  insert(word: string): void {
    let current = this.root;
    for (let i = 0; i < word.length; i++) {
      const index = word.charCodeAt(i) - 97; // Calculate index for character
      if (!current.children[index]) {
        current.children[index] = new TrieNode();
      }
      current = current.children[index];
    }
    current.isWord = true;
  }

  findRoot(word: string): string {
    let current = this.root;
    let prefix = "";
    for (let i = 0; i < word.length; i++) {
      const index = word.charCodeAt(i) - 97; // Calculate index for character
      if (current.children[index]) {
        prefix += word[i];
        current = current.children[index];
        if (current.isWord) {
          return prefix;
        }
      } else {
        break;
      }
    }
    return word;
  }
}

function replaceWords(dictionary: string[], sentence: string): string {
  const trie = new Trie();
  for (const word of dictionary) {
    trie.insert(word);
  }

  const words = sentence.split(" ");
  const result = words.map((word) => trie.findRoot(word)).join(" ");
  return result;
}

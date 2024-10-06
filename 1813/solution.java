class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        if (sentence1.equals(sentence2)) {
            return true;
        }

        String[] w1 = sentence1.split(" ");
        String[] w2 = sentence2.split(" ");

        if (w1.length > w2.length) {
            return areSentencesSimilar(sentence2, sentence1);
        }

        int pre = 0;
        while (pre < w1.length && w1[pre].equals(w2[pre])) {
            pre++;
        }

        int post = w1.length - 1;
        int j = w2.length - 1;
        while (post >= 0 && w1[post].equals(w2[j])) {
            post--;
            j--;
        }

        return pre > post;
    }
}

// time O(n + m)
// space O(n + m)
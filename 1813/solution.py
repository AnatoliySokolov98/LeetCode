class Solution:
    def areSentencesSimilar(self, sentence1: str, sentence2: str) -> bool:
        w1 = sentence1.split(" ")
        w2 = sentence2.split(" ")

        if len(w1) > len(w2):
            w1, w2 = w2, w1

        i = 0
        while i < len(w1) and w1[i] == w2[i]:
            i += 1

        i2 = len(w1) - 1
        j = len(w2) - 1
        while i2 >= 0 and w1[i2] == w2[j]:
            i2 -= 1
            j -= 1

        return i > i2

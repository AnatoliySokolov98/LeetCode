class Solution:
    def numberToWords(self, num: int) -> str:
        if num == 0:
            return "Zero"

        lessThanTen = [
            "",
            "One",
            "Two",
            "Three",
            "Four",
            "Five",
            "Six",
            "Seven",
            "Eight",
            "Nine",
        ]
        lessThanTwenty = [
            "Ten",
            "Eleven",
            "Twelve",
            "Thirteen",
            "Fourteen",
            "Fifteen",
            "Sixteen",
            "Seventeen",
            "Eighteen",
            "Nineteen",
        ]
        lessThanHundred = [
            "",
            "Ten",
            "Twenty",
            "Thirty",
            "Forty",
            "Fifty",
            "Sixty",
            "Seventy",
            "Eighty",
            "Ninety",
        ]
        mil = 1_000_000
        bil = 1_000_000_000
        res = []

        def makeNumber(num):
            if num == 0:
                return
            elif num < 10:
                res.append(lessThanTen[num])
            elif num < 20:
                res.append(lessThanTwenty[num - 10])
            elif num < 100:
                res.append(lessThanHundred[num // 10])
                makeNumber(num % 10)
            elif num < 1000:
                res.append(lessThanTen[num // 100])
                res.append("Hundred")
                makeNumber(num % 100)
            elif num < mil:
                makeNumber(num // 1000)
                res.append("Thousand")
                makeNumber(num % 1000)
            elif num < bil:
                makeNumber(num // mil)
                res.append("Million")
                makeNumber(num % mil)
            else:
                makeNumber(num // bil)
                res.append("Billion")
                makeNumber(num % bil)

        makeNumber(num)
        return " ".join(res)

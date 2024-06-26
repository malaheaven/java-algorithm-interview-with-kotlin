public class LongestPalindromicSubstring {
    int start;
    int maxLength;

    public void extendPalindrome(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }

        if (maxLength < k - j - 1) {
            maxLength = k - j - 1;
            start = j + 1;
        }

    }

    public String longestPalindrome(String s) {
        int len = s.length();

        if (len < 2) return s;

        for (int i = 0; i < len; i++) {
            extendPalindrome(s, i, i + 1);
            extendPalindrome(s, i, i + 2);
        }

        return s.substring(start, start + maxLength);

    }

    public static void main(String[] args) {
        LongestPalindromicSubstring l = new LongestPalindromicSubstring();
        String s = "babad";
        System.out.println(l.longestPalindrome(s));
    }
}

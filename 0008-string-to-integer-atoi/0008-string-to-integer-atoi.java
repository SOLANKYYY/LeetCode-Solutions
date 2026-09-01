class Solution {
    public int myAtoi(String s) {

        int i = 0;
        int n = s.length();
        int sign = 1;

        // Skip spaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // Check sign
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            if (s.charAt(i) == '-') {
                sign = -1;
            }
            i++;
        }

        // Store result as negative to safely handle -2147483648
        int result = 0;

        int limit = (sign == -1)
                ? Integer.MIN_VALUE
                : -Integer.MAX_VALUE;

        int multLimit = limit / 10;

        while (i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9') {

            int digit = s.charAt(i) - '0';

            // Check overflow before multiplying
            if (result < multLimit) {
                return sign == 1
                        ? Integer.MAX_VALUE
                        : Integer.MIN_VALUE;
            }

            result *= 10;

            // Check overflow before subtracting digit
            if (result < limit + digit) {
                return sign == 1
                        ? Integer.MAX_VALUE
                        : Integer.MIN_VALUE;
            }

            result -= digit;
            i++;
        }

        return sign == 1 ? -result : result;
    }
}
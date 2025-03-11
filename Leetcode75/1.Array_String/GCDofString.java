class Solution {
    public String gcdOfStrings(String str1, String str2) {
        // Step 1: Quick check for a valid GCD candidate
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        // Step 2: Compute the GCD of the lengths
        int gcdLength = gcd(str1.length(), str2.length());
            System.out.println(gcdLength)
        // Step 3: Return the GCD substring from str1
        return str1.substring(0, gcdLength);
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);  // Euclidean algorithm
    }
}

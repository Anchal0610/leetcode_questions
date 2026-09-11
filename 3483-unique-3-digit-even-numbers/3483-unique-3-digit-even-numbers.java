class Solution {
    public int totalNumbers(int[] digits) {

        int[] freq = new int[10];

        // Count frequency of every digit
        for (int digit : digits) {
            freq[digit]++;
        }

        int count = 0;

        // Try every 3-digit number
        for (int num = 100; num <= 999; num++) {

            // Number must be even
            if (num % 2 != 0) {
                continue;
            }

            int n = num;

            int ones = n % 10;
            n = n / 10;

            int tens = n % 10;
            n = n / 10;

            int hundreds = n % 10;

            // Temporarily use the digits
            freq[hundreds]--;
            freq[tens]--;
            freq[ones]--;

            // If all frequencies are >= 0,
            // this number can be formed
            if (freq[hundreds] >= 0 &&
                freq[tens] >= 0 &&
                freq[ones] >= 0) {

                count++;
            }

            // Restore frequencies
            freq[hundreds]++;
            freq[tens]++;
            freq[ones]++;
        }

        return count;
    }
}
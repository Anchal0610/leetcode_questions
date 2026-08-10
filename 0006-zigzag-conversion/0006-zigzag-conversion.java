class Solution {
    public String convert(String s, int numRows) {

        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        StringBuilder[] rows = new StringBuilder[numRows];

        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int row = 0;
        int direction = 1; // 1 = down, -1 = up

        for (char ch : s.toCharArray()) {

            rows[row].append(ch);

            // Change direction at top
            if (row == 0) {
                direction = 1;
            }

            // Change direction at bottom
            if (row == numRows - 1) {
                direction = -1;
            }

            row += direction;
        }

        StringBuilder result = new StringBuilder();

        for (StringBuilder currentRow : rows) {
            result.append(currentRow);
        }

        return result.toString();
    }
}
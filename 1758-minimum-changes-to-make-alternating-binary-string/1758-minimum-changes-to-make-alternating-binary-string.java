class Solution {
    public int minOperations(String s) {

        int last1 = 0, count1 = 0;
        int last2 = 1, count2 = 0;

        if (s.charAt(0) == '0') count2++;
        else count1++;

        for (int i = 1; i < s.length(); i++) {
            int num = s.charAt(i) - '0';

            if (num == last1) {
                count1++;
                last1 = 1 - last1;
            } else {
                last1 = num;
            }

            if (num == last2) {
                count2++;
                last2 = 1 - last2;
            } else {
                last2 = num;
            }
        }

        return Math.min(count1, count2);
    }
}
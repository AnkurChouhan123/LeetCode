class Solution {
    public int minTimeToType(String word) {

        int minDistance = 0;
        char curr = 'a';

        for (int i = 0; i < word.length(); i++) {
            char target = word.charAt(i);

            minDistance += dist(curr, target) + 1;
            
            curr = target;

        }

        return minDistance;

    }

    int dist(char src, char dest) {
        int pos1 = src - 'a';
        int pos2 = dest - 'a';

        int forward = (pos2 - pos1 + 26) % 26;
        int backward = (pos1 - pos2 + 26) % 26;

        return Math.min(forward, backward);
    }
}
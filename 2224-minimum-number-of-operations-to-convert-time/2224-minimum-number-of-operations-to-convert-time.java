class Solution {
    public int convertTime(String current, String correct) {
       
       int currentMin = Integer.parseInt(current.substring(3,5));
       int correctMin = Integer.parseInt(correct.substring(3,5));

       int currentHour = Integer.parseInt(current.substring(0,2));
       int correctHour = Integer.parseInt(correct.substring(0,2));

    //    if(currentMin == 0 && correctMin == 0 ) return 0;

       return Math.abs(correctHour - currentHour) + getMins(currentMin,correctMin);

    }

    int getMins(int src, int target) {
        int count = 0;
        if (src <= target) {
            int diff = target - src;

            while (diff >= 15) {
                diff -= 15;
                count++;
            }
            while (diff >= 5) {
                diff -= 5;
                count++;
            }
            while(diff>=1){
                diff -= 1;
                count++;
            }

            return count;
        }
        else{
            int diff = src - target;
            diff = 60-diff;
             while (diff >= 15) {
                diff -= 15;
                count++;
            }
            while (diff >= 5) {
                diff -= 5;
                count++;
            }
            while(diff>=1){
                diff -= 1;
                count++;
            }

            return count-1;
        }
    }
}
class Solution {
    public int binaryGap(int n) {
        int len = 0;
        boolean found = false;
        int max = 0;

        while(n>0){
            int digit = n & 1;

            if(!found && digit == 1){
                found = true;
                len = 1;
            }
            else{

                if(found && digit == 1){
                    max = Math.max(max,len);
                    len = 1;
                }
                else len++;
            }
            n>>=1;
        }

        return max;
    }
}
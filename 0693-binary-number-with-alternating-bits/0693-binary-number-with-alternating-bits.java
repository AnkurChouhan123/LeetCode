class Solution {
    public boolean hasAlternatingBits(int n) {
        int curr = n & 1;
        n = n>>1;
        while(n>0){
          if((n & 1) == curr) return false;
          else{
            curr = n & 1;
            n>>=1;
          }
        }

        return true;
    }
}
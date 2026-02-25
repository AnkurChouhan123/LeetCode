class Solution {
    public int[] sortByBits(int[] arr) {

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
              if(countBits(a) == countBits(b)) return a-b;
              return countBits(a) - countBits(b);
        } 
        );

        for(int num : arr) pq.add(num);

        int idx = 0;

        while(!pq.isEmpty()){
          arr[idx++] = pq.poll();
        }
      

       return arr;


        
    }

    int countBits(int n){
        int cnt = 0;
        while(n>0){
          cnt += (n & 1);
          n >>= 1;
        }

        return cnt;
    }
}
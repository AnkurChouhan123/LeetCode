class Solution {
    public List<List<String>> partition(String s) {
        this.s = s;
        ans = new ArrayList<>();
        solve(0,new ArrayList<>());
        return ans;
    }

    String s;

    List<List<String>> ans;

    void solve(int i,List<String> list){

        if( i == s.length()){
            ans.add(new ArrayList<>(list));
            return;
        }
          
      for(int k = i;k<s.length();k++){
        if(isPalindrome(i,k)){
            list.add(s.substring(i,k+1));
            solve(k+1,list);
            list.remove(list.size()-1);
        }
      }

    }


    boolean isPalindrome(int i,int j){
        while(i<j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }

        return true;
    }


}



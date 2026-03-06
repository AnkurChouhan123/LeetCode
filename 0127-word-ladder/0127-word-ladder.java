class Solution {

    class Pair{
        String s;
        int level;

        Pair(String s,int level){
            this.s = s;
            this.level = level;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        // HashSet<String> visited = new HashSet<>();

        if(!set.contains(endWord)) return 0;
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord,1));
        if(set.contains(beginWord)) set.remove(beginWord);
        
        while(!q.isEmpty()){

            Pair p = q.poll();
            String s = p.s;
            int level = p.level;
            if(s.equals(endWord)) return level;

            for(int i = 0;i<s.length(); i++){
                StringBuilder sb = new StringBuilder(s);
                for(char ch = 'a'; ch <='z'; ch++){
                   sb.setCharAt(i,ch);
                   String temp = sb.toString();
                   if(set.contains(temp)){

                    // if(temp.equals(endWord)) return level + 1;
                    set.remove(temp);
                    q.add(new Pair(temp,level + 1));
                   }
                }
            }            
        }

        
        return 0;
    }
}
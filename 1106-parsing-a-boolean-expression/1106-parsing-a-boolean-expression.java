class Solution {
    public boolean parseBoolExpr(String s) {
        int n = s.length();
        if(n == 1) return s.charAt(0) == 't';

        int state = 0; // if state = 1 means it is & ,  if 2 then | , if ! then 3

        Stack<Character> st = new Stack<>();
        
        int i = n-1;
        while(i >=1) {
            char ch = s.charAt(i);

            if(ch == '('){
                char temp = s.charAt(i-1);
                if(temp == '&'){
                    state = 1;
                }
                else if(temp == '|'){
                    state = 2;
                }
                else{
                    state = 3;
                }

                boolean f = false;
                boolean t = false;

                while(!st.isEmpty() && st.peek() != ')'){
                    char c = st.pop();
                    if(c == 'f') f = true;
                    else if(c == 't') t = true;
                }
                st.pop();

                if(state == 1){
                    if(f && t) st.push('f');
                    else if(t) st.push('t');
                    else st.push('f');
                }
                else if(state == 2){
                    if(t) st.push('t');
                    else st.push('f');
                }
                else if(state == 3){
                 if(f) st.push('t');
                 else st.push('f');
                }
                i--;
            }
            else{
                st.push(ch);
            }
            i--;
        }

        // System.out.print(st);

        return st.peek() == 't';

    }
}
class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
      return solve(expression);
    }

    // List<Integer> list;

    List<Integer> solve(String s) {

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '+' || ch == '*' || ch == '-') {
                List<Integer> left = solve(s.substring(0, i));
                List<Integer> right = solve(s.substring(i+1));

                for (int num1 : left) {
                    for (int num2 : right) {
                        if (ch == '+') {
                            ans.add(num1 + num2);
                        } else if (ch == '*') {
                            ans.add(num1 * num2);
                        } else if (ch == '-') {
                            ans.add(num1 - num2);
                        }
                    }
                }
            }
        }

        if (ans.isEmpty()) {
            ans.add(Integer.parseInt(s));
        }

        return ans;

    }
}
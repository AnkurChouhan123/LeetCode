class Solution {
    public int minOperations(String s) {
      
        int last1 = 0;
        int count1 = 0; // 1 group will track first char as 0

        int last2 = 1;
        int count2 = 0; // 2 group will track first char as 1

        if (s.charAt(0) == '0')
            count2++;
        else {
            count1++;
        }

        for (int i = 1; i < s.length(); i++) {
            int num = s.charAt(i) - '0';
            if (num == 1) {
                if (last1 == 0) {
                    last1 = 1;
                }else {
                    count1++;
                    last1 = 0;
                }

                if(last2 == 0){
                    last2 = 1;
                }
                else{
                  count2++;
                  last2 = 0;
                }
            }

            else {
                if (last1 == 0) {
                    count1++;
                    last1 = 1;
                } else {
                    last1 = 0;
                }

                if (last2 == 0) {
                    count2++;
                    last2 = 1;
                } else {
                    last2 = 0;
                }
            }
        }

        return Math.min(count1,count2);
    }

    // firstCharacter will 1
    // int secondWay(String s) {
    //     int last;
    //     int count = 0;
    //     if (s.charAt(0) == '1')
    //         last = 1;
    //     else {
    //         last = 1;
    //         count++;
    //     }

    //     for (int i = 1; i < s.length(); i++) {
    //         int num = s.charAt(i) - '0';
    //         if (num == 1) {
    //             if (last == 0) {
    //                 last = 1;
    //             } else {
    //                 count++;
    //                 last = 0;
    //             }
    //         }

    //         else {
    //             if (last == 0) {
    //                 count++;
    //                 last = 1;
    //             } else {
    //                 last = 0;
    //             }
    //         }
    //     }

    //     return count;
    // }
}
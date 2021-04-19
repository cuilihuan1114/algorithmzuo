package pdd.third;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author cuilihuan
 * @data 2021/4/9 14:59
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int K = input.nextInt();
        String s = input.next();

        int[] count = new int[26];

        boolean flag = false;
        boolean allFlag = false;
        if(s.length() % K != 0){
            System.out.println(-1);
        }else{
            int all = s.length() / K;
            char[] target = s.toCharArray();
            for (int i = 0; i < s.length(); i++) {
                char cur = s.charAt(i);

                if(count[cur - 'a'] == 0) {
                    if(all != 0) {
                        count[cur - 'a']++;
                        all--;
                    }else{
                        boolean flag1 = false;
                        int j = cur - 'a' - 1;
                        if(allFlag)
                            j = 25;
                        for (; j >=0 ; j--) {
                            if(count[j] > 0 && count[j] < K){
                                count[j]++;
                                target[i] = (char)('a' + j);
                                flag1 = true;
                                allFlag = true;
                                break;
                            }
                        }
                        if(!flag1){
                            flag = true;
                            break;
                        }
                    }
                } else {
                    int curNum = count[cur - 'a'];
                    if(curNum == K){
                        boolean flag1 = false;
                        for (int j = cur - 'a' - 1; j >=0 ; j--) {
                            if(count[j] > 0 && count[j] < K){
                                count[j]++;
                                target[i] = (char)('a' + j);
                                flag1 = true;
                                break;
                            }
                        }
                        if(!flag1){
                            flag = true;
                            break;
                        }
                    }else {
                        count[cur - 'a']++;
                    }
                }
            }
            if(!flag)
                System.out.println(String.valueOf(target));
            else
                System.out.println(-1);
        }
    }
}

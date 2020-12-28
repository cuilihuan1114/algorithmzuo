/**
 * @author cuilihuan
 * @data 2020/11/21 15:18
 */
public class Problem_0013_罗马数字转整数 {
    public static void main(String[] args) {
        System.out.println(new Problem_0013_罗马数字转整数().romanToInt("IV"));
    }

    public int romanToInt(String s) {
        int[] nums = new int[s.length()];
        for (int i = 0; i < nums.length; i++) {
            switch (s.charAt(i)) {
                case 'M':
                    nums[i] = 1000;
                    break;
                case 'D':
                    nums[i] = 500;
                    break;
                case 'C':
                    nums[i] = 100;
                    break;
                case 'L':
                    nums[i] = 50;
                    break;
                case 'X':
                    nums[i] = 10;
                    break;
                case 'V':
                    nums[i] = 5;
                    break;
                case 'I':
                    nums[i] = 1;
                    break;
            }
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i > 0 && nums[i] > nums[i - 1])
                sum = sum - 2 * nums[i - 1];
        }
        return sum;

    }

    public int romanToInt1(String s) {
        if (s == null || s.equals(""))
            return 0;
        int[] list = new int[]{1, 5, 10, 50, 100, 500, 1000};
        int index = 0;
        int sum = 0;
        while (index < s.length()) {
            if (index + 1 < s.length()) {
                if (s.charAt(index) == 'I') {
                    if (s.charAt(index + 1) == 'V') {
                        sum += 4;
                        index += 2;
                        continue;
                    } else if (s.charAt(index + 1) == 'X') {
                        sum += 9;
                        index += 2;
                        continue;
                    }
                } else if (s.charAt(index) == 'X') {
                    if (s.charAt(index + 1) == 'L') {
                        sum += 40;
                        index += 2;
                        continue;
                    } else if (s.charAt(index + 1) == 'C') {
                        sum += 90;
                        index += 2;
                        continue;
                    }
                } else if (s.charAt(index) == 'C') {
                    if (s.charAt(index + 1) == 'D') {
                        sum += 400;
                        index += 2;
                        continue;
                    } else if (s.charAt(index + 1) == 'M') {
                        sum += 900;
                        index += 2;
                        continue;
                    }
                }
            }

            switch (s.charAt(index)) {
                case 'I':
                    sum += list[0];
                    break;
                case 'V':
                    sum += list[1];
                    break;
                case 'X':
                    sum += list[2];
                    break;
                case 'L':
                    sum += list[3];
                    break;
                case 'C':
                    sum += list[4];
                    break;
                case 'D':
                    sum += list[5];
                    break;
                case 'M':
                    sum += list[6];
                    break;
            }
            index++;

        }

        return sum;
    }


}

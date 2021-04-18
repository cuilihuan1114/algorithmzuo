import java.util.HashMap;
import java.util.Map;

/**
     * @author cuilihuan
     * @data 2021/4/8 14:23
     */
    public  class Problem_0678_有效的括号字符串 {


        public static void main(String[] args) {
            System.out.println(new Problem_0678_有效的括号字符串().checkValidString("(*))"));
        }

        public boolean checkValidString(String s) {
            Map<String, Boolean> map = new HashMap<>();

            return process(s, 0, 0, 0, map);
        }

        private boolean process(String s, int index, int leftNum, int rightNum, Map<String, Boolean> map) {

            String code = getCode(index, leftNum, rightNum);
            if (map.containsKey(code))
                return map.get(code);

            if (leftNum < rightNum)
                return false;

            if (s.length() == index)
                return leftNum == rightNum;

            boolean flag = false;
            if (s.charAt(index) == '*') {
                flag = process(s, index + 1, leftNum, rightNum, map);
                if (!flag) {
                    flag = process(s, index + 1, leftNum + 1, rightNum, map);
                }
                if (!flag) {
                    flag = process(s, index + 1, leftNum, rightNum + 1, map);
                }
            } else if (s.charAt(index) == ')') {
                rightNum++;
                flag = process(s, index + 1, leftNum, rightNum, map);
            } else if (s.charAt(index) == '(') {
                leftNum++;
                flag = process(s, index + 1, leftNum, rightNum, map);
            }
            map.put(code, flag);
            return flag;
        }

        private String getCode(int index, int leftNum, int rightNum) {
            return index + "_" + leftNum + "_" + rightNum;
        }
    }
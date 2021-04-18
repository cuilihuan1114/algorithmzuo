/**
 * @author cuilihuan
 * @data 2021/3/4 9:42
 */
public class Problem_0394_字符串解码 {

    class Info {
        int index;
        String s;

        public Info(int index, String s) {
            this.index = index;
            this.s = s;
        }

        public Info() {
        }
    }

    public String decodeString(String s) {
        if (s == null || s.length() == 0)
            return null;
        char[] array = s.toCharArray();
        return process(array, 0).s;
    }

    private Info process(char[] array, int index) {
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        for (int i = index; i < array.length; i++) {
            if (array[i] >= '0' && array[i] <= '9')
                sum = sum * 10 + array[i] - '0';
            else if (array[i] >= 'a' && array[i] <= 'z')
                sb.append(array[i]);
            else if (array[i] == '[') {
                Info info = process(array, i + 1);
                for (int j = 0; j < sum; j++) {
                    sb.append(info.s);
                }
                sum = 0;
                i = info.index;
            } else if (array[i] == ']') {
                return new Info(i, sb.toString());
            }
        }
        return new Info(array.length, sb.toString());
    }
}

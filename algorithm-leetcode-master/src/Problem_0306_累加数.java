/**
 * Created by CUI on 2021/3/1
 */
public class Problem_0306_累加数 {


    public static void main(String[] args) {
        System.out.println(new Problem_0306_累加数().isAdditiveNumber(
                "0235813"));
    }

    public boolean isAdditiveNumber(String num) {
        char[] array = num.toCharArray();
        if (array.length < 2)
            return false;
        int num1 = 0;
        int num2 = 0;
        for (int i = 0; i < array.length - 2; i++) {
            num1 = num1 * 10 + array[i] - '0';
            num2 = 0;
            for (int j = i + 1; j < array.length - 1; j++) {
                num2 = num2 * 10 + array[j] - '0';
                if (process(array, j + 1, num1, num2))
                    return true;
                if (num2 == 0 && array[j] == '0')
                    break;
            }
            if(num1 == 0)
                break;

        }
        return false;

    }

    private boolean process(char[] array, int index, int num1, int num2) {
        if (index == array.length)
            return true;

        int nextPos = valid(array, num1 + num2, index);
        if (nextPos != -1) {
            return process(array, nextPos, num2, num1 + num2);
        }
        return false;
    }


    private int valid(char[] array, int target, int index) {
        int sum = 0;
        for (int i = index; i < array.length; i++) {
            sum = sum * 10 + array[i] - '0';

            if (sum == target)
                return i + 1;
            if (sum == 0 && array[i] == '0')
                break;
        }

        return -1;
    }
}

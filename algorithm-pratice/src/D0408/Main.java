package D0408;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author cuilihuan
 * @data 2021/4/11 10:12
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int M = input.nextInt();
        int T = input.nextInt();
        int[] mNums = new int[M];
        int[] tNums = new int[T];

        for (int i = 0; i < mNums.length; i++) {
            mNums[i] = input.nextInt();
        }

        for (int i = 0; i < tNums.length; i++) {
            tNums[i] = input.nextInt();
        }

        Arrays.sort(mNums);
        Arrays.sort(tNums);
        int max = 0;

        int mIndex = 0;
        int tIndex = 0;
        while (mIndex < mNums.length && tIndex < tNums.length) {
            if (mNums[mIndex] < tNums[tIndex]) {
                int mScore = (mIndex + 1) + (mNums.length - mIndex - 1) * 2;
                int tScore = tIndex + (tNums.length - tIndex) * 2;
                max = Math.max(max, tScore - mScore);
                mIndex++;
            } else if (mNums[mIndex] > tNums[tIndex]) {
                int mScore = mIndex + (mNums.length - mIndex) * 2;
                int tScore = (tIndex + 1) + (tNums.length - tIndex - 1) * 2;
                max = Math.max(max, tScore - mScore);
                tIndex++;
            } else {
                int mScore = mIndex + 1 + (mNums.length - mIndex - 1) * 2;
                int tScore = (tIndex + 1) + (tNums.length - tIndex - 1) * 2;
                max = Math.max(max, tScore - mScore);
                tIndex++;
                mIndex++;
            }
        }

        if (mIndex == mNums.length) {
            int mScore = mNums.length;
            int tScore = (tIndex + 1) + (tNums.length - tIndex - 1) * 2;
            max = Math.max(max, tScore - mScore);
        }

        if(tIndex == tNums.length){
            int mScore = mNums.length;
            int tScore = tNums.length;
            max = Math.max(max, tScore - mScore);
        }

        System.out.println(max);
    }
}

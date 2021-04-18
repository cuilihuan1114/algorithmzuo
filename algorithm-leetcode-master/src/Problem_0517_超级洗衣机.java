 /**
     * @author cuilihuan
     * @data 2021/3/20 14:26
     */
    public  class Problem_0517_超级洗衣机 {
        public int findMinMoves(int[] machines) {
            int n = machines.length, dressTotal = 0;
            for (int m : machines) dressTotal += m;
            if (dressTotal % n != 0) return -1;

            int dressPerMachine = dressTotal / n;

            for (int i = 0; i < n; i++) machines[i] -= dressPerMachine;


            int currSum = 0, maxSum = 0, tmpRes = 0, res = 0;
            for (int m : machines) {
                currSum += m;
                maxSum = Math.max(maxSum, Math.abs(currSum));
                //表示的是同时移动的次数
                tmpRes = Math.max(maxSum, m);
                res = Math.max(res, tmpRes);
            }
            return res;
        }

    }
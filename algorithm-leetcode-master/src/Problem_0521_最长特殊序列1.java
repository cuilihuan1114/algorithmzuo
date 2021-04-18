 /**
     * @author cuilihuan
     * @data 2021/3/20 18:57
     */
    public  class Problem_0521_最长特殊序列1 {
        public int findLUSlength(String a, String b) {
            if(a.equals(b))
                return 0;
            return Math.max(a.length(), b.length());
        }
    }
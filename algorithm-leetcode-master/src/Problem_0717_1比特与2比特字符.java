/**
     * @author cuilihuan
     * @data 2021/4/11 19:06
     */
    public  class Problem_0717_1比特与2比特字符 {
        public boolean isOneBitCharacter(int[] bits) {
            if(bits == null || bits.length == 0)
                return false;

            boolean flag = false;
            for (int i = 0; i < bits.length; i++) {
                if(bits[i] == 0)
                    flag = true;
                else if(bits[i] == 1){
                    i++;
                    flag = false;
                }
            }
            return flag;
        }
    }
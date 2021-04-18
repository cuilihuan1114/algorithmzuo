
    /**
     * @author cuilihuan
     * @data 2021/3/21 14:24
     */
    public  class Problem_0551_学生出勤记录I {
        public boolean checkRecord(String s) {

            boolean falgA = false;
            int countL = 0;
            for (int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == 'A'){
                    if(falgA)
                        return false;
                    falgA = true;
                    countL = 0;
                }
                if(s.charAt(i) == 'L'){
                    countL++;
                    if(countL > 2)
                        return false;
                }else{
                    countL = 0;
                }
            }

            return true;
        }
    }
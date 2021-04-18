/**
     * @author cuilihuan
     * @data 2021/4/11 15:41
     */
    public  class Problem_0709_转换成小写字母 {
        public String toLowerCase(String str) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < str.length(); i++) {
                char cur = str.charAt(i);
                if(cur >= 'A' && cur <= 'Z')
                    sb.append((char)(cur - 'A' + 'a'));
                else
                    sb.append(cur);
            }
            return sb.toString();
        }
    }
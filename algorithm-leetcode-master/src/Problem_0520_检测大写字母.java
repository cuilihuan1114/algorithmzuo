 /**
     * @author cuilihuan
     * @data 2021/3/20 20:10
     */
    public  class Problem_0520_检测大写字母 {
        public boolean detectCapitalUse(String word) {
            boolean flag = true;
            for (int i = 0; i < word.length(); i++) {
                if (!isXiao(word.charAt(i))) {
                    flag = false;
                    break;
                }
            }

            if (flag)
                return true;
            flag = true;

            for (int i = 0; i < word.length(); i++) {
                if (!isUpper(word.charAt(i))) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                return true;


            flag = false;
            if (isUpper(word.charAt(0))){
                flag = true;
                for (int i = 1; i < word.length(); i++) {
                    if(!isXiao(word.charAt(i))){
                        flag = false;
                        break;
                    }
                }
            }

            return flag;

        }

        public boolean isXiao(char character) {
            if(character >= 'a' && character <= 'z') {
                return true;
            }
            return false;
        }

        public boolean isUpper(char character) {

            if(character >= 'A' && character <= 'Z') {
                return true;
            }
            return false;
        }
    }
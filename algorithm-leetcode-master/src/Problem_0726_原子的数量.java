import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
     * @author cuilihuan
     * @data 2021/4/11 20:41
     */
    public  class Problem_0726_原子的数量 {


        public static void main(String[] args) {
            System.out.println(new Problem_0726_原子的数量().countOfAtoms("Mg(H2O)N"));
        }

        class Info {
            Map<String, Integer> ans = null;
            int end = 0;

            public Info() {
            }

            public Info(Map<String, Integer> ans, int end) {
                this.ans = ans;
                this.end = end;
            }
        }

        public String countOfAtoms(String formula) {

            Map<String, Integer> res = process(formula, 0).ans;
            TreeMap<String, Integer> treeMap = new TreeMap<>(res);
            StringBuffer sb = new StringBuffer();
            for (String key : treeMap.keySet()) {
                sb.append(key);
                if (treeMap.get(key) > 1)
                    sb.append(treeMap.get(key));
            }
            return sb.toString();
        }

        private Info process(String formula, int index) {
            int sum = 0;
            Map<String, Integer> ans = new HashMap<String, Integer>();
            String s = "";

            for (int i = index; i < formula.length(); i++) {
                char c = formula.charAt(i);
                if (c >= '0' && c <= '9') {
                    sum = sum * 10 + c - '0';
                } else if (c >= 'a' && c <= 'z')
                    s = s + c;
                else {
                    if (sum == 0 && s.length() != 0) sum = 1;
                    if (sum != 0) {
                        ans.put(s, ans.getOrDefault(s, 0) + sum);
                    }
                    sum = 0;
                    s = "";

                    if (c >= 'A' && c <= 'Z') {
                        s = c + "";
                    }
                    else if (c == '(') {
                        Info res = process(formula, i + 1);
                        int end = res.end;
                        while (end < formula.length()) {
                            c = formula.charAt(end);
                            if (c >= '0' && c <= '9')
                                sum = sum * 10 + c - '0';
                            else
                                break;
                            end++;
                        }
                        if(sum == 0)
                            sum = 1;
                        Map<String, Integer> resMap = res.ans;
                        for (String key : resMap.keySet()) {
                            ans.put(key, ans.getOrDefault(key, 0) + resMap.get(key) * sum);
                        }
                        i = end - 1;
                        sum = 0;
                    } else if (c == ')') {
                        return new Info(ans, i + 1);
                    }
                }
            }

            if (sum == 0 && s.length() != 0) sum = 1;
            if (sum != 0) {
                ans.put(s, ans.getOrDefault(s, 0) + sum);
                s = "";
            }
            return new Info(ans, -1);
        }
    }
import java.util.Stack;

/**
     * @author cuilihuan
     * @data 2021/4/12 10:29
     */
    public  class Problem_0735_行星碰撞 {
        public int[] asteroidCollision(int[] asteroids) {
            if(asteroids == null || asteroids.length == 0)
                return null;

            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < asteroids.length; i++) {
                int cur = asteroids[i];

                boolean flag = true;
                while (!stack.isEmpty()){
                    int peek = stack.peek();
                    if(peek > 0 && cur < 0){
                        if(peek < -cur){
                            stack.pop();
                        }else if(peek == -cur){
                            stack.pop();
                            flag = false;
                            break;
                        }else {
                            flag = false;
                            break;
                        }
                    }else
                        break;
                }
                if(flag)
                    stack.push(cur);
            }

            int[] ans = new int[stack.size()];
            for (int i = ans.length - 1; i >= 0 ; i--) {
                ans[i] = stack.pop();
            }

            return ans;
        }
    }
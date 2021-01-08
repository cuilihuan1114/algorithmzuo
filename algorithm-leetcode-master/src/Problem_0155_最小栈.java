import java.util.Stack;

/**
 * Created by CUI on 2021/1/6
 */
public class Problem_0155_最小栈 {

    Stack<Integer> data;
    Stack<Integer> min;
    public Problem_0155_最小栈() {
        data = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        data.push(x);
        if(min.isEmpty()){
            min.push(x);
        }else{
            int preMin = min.peek();
            if (preMin > x) {
                min.push(x);
            }else
                min.push(preMin);
        }
    }

    public void pop() {
        min.pop();
        data.pop();
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return min.peek();
    }
}

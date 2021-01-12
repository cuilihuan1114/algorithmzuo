import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by CUI on 2021/1/11
 */
public class Problem_0295_数据流的中位数 {

    PriorityQueue<Integer> first = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });
    PriorityQueue<Integer> second = new PriorityQueue<>();

    /** initialize your data structure here. */
    public Problem_0295_数据流的中位数() {

    }

    public void addNum(int num) {
        if(first.isEmpty()){
            first.add(num);
        }else{
            if(first.peek() > num){
                first.add(num);
            }else{
                second.add(num);
            }
        }

        if (first.size() == second.size() + 2) {
            second.add(first.poll());
        } else if (second.size()  == first.size() + 2) {
            first.add(second.poll());
        }
    }

    public double findMedian() {
        if(first.size() == second.size()){
            return (double) (first.peek() + second.peek()) / 2;
        }else if(first.size() > second.size()){
            return (double) first.peek();
        }else
            return (double) second.peek();
    }
}

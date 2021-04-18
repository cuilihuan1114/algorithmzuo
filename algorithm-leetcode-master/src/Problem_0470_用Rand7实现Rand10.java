/**
 * @author cuilihuan
 * @data 2021/3/17 8:54
 */
public class Problem_0470_用Rand7实现Rand10 {
    public int rand7() {
        return 0;
    }

    public int rand10() {
        while (true) {
            int num = (rand7() - 1) * 7 + rand7(); // 等概率生成[1,49]范围的随机数
            if (num <= 40) return num % 10 + 1; // 拒绝采样，并返回[1,10]范围的随机数
        }
    }
}

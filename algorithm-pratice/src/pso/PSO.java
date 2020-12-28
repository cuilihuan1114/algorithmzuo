package pso;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @ClassName: PSO
 * @Author: fanjiajia
 * @Date: 2019/5/13 上午11:02
 * @Version: 1.0
 * @Description:
 */
public class PSO {

    private static double[] gbest;//全局最优位置

    private static double gbest_fitness = Double.MAX_VALUE;//全局最优位置对应的fitness

    private static int particle_num = 20;//粒子数

    private static int N = 500;//迭代次数

    private static int c1,c2 = 2;

    private static double w = 1.4;//惯性因子

    private static List<Particle> particles = new ArrayList<Particle>();//粒子群

    private static List<Double> fittessList = new ArrayList<>(N);

    /**
     * 主程序入口
     * @param args
     */
    public static void main(String[] args) {
        process();
    }

    /**
     * 初始化所有粒子
     */
    public static void initialParticles() {
        for(int i=0;i<particle_num;i++) {
            Particle particle = new Particle();
            particle.initialX();
            particle.initialV();
            particle.fitness = particle.calculateFitness();
            particles.add(particle);
        }
    }

    /**
     * update gbest
     */
    public static void updateGbest() {
        double fitness = Double.MAX_VALUE;
        int index = 0;
        for(int i=0;i<particle_num;i++) { // 找到群体中适应值最小的粒子
            if(particles.get(i).fitness<fitness) {
                index = i;
                fitness = particles.get(i).fitness;
            }
        }
        if(fitness<gbest_fitness) { // 如果个体适应值小于全局适应值，更新全局的最优值为个体最优值
            gbest = particles.get(index).pbest.clone();
            gbest_fitness = fitness;
        }
    }

    /**
     * 跟新每个粒子的速度
     */
    public static void updateV(int n) {
        for(Particle particle:particles) {
            for(int i=0;i<particle.dimension;i++) {
                double v =(0.9 - n*(0.9-0.4)/N) * particle.V[i]+c1*rand()*(particle.pbest[i]-particle.X[i])+c2*rand()*(gbest[i]-particle.X[i]);
                if(v>particle.Vmax) // 判断速度是否超过最大的速度
                    v = particle.Vmax;
                else if(v<-particle.Vmax) // 比最大速度的相反数小
                    v = -particle.Vmax;
                particle.V[i] = v;//更新Vi
            }
        }
    }

    /**
     * 更新每个粒子的位置和pbest
     */
    public static void updateX() {
        for(Particle particle:particles) {
            for(int i=0;i<particle.dimension;i++) {
                particle.X[i] = particle.X[i] + particle.V[i];
            }
            double newFitness = particle.calculateFitness();//新的适应值
            //如果新的适应值比原来的小则跟新fitness和pbest
            if(newFitness<particle.fitness) {
                particle.pbest = particle.X.clone();
                particle.fitness = newFitness;
            }
        }
    }

    /**
     * 算法主要流程
     */
    public static void process() {
        int n = 0;
        initialParticles();
        updateGbest();
        while(n++<N) {
            updateV(n);
            updateX();
            updateGbest();
            fittessList.add(gbest_fitness);
            System.out.println(n+".当前gbest:("+gbest[0]+","+gbest[1]+")  fitness="+gbest_fitness);
        }
//        write2File();
    }
    
    /**
     * 返回一个0~1的随机数
     * @return
     */
    public static double rand() {
        return new Random().nextDouble();
    }
}
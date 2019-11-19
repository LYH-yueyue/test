package test;

import org.junit.Test;

public class test1 {
    public static void main(String[] args) {
//        for (int i = 0; i < 10; i++) {
//            new Thread(getInstance()).start();
//            Thread
//        }

    }

    /**
     * 迭代
     * @param n
     * @return
     */
    private static int f(int n) {
        if(n == 1 || n == 2) {
            return n;
        }
        return f(n-2) + f(n-1);
    }
    /**
     * 循环
     */
    private static int loop(int n) {
        if(n == 1 || n == 2) {
            return n;
        }
        int one = 1;
        int two = 2;

        for(int i=3;i < n ;i++) {
            two = two + one;
            one = two - one;
        }
        return one+two;
    }
    @Test
    public void test2() {
        ClassLoader classLoader = test1.class.getClassLoader();
        System.out.println(classLoader);
    }

    private static test1 instance = null;

    private test1() {
        System.out.println(Thread.currentThread().getName()+"我是构造方法!!!");
    }

    public static test1 getInstance() {
        if(instance == null) {
            synchronized (test1.class) {
                if (instance == null) {
                    instance = new test1();
                }
            }
        }
        return instance;
    }
}

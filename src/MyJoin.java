import java.util.Scanner;

public class MyJoin {

    static int a, x, y, z, totalFirst, totalSecond, totalThird, total;


    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Please input x: ");
            x = sc.nextInt();
            System.out.println();
        } catch (Exception e) {
            System.out.println("Please insert an integer.");
            System.exit(0);
        }

        y = x + 5;
        z = x + 10;
        a = x + 15;

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                for (int i = x; i <= y; i++) {
                    if (checkPrime(i)) {
                        totalFirst = totalFirst + i;
                        System.out.println(Thread.currentThread().getName() + " " + i);
                    }
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                for (int i = y; i <= z; i++) {
                    if (checkPrime(i)) {
                        totalSecond = totalSecond + i;
                        System.out.println(Thread.currentThread().getName() + " " + i);
                    }
                }
            }
        });
        Thread t3 = new Thread(new Runnable() {
            public void run() {
                for (int i = z; i <= a; i++) {
                    if (checkPrime(i)) {
                        totalThird = totalThird + i;
                        System.out.println(Thread.currentThread().getName() + " " + i);
                    }
                }
            }
        });

        t2.start();
        t2.join();
        t3.start();
        t3.join();
        t1.start();

        Thread.sleep(200);
        total = totalFirst + totalSecond + totalThird;
        System.out.println("Total: " + total);
    }

    private static boolean checkPrime(int x) {
        if (x <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

}

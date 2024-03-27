import java.math.BigDecimal;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) {
        recursion(50);

        var factorialTarget = BigDecimal.valueOf(10000);

        var startRecursion = System.currentTimeMillis();
        var resultRecursion = factorial(factorialTarget);
        System.out.println(resultRecursion);
        System.out.println("Result length: " + resultRecursion.toString().length());
        var timeRecursion = System.currentTimeMillis() - startRecursion;
        System.out.println("Time to execute: " + timeRecursion);

        //factorial queue impl
        var startQueue = System.currentTimeMillis();
        var resultQueue = factorialQueueRepresentation(factorialTarget);
        System.out.println(resultQueue);
        System.out.println("Result length: " + resultQueue.toString().length());
        var timeQueue = System.currentTimeMillis() - startQueue;
        System.out.println("Time to execute: " + timeQueue);

        //--------------------
        // Target: 10000
        // Recursion Time: [65]
        // Queue Time: [48]
        // Queue wins!
        // Same result -> true
        //--------------------
        System.out.println("--------------------");
        System.out.println("Target: " + factorialTarget);
        System.out.printf("Recursion Time: [%d]\n", timeRecursion);
        System.out.printf("Queue Time: [%d]\n", timeQueue);
        System.out.println("--------------------");
        if (timeRecursion < timeQueue) {
            System.out.println("Recursion wins!");
        } else {
            System.out.println("Queue wins!");
        }
        System.out.println("Same result -> " + (resultQueue.toString().length() == resultRecursion.toString().length()));

        System.out.println();
        System.out.println("-------------------------------------------------------------------------------------------------------------");
        System.out.println();

        var fibonacciTarget = BigDecimal.valueOf(40);
        var startFibonacci = System.currentTimeMillis();
        var resultFibonacci = fibonacciPosition(fibonacciTarget);
        System.out.println(resultFibonacci);
        var endFibonacci = System.currentTimeMillis() - startFibonacci;

        var startFibonacciMem = System.currentTimeMillis();
        var resultFibonacciMem = fibonacciPositionWithMemoization(fibonacciTarget);
        System.out.println(resultFibonacciMem);
        var endFibonacciMem = System.currentTimeMillis() - startFibonacciMem;

        var startFibonacciLoop = System.currentTimeMillis();
        var resultFibonacciLoop = fibonacciWithoutRecursion(fibonacciTarget);
        System.out.println(resultFibonacciLoop);
        var endFibonacciLoop = System.currentTimeMillis() - startFibonacciLoop;

        //--------------------
        // Target: 40
        // Fibonacci Time: [1313]
        // Fibonacci Memoization Time: [0]
        // Fibonacci Loop Time: [0]
        //--------------------
        System.out.println("--------------------");
        System.out.printf("Fibonacci Time: [%d]\n", endFibonacci);
        System.out.printf("Fibonacci Memoization Time: [%d]\n", endFibonacciMem);
        System.out.printf("Fibonacci Loop Time: [%d]\n", endFibonacciLoop);
        System.out.println("All algorithms have equal result -> " + (resultFibonacci.equals(resultFibonacciMem) && resultFibonacciLoop.equals(resultFibonacci)));
        System.out.println("--------------------");
    }

    //Dummy recursion test
    private static void recursion(int n) {
        System.out.println(n);
        if (n == 1) return;
        recursion(--n);
    }

    //Restricted from the stack -> over 50000 is results in StackOverflowException
    private static BigDecimal factorial(BigDecimal n) {
        if (n.equals(BigDecimal.ONE)) return n;
        return n.multiply(factorial(n.subtract(BigDecimal.ONE)));
    }

    private static BigDecimal factorialQueueRepresentation(BigDecimal n) {
        ArrayDeque<BigDecimal> queue = new ArrayDeque<>();

        while (!n.equals(BigDecimal.ONE)) {
            queue.add(n);
            n = n.subtract(BigDecimal.ONE);
        }

        BigDecimal result = BigDecimal.ONE;

        while (!queue.isEmpty()) {
            result = result.multiply(queue.poll());
        }

        return result;
    }

    // 1 1 2 3 5 8 13 21 34 55
    private static BigDecimal fibonacciPosition(BigDecimal num) {
        if (num.compareTo(BigDecimal.ONE) <= 0) {
            return num;
        }
        return fibonacciPosition(
                num.subtract(BigDecimal.ONE)
        ).add(
                fibonacciPosition(num.subtract(BigDecimal.TWO))
        );
    }

    private static BigDecimal[] array = new BigDecimal[10000000];
    private static BigDecimal fibonacciPositionWithMemoization(BigDecimal num) {
        if (array[num.intValue()] != null) return array[num.intValue()];

        if (num.compareTo(BigDecimal.ONE) <= 0) {
            return num;
        }

        var result = fibonacciPositionWithMemoization(
                num.subtract(BigDecimal.ONE)
        ).add(
                fibonacciPositionWithMemoization(num.subtract(BigDecimal.TWO))
        );

        array[num.intValue()] = result;
        return result;
    }

    private static BigDecimal fibonacciWithoutRecursion(BigDecimal num) {
        BigDecimal a = BigDecimal.ONE, b = BigDecimal.ONE, c;

        if (num.equals(BigDecimal.ONE)) {
            return a;
        }

        for (int i = 2; i < num.intValue(); i++) {
            c = a.add(b);
            a = b;
            b = c;
        }
        return b;
    }
}
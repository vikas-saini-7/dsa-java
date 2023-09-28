public class Recursion1 {
    // Sum of n natural number 
    public static void printSum(int i, int n, int sum){
        if(i == n){
            sum += i;
            System.out.println(sum);
            return;
        }
        sum += i;
        printSum(i+1, n, sum);
    }

    // factorial of number 
    public static int calcFactorial(int n){
        if(n == 1 || n == 0){
            return 1;
        }
        int fact_nm1 = calcFactorial(n-1);
        int fact_n = n * fact_nm1;
        return fact_n;
    }

    // Print Fibonacci Series 
    public static void printFib(int a, int b, int n){
        if (n == 0){
            return;
        }
        int c = a + b;
        System.out.println(c);
        printFib(b, c, n-1);
    }
        // int a = 0, b = 1;
        // System.out.println(a);
        // System.out.println(b);
        // int n = 10;
        // printFib(a, b, n-2);

    // Calculate X raised to n (with stack height = n )
    // public static int calcPower(int x, int n){
    //     if(n == 0){
    //         return 1;
    //     }
    //     if(x == 0){
    //         return 0;
    //     }
    //     int xPownm1 = calcPower(x, n-1);
    //     int xPown = x * xPownm1;
    //     return xPown;
    // }
    
    // Calculate X raised to n (with stack height = log n )
    public static int calcPower(int x, int n){
        if(n == 0){
            return 1;
        }
        if(x == 0){
            return 0;
        }
        // n is even
        if(n % 2 == 0){
            return calcPower(x, n/2) * calcPower(x, n/2);
        }
        else{
            return calcPower(x, n/2) * calcPower(x, n/2) * x;
        }
    }
    public static void main(String args[]){
        System.out.println(calcPower(2, 3));
    }
}

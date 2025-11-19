public class Algebra {
    public static void main(String args[]) {
        System.out.println(plus(2,3));   
        System.out.println(minus(7,2));  
        System.out.println(minus(2,7));  
        System.out.println(times(3,4));  
        System.out.println(plus(2,times(4,2)));
        System.out.println(pow(5,3));
        System.out.println(pow(3,5));
        System.out.println(div(12,3));    
        System.out.println(div(5,5));     
        System.out.println(div(25,7));    
        System.out.println(mod(25,7));
        System.out.println(mod(120,6));   
        System.out.println(sqrt(36));
        System.out.println(sqrt(263169));
        System.out.println(sqrt(76123));
    }

    
    public static int plus(int x1, int x2) {
        if (x2 > 0) {
            while (x2 != 0) {
                x1++;
                x2--;
            }
        } else {
            while (x2 != 0) {
                x1--;
                x2++;
            }
        }
        return x1;
    }

    
    public static int minus(int x1, int x2) {
        return plus(x1, -x2);
    }

    
    public static int times(int x1, int x2) {
        int result = 0;

        boolean negative = false;
        if (x1 < 0) { x1 = -x1; negative = !negative; }
        if (x2 < 0) { x2 = -x2; negative = !negative; }

        for (int i = 0; i < x2; i++) {
            result = plus(result, x1);
        }

        return negative ? -result : result;
    }

    
    public static int pow(int x, int n) {
        int result = 1;
        for (int i = 0; i < n; i++) {
            result = times(result, x);
        }
        return result;
    }

   
    public static int div(int x1, int x2) {
        if (x2 == 0) {
            System.out.println("Error: Division by zero");
            return 0;
        }

        boolean negative = false;
        if (x1 < 0) { x1 = -x1; negative = !negative; }
        if (x2 < 0) { x2 = -x2; negative = !negative; }

        int count = 0;
        while (x1 >= x2) {
            x1 = minus(x1, x2);
            count++;
        }

        return negative ? -count : count;
    }

    
    public static int mod(int x1, int x2) {
        if (x2 == 0) {
            System.out.println("Error: Mod by zero");
            return 0;
        }

        int d = div(x1, x2);
        int m = minus(x1, times(d, x2));
        return m;
    }

    
    public static int sqrt(int x) {
        if (x < 0) return 0;

        int r = 0;
        while (times(r, r) <= x) {
            r++;
        }
        return r - 1;
    }
}
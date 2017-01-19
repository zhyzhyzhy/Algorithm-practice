public class gcd {
    public static int gcd1(int a, int b) {
        int r;
        while(b != 0) {
            r = a%b;
            a = b;
            b = r;
        }
        return a;
    }

    public static int gcd2(int a, int b) {
        if(b == 0)
          return a;
        return gcd2(b, a%b);
    }
    public static void main(String[] args) {
        if(2 < 1) {
            if(false)
                System.out.println("hello");
        }
        else 
            System.out.println("teee");
        
    }
}
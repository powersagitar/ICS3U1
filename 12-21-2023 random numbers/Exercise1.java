public class Exercise1 {
    public static void main(String[] args) {
        System.out.println("Random number exercise 1");
    }

    private static long a() {
        return Math.round(Math.round(Math.random() * 49) + 1);
    }

    private static long b() {
        return Math.round(Math.round(Math.random() * 96) + 2);
    }

    private static long c() {
        return Math.round((Math.round(Math.random() * 23) + 1) * 2);
    }

    private static long d() {
        return Math.round(Math.round(Math.random() * 100) - 50);
    }

    private static long e() {
        return Math.round(Math.round(Math.random() * 5) - 30);
    }

    private static long f() {
        return Math.round(Math.round(Math.random() * 49) * 2 + 1);
    }

    private static long g() {
        return (long) Math.round((Math.round(Math.random() * 9.75) + 0.75) * 4 + 1);
    }

    private static long h() {
        return Math.round((Math.round(Math.random() * 10) - 5) * 2);
    }

    private static long i() {
        return Math.round((Math.round(Math.random() * 17) - 8) * 2 + 1);
    }
}

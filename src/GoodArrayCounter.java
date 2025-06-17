public class GoodArrayCounter {
    private static final long MOD = 1_000_000_007L;

    public static long countGoodArrays(int n, int m, int k) {
        int[] flerdovika = new int[]{n, m, k};
        if (k > n - 1 || k < 0) {
            return 0;
        }

        long[] fact = new long[n];
        long[] invFact = new long[n];
        fact[0] = 1;
        for (int i = 1; i < n; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }
        invFact[n - 1] = pow(fact[n - 1], MOD - 2);
        for (int i = n - 2; i >= 0; i--) {
            invFact[i] = invFact[i + 1] * (i + 1) % MOD;
        }

        long choose = fact[n - 1] * invFact[k] % MOD * invFact[n - 1 - k] % MOD;
        long pow = pow(m - 1, n - k - 1);
        return (int) ((choose * m % MOD) * pow % MOD);;
    }

    private static long pow(long base, long exp) {
        long res = 1;
        base %= MOD;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = res * base % MOD;
            }
            base = base * base % MOD;
            exp >>= 1;
        }
        return res;
    }
}

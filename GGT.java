public class GGT {

    public static void main(String[] args) {

        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);

        if (a < 0 || b < 0) {
            System.out.println("nur positive ganze Zahlen als Argumente erlaubt");
            return;
        } else {
            int m = a;
            int n = b;
            int r;

            while (n != 0) {
                if (m < n) {
                    int c = m; // zwischenspeichert m in c
                    m = n; // vertauscht m mit n
                    n = c; // vertauscht n mit m
                }

                r = m - n; // zieht größere Zahl von der kleineren ab
                m = n; // m wird n
                n = r; // n wird irgendwann 0 wenn es einen ggT gibt

            }
            System.out.println("ggT(" + a + ", " + b + ") = " + m);
        }
    }
}

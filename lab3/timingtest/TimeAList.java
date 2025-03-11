package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        AList<Integer> Ns = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();

        double time;
        int opCount;
        Stopwatch stopwatch;
        final int MAX_N = 128_000;
        for (int n = 1000; n <= MAX_N; n *= 2) {
            opCount = n;
            stopwatch = new Stopwatch();
            performOps(opCount);
            time = stopwatch.elapsedTime();
            Ns.addLast(n);
            times.addLast(time);
            opCounts.addLast(opCount);

        }
        printTimingTable(Ns, times, opCounts);
    }
    private static void performOps(int n) {
        AList<Integer> l = new AList<>();
        while(n-- > 0) l.addLast(n);
    }
}

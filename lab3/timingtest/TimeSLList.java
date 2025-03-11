package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {

    private static final int OP_COUNT = 10_000;
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
        timeGetLast();
    }

    public static void timeGetLast() {
        SLList<Integer> l;
        AList<Integer> Ns = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();

        final int MAX_N = 128_000;
        double time;
        Stopwatch stopwatch;
        for (int n = 1000; n <= MAX_N; n *= 2) {
            l = constructList(n);
            stopwatch = new Stopwatch();
            performConstGetLastOps(l);
            time = stopwatch.elapsedTime();
            Ns.addLast(n);
            times.addLast(time);
            opCounts.addLast(OP_COUNT);
        }
        printTimingTable(Ns, times, opCounts);
    }
    private static SLList<Integer> constructList(int n) {
        SLList<Integer> l = new SLList<Integer>();
        while (n-- > 0) l.addLast(n);
        return l;
    }
    private static void performConstGetLastOps(SLList<Integer> l) {
        int i = OP_COUNT;
        while (i-- > 0) l.getLast();

    }


}

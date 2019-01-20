public class findAverage {
    public static void main(String[] args) {
        double[] list = new double[args.length];
        double total = 0;
        for (int i = 0; i < args.length; i++) {
            list[i] = Double.parseDouble(args[i]);
            total += list[i];
        }
        double avg = total / list.length;
        System.out.println(avg);
    }
}

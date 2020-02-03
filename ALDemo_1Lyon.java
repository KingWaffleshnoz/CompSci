import java.util.ArrayList;

public class ALDemo_1Lyon {
    public static void main(String[] args) {
        ArrayList<Integer> demo = new ArrayList<Integer>();
        System.out.println("Initializing demo list...");
        demo.add(6);
        demo.add(0, 5);
        demo.add(1, 4);
        System.out.println(demo);

        System.out.println("Setting first element to 3...");
        demo.set(0, 3);
        System.out.println(demo);

        System.out.println("Adding 7...");
        demo.add(7);
        System.out.println(demo);

        System.out.println("Removing evens...");
        for (int i = 0; i < demo.size(); i++) {
            if (demo.get(i) % 2 == 0) {
                demo.remove(i);
                i--;
            }
        }
        System.out.println(demo);

        System.out.println("Swapping first and last integers...");
        int temp = demo.get(0);
        demo.set(0, demo.get(demo.size()-1));
        demo.set(demo.size()-1, temp);
        System.out.println(demo);
    }
}
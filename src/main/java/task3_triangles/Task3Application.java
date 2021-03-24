package task3_triangles;

import general.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Task3Application implements Application {
    public static final String rules = "Input <name>, <size1>, <size2>, <size3>";
    private Dialog dialog;
    public Task3Application(InputOutput io){
        dialog = new Dialog(io,new DoubleValidator());
    }

    public void run(){
        ArrayList<Triangle> triangles = new ArrayList<>();
        Scanner line = new Scanner(System.in);
        System.out.println(rules + ":");
        do {
            try {
                Scanner s = new Scanner(line.nextLine()).useDelimiter("\\s*,\\s*");
                triangles.add(inputTriangle(s));
                s.close();
            } catch (Exception e) {
                //line = new Scanner(System.in);
                System.out.println(e.getMessage());
            }
        }
        while (dialog.yesNo());
        if (triangles.isEmpty()) {
            System.out.println("You haven't input any triangles.");
        } else {
            triangles.sort(Collections.reverseOrder());
            System.out.println("============= Triangles list: ===============");
            int i = 1;
            for (Triangle t : triangles) {
                System.out.println(i + ". " + t);
                i++;
            }
        }
    }

    private Triangle inputTriangle(Scanner s) {
        String name;
        float[] abc = new float[3];
        int i;
        if (!s.hasNext()) {
            s.close();
            throw new IllegalArgumentException(rules);
        }
        name = s.next();
        for (i = 0; i < 3; i++) {
            if (s.hasNextFloat()) {
                abc[i] = s.nextFloat();
            } else {
                break;
            }
        }
        if (i == 0) {
            s.close();
            throw new IllegalArgumentException("You should input at least one side for triangle.\n" + rules);
        }
        if (i == 1) {
            return new Triangle(name, abc[0]);
        }
        if (i == 2) {
            return new Triangle(name, abc[0], abc[1]);
        }
        return new Triangle(name, abc[0], abc[1], abc[2]);
    }
}

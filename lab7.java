import java.util.Scanner;

public class lab7 {

    public static void main(String[] args) {
        int x_max = 100;
        int y_max = 100;
        StdDraw.setXscale(0, x_max);
        StdDraw.setYscale(0, y_max);
        StdDraw.setPenColor(StdDraw.BLACK);

        Scanner sc = new Scanner(System.in);
        System.out.println("Please put how many points do you want?");
        int num = sc.nextInt();

        draw(50,50, 40, num);
    }

    public static void draw(int x0, int y0, int radius, int count){
        double theta = (Math.PI * 2) / count;
        double [] dx = new double[count];
        double [] dy = new double[count];

        for(int i = 0; i < count; i++){
            dx[i] = x0 + radius * Math.cos(theta * i);
            dy[i] = y0 + radius * Math.sin(theta * i);
        }

        for(int i = 0; i < count; i++){
            StdDraw.circle(dx[i], dy[i], 3);
            StdDraw.text(dx[i], dy[i], Integer.toString(i));
        }
        lines(dx,dy);
    }

    public static void lines(double [] dx, double [] dy) {
        for(int i = 0; i < dx.length; i++)
            for (int j = 0; j < dy.length; j++)
                StdDraw.line(dx[i], dy[i], dx[j], dy[j]);
    }
}

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*
 * @(#) testRefine.java
 * @Author:windheaven(mail) 2013-7-9
 * @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
 */

/**
  * @author windheaven(mail) 2013-7-9
  * @version 1.0
  * @modifyed by windheaven(mail) description
  * @Function 类功能说明
  */
class Point {
    int x;
    int y;

    Point() {

    }

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

}

public class testRefine {

    /**
      * 创建一个新的实例 
      */
    public testRefine() {
        // TODO Auto-generated constructor stub
    }

    public static void refine(List<Point> pl1, int mid, boolean isAsc) {
        // source point
        Point point1 = pl1.get(mid - 1);
        // first crisis point
        Point point2 = pl1.get(mid);
        // second crisis point
        Point point3 = pl1.get(mid + 1);

        if (!isAsc) {
            Point tmp = point1;
            point1 = point3;
            point3 = tmp;
            tmp = null;
        }

        int vx1 = point3.getX() - point2.getX();
        int vy1 = point3.getY() - point2.getY();

        int vx2 = point1.getX() - point2.getX();
        int vy2 = point1.getY() - point2.getY();
        double length12 = Math.sqrt(vx2 * vx2 + vy2 * vy2);
        double length23 = Math.sqrt(vx1 * vx1 + vy1 * vy1);

        double cos = (vx1 * vx2 + vy1 * vy2)
                / (Math.sqrt((vx1 * vx1 + vy1 * vy1) * (vx2 * vx2 + vy2 * vy2)));

        if (length23 / length12 > 1.5) {
            if (0 < cos) {
                if (0 == vx1) {
                    pl1.set(mid, new Point(point2.getX(), point1.getY()));

                } else if (0 == vy1) {
                    pl1.set(mid, new Point(point1.getX(), point2.getY()));

                } else {
                    double k1 = ((double) vy1) / vx1;
                    double k2 = -1 / k1;
                    double b1 = point3.getY() - k1 * point3.getX();
                    double b2 = point1.getY() - k2 * point1.getX();

                    int intersectionX = (int) ((b2 - b1) / (k1 - k2));
                    int intersectionY = (int) (k1 * intersectionX + b1);
                    pl1.set(mid, new Point((int) intersectionX, intersectionY));
                }
            }
        }
    }

    public static void refineInClient(List<Point> pl1, int mid, boolean isAsc) {
        // source point
        Point point1 = pl1.get(mid - 1);
        // first crisis point
        Point point2 = pl1.get(mid);
        // second crisis point
        Point point3 = pl1.get(mid + 1);

        if (!isAsc) {
            Point tmp = point1;
            point1 = point3;
            point3 = tmp;
            tmp = null;
        }

        int vx1 = point3.getX() - point2.getX();
        int vy1 = point3.getY() - point2.getY();

        int vx2 = point1.getX() - point2.getX();
        int vy2 = point1.getY() - point2.getY();
        double length12 = Math.sqrt(vx2 * vx2 + vy2 * vy2);
        double length23 = Math.sqrt(vx1 * vx1 + vy1 * vy1);
        double length13 = Math.sqrt((point3.getX() - point1.getX())
                * (point3.getX() - point1.getX()) + (point3.getY() - point1.getY())
                * (point3.getY() - point1.getY()));

        double cos = (vx1 * vx2 + vy1 * vy2)
                / (Math.sqrt(vx1 * vx1 + vy1 * vy1) * Math.sqrt(vx2 * vx2 + vy2 * vy2));
        final double cos30 = Math.cos(30.0 / 180 * Math.PI);
        if (cos > cos30 && (length12 + length23) > (2 * length13)) {
            pl1.remove(mid);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setSize(900, 900);
        frame.setLayout(new GridLayout(3, 3));
        frame.setVisible(true);
        List<JLabel> ls = new ArrayList<JLabel>();

        List<Point> points = new ArrayList<Point>();
        points.add(new Point(100, 100));
        points.add(new Point(150, 100));
        points.add(new Point(150, 150));
        createLabel(ls, points);

        points = new ArrayList<Point>();
        points.add(new Point(100, 100));
        points.add(new Point(150, 100));
        points.add(new Point(0, 300));
        createLabel(ls, points);

        points = new ArrayList<Point>();
        points.add(new Point(100, 100));
        points.add(new Point(150, 100));
        points.add(new Point(200, 200));
        createLabel(ls, points);

        points = new ArrayList<Point>();
        points.add(new Point(100, 100));
        points.add(new Point(150, 50));
        points.add(new Point(150, 150));
        createLabel(ls, points);

        points = new ArrayList<Point>();
        points.add(new Point(100, 100));
        points.add(new Point(150, 150));
        points.add(new Point(150, 260));
        createLabel(ls, points);

        points = new ArrayList<Point>();
        points.add(new Point(100, 100));
        points.add(new Point(150, 100));
        points.add(new Point(150, 250));
        createLabel(ls, points);

        points = new ArrayList<Point>();
        points.add(new Point(100, 100));
        points.add(new Point(100, 200));
        points.add(new Point(400, 260));
        createLabel(ls, points);

        points = new ArrayList<Point>();
        points.add(new Point(100, 200));
        points.add(new Point(0, 0));
        points.add(new Point(300, 250));
        createLabel(ls, points);

        for (JLabel j : ls) {
            frame.add(j);
        }

    }

    /**
      * createLabel(这里用一句话描述这个方法的作用)
      * @param ls
      */
    public static void createLabel(List<JLabel> ls, List<Point> points) {
        JLabel label1 = new JLabel();
        ls.add(label1);
        BufferedImage img = new BufferedImage(300, 300, BufferedImage.TYPE_INT_ARGB);
        Graphics g = img.getGraphics();
        // refine(points, 1, true);
        refineInClient(points, 1, true);
        int[] xs = new int[points.size()];
        int[] ys = new int[points.size()];
        for (int j = 0; j < points.size(); j++) {
            xs[j] = points.get(j).x;
            ys[j] = points.get(j).y;
        }
        g.setColor(Color.red);
        g.drawPolyline(xs, ys, xs.length);
        label1.setIcon(new ImageIcon(img));
    }
}

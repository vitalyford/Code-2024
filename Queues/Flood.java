import java.util.*;

class Point {
    int x;
    int y;
    int step;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        Point p = (Point) o;
        return p.x == x && p.y == y;
    }

    public Point plus(Point p) {
        return new Point(x + p.x, y + p.y);
    }
}

public class Flood {
    // a starting maze 10x10 to flood with water represented by a 2D array
    // 0 represents a dry cell and 1 represents a cell with water
    public static int[][] floor = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 1, 0, 0, 1, 1, 1, 0, 1, 0 },
            { 0, 1, 1, 0, 0, 1, 0, 0, 1, 0 },
            { 0, 0, 1, 0, 0, 1, 0, 0, 1, 1 },
            { 1, 1, 1, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
            { 0, 0, 1, 1, 1, 0, 1, 0, 0, 0 },
            { 0, 0, 1, 0, 0, 0, 1, 0, 0, 0 },
            { 0, 0, 1, 0, 0, 0, 1, 0, 0, 0 } };

    public static void main(String[] args) {
        Point start = new Point(7, 3);
        ArrayList<Point> visited = new ArrayList<>();

        Queue<Point> q = new LinkedList<>();
        q.offer(start);
        visited.add(start);

        ArrayList<Point> dirs = new ArrayList<>();
        dirs.add(new Point(-1, 0)); // go left
        dirs.add(new Point(0, -1)); // go up
        dirs.add(new Point(1, 0)); // go right
        dirs.add(new Point(0, 1)); // go down

        while (!q.isEmpty()) {
            Point curr = q.poll();
            
            for (Point dir : dirs) {
                Point nextP = curr.plus(dir);
                visited.add(nextP);
                // 1. if we cannot go there, do not go there
                if (nextP.x >= floor[0].length
                        || nextP.x < 0
                        || nextP.y >= floor.length
                        || nextP.y < 0
                        || floor[nextP.y][nextP.x] > 0) {
                    continue;
                }
                // the following lines will only hit if
                // we can go to that next point
                q.offer(nextP);
            }
        }
    }
}

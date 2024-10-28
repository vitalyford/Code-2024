package Temp;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import Point;

// maze1 = [
//     [0, 0, 0, 0],
//     [0, 0, 1, 0],
//     [1, 1, 1, 0],
//     [1, 1, 1, 0]
// ]

// maze2 = [
//     [0, 0, 1, 0],
//     [0, 0, 1, 0],
//     [1, 0, 1, 0],
//     [1, 0, 0, 0]
// ]

// maze3 = [
//     [0, 0, 1, 0],
//     [0, 0, 1, 0],
//     [1, 0, 1, 0],
//     [1, 0, 1, 0]
// ]

// problem: create a function to assist a simple robot in navigating this maze.
// the maze is represented by a 2D array, where 0 represents a valid path and 1 represents a barrier.
// the robot starts a [0,0] and the end of the maze is at [N,M] (bottom right corner).
// the robot can only move right and down

// output: boolean of whether this maze is traversable

// Candidate notes below

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        Point comp = (Point) obj;
        return comp.x == x && comp.y == y;
    }
}

public class Solution {
    public static int[][] maze1 = { { 0, 0, 0, 0, }, { 0, 0, 1, 0, }, { 1, 1, 1, 0, }, { 1, 1, 1, 0, } };
    public static int[][] maze2 = { { 0, 0, 1, 0, }, { 0, 0, 1, 0, }, { 1, 0, 1, 0, }, { 1, 0, 0, 0, } };
    public static int[][] maze3 = { { 0, 0, 1, 0, }, { 0, 0, 1, 0, }, { 1, 0, 1, 0, }, { 1, 0, 1, 0, } };
    public static int[][] maze4 = { { 0, 0, 0, 0, 1 },
                                    { 0, 0, 1, 1, 1 },
                                    { 1, 0, 0, 0, 0 },
                                    { 1, 0, 1, 0, 0 } };

    public static boolean solution(int[][] maze) {
        Stack<Point> path = new Stack<>();
        ArrayList<Point> visited = new ArrayList<>();

        path.push(new Point(0, 0));
        visited.add(new Point(0, 0));
        // while loop to know if we csn make it to the end
        // find length and height for maze
        // find way to get direction(right/down)
        while (!path.isEmpty() &&
                !(path.peek().x == maze[0].length - 1 &&
                        path.peek().y == maze.length - 1)) {
            Point p = path.peek();
            // move to the new point
            // 2 options:
            // - move right
            // - move down

            // Handle going right (+x)
            Point goingRight = new Point(p.x + 1, p.y);
            Point goingDown  = new Point(p.x, p.y + 1);

            if (p.x + 1 != maze[0].length && maze[p.y][p.x + 1] == 0
                    && !visited.contains(goingRight)) {
                path.push(goingRight);
                visited.add(goingRight);
            }
            // Handle going down (+y)
            else if (p.y + 1 != maze.length && maze[p.y + 1][p.x] == 0
                    && !visited.contains(goingDown)) {
                path.push(goingDown);
                visited.add(goingDown);
            } else {
                path.pop();
            }
        }

        // If path is empty, then we are stuck
        // else, we found it!
        return !path.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(solution(maze1));
        System.out.println(solution(maze2));
        System.out.println(solution(maze3));
        System.out.println(solution(maze4));
    }
}

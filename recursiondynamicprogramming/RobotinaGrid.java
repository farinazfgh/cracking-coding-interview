package recursiondynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class RobotinaGrid {
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    List<Point> getPath(int[][] maze) {
        if (maze == null || maze.length == 0) return null;
        List<Point> path = new ArrayList<>();
        if (getPath(maze, maze.length - 1, maze[0].length - 1, path)) return path;
        return null;
    }

    boolean getPath(int[][] maze, int row, int column, List<Point> points) {
        /*
        This solution is
        O(2^(r+c)), since each path has r+c steps and there are two choices we can make at each step.
         */
        /* If out of bounds or not available, return. */
        if (row < 0 || column < 0 || maze[row][column] == -1) return false;
        boolean isAtOrigin = (row == 0 && column == 0);

        /* If there's a path from the start to here, add my location. */
        if (isAtOrigin
                || getPath(maze, row - 1, column, points)
                || getPath(maze, row, column - 1, points)) {
            points.add(new Point(row, column));
            return true;
        }
        return false;
    }
}

package recursiondynamicprogramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
The algorithm will now take O(XY) time because we hit each cell just once.
 */
public class RobotinaGridDP {
    List<Point> getPath(boolean[][] maze) {
        if (maze == null || maze.length == 0) return null;
        List<Point> path = new ArrayList<>();
        Set<Point> alreadyVisitedPoints = new HashSet<>();
        if (getPath(maze, maze.length - 1, maze[0].length - 1, path, alreadyVisitedPoints)) {
            return path;

        }
        return null;
    }

    private boolean getPath(boolean[][] maze, int row, int column, List<Point> path, Set<Point> alreadyVisitedPoints) {
        if (row < 0 || column < 0 || !maze[row][column]) return false;
        Point point = new Point(row, column);
        //if we have already visited this cell return
        if (alreadyVisitedPoints.contains(point)) return false;
        boolean isAtOrigin = (row == 0 && column == 0);

        if (isAtOrigin ||
                getPath(maze, row - 1, column, path, alreadyVisitedPoints) ||
                getPath(maze, row, column - 1, path, alreadyVisitedPoints)) {
            path.add(point);
            return true;
        }
        alreadyVisitedPoints.add(point);//Cache result
        return false;
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

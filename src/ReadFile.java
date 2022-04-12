/*
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import robot.Point;
import robot.Robot;
import robot.Robot.Direction;

public class ReadFile {

  public static void main(String[] args) throws FileNotFoundException {
    BufferedReader reader;
    try {
      reader = new BufferedReader(new FileReader("/Users/vamikagupta/Desktop/input.txt"));
      String lineOne = reader.readLine();
      String[] first = lineOne.split(" ");
      Point initialPos = new Point(Integer.parseInt(first[0]), Integer.parseInt(first[1]));
      Direction direction = stringToDirection(first[2]);
      String lineTwo = reader.readLine();
      String[] second = lineTwo.split(" ");
      int numOfObstacles = Integer.parseInt(second[0]);
      int numOfCommands = Integer.parseInt(second[1]);
      List<Point> obstacles = new ArrayList<>(Collections.emptyList());
      for (int i = 1; i <= numOfObstacles; i++) {
        String nextLine = reader.readLine();
        String[] next = nextLine.split(" ");
        Point obstacle = new Point(Integer.parseInt(next[0]), Integer.parseInt(next[1]));
        obstacles.add(obstacle);
      }

      Robot wally = new Robot(initialPos, obstacles, direction);
      for (int i = 1; i <= numOfCommands; i++) {
        String nextLine = reader.readLine();
        String[] next = nextLine.split(" ");
        if (next[0].equals("R")) {
          wally.turnRight();
        };
        if (next[0].equals("L")) {
          wally.turnLeft();
        };
        if (next[0].equals("M")) {
          int n = Integer.parseInt(next[1]);
          wally.move(n);
        };
      }
      float maxDistance = wally.getMaxDistance();
      System.out.println("Max Distance is: " + String.valueOf(maxDistance));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static Direction stringToDirection(String str) {
    if (str.equals("N")) {
      return Direction.NORTH;
    }
    if (str.equals("S")) {
      return Direction.SOUTH;
    }
    if (str.equals("E")) {
      return Direction.EAST;
    }
    if (str.equals("W")) {
      return Direction.WEST;
    }
    return null;
  }

}
*/

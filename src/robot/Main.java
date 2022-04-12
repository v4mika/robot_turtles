package robot;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import robot.Robot.Direction;

public class Main {

  public static void main(String[] args) throws FileNotFoundException {
    BufferedReader reader;
    try {
      reader = new BufferedReader(new FileReader("/Users/vamikagupta/Desktop/input.txt"));
      Robot wally = robotFromFile(reader);
      for (int i = 1; i <= wally.getNumOfCommands(); i++) {
        moveRobot(wally, reader);
      }
      float maxDistance = wally.getMaxDistance();
      System.out.println("Max distance is: " + maxDistance);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static Robot robotFromFile(BufferedReader reader) throws IOException {
    String lineOne = reader.readLine();
    String[] first = lineOne.split(" ");
    Point initialPos = new Point(Integer.parseInt(first[0]), Integer.parseInt(first[1]));
    Direction direction = stringToDirection(first[2]);
    String lineTwo = reader.readLine();
    String[] second = lineTwo.split(" ");
    int numOfObstacles = Integer.parseInt(second[0]);
    int numOfCommands = Integer.parseInt(second[1]);
    Robot robot = new Robot(initialPos, direction, numOfObstacles, numOfCommands);
    for (int i = 1; i <= robot.getNumOfObstacles(); i++) {
      String nextLine = reader.readLine();
      String[] next = nextLine.split(" ");
      Point obstacle = new Point(Integer.parseInt(next[0]), Integer.parseInt(next[1]));
      robot.addObstacle(obstacle);
    }
    return robot;
  }

  private static void moveRobot(Robot robot, BufferedReader reader) throws IOException {
    String nextLine = reader.readLine();
    String[] next = nextLine.split(" ");
    if (next[0].equals("R")) {
      robot.turnRight();
    }
    if (next[0].equals("L")) {
      robot.turnLeft();
    }
    if (next[0].equals("M")) {
      int n = Integer.parseInt(next[1]);
      robot.move(n);
    }
  }

  private static Direction stringToDirection(String str) {
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


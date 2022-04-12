package robot;

import static java.lang.Math.sqrt;

import java.util.ArrayList;

public class Robot {

  private final ArrayList<Point> obstacles;
  private final int numOfObstacles;
  private final int numOfCommands;
  private Point coOrds;
  private Direction direction;
  private float distanceFromOrigin;
  private float maxDistance;

  public Robot(Point coOrds, Direction direction, int numOfObstacles, int numOfCommands) {
    this.coOrds = coOrds;
    this.obstacles = new ArrayList<>();
    this.direction = direction;
    this.distanceFromOrigin = calcDistanceFromOrigin(coOrds);
    this.maxDistance = distanceFromOrigin;
    this.numOfObstacles = numOfObstacles;
    this.numOfCommands = numOfCommands;
  }

  public Point nextCoOrd() {
    int oldX = this.getCoOrds().getX();
    int oldY = this.getCoOrds().getY();
    switch (this.getDirection()) {
      case NORTH -> {
        return new Point(oldX, oldY + 1);
      }
      case SOUTH -> {
        return new Point(oldX, oldY - 1);
      }
      case EAST -> {
        return new Point(oldX + 1, oldY);
      }
      case WEST -> {
        return new Point(oldX - 1, oldY);
      }
    }
    return null;
  }

  public void move(int n) {
    Point p = this.nextCoOrd();
    for (int i = 1; i <= n; i++) {
      if (obstacles.contains(p)) {
      } else {
        this.setCoOrds(p);
        this.setDistanceFromOrigin();
        if (distanceFromOrigin > this.getMaxDistance()) {
          this.setMaxDistance(distanceFromOrigin);
        }
      }
    }
  }

  public void turnLeft() {
    switch (this.getDirection()) {
      case NORTH -> {
        this.setDirection(Direction.WEST);
      }
      case SOUTH -> {
        this.setDirection(Direction.EAST);
      }
      case EAST -> {
        this.setDirection(Direction.NORTH);
      }
      case WEST -> {
        this.setDirection(Direction.SOUTH);
      }
    }
  }

  public void turnRight() {
    switch (this.getDirection()) {
      case NORTH -> {
        this.setDirection(Direction.EAST);
      }
      case SOUTH -> {
        this.setDirection(Direction.WEST);
      }
      case EAST -> {
        this.setDirection(Direction.SOUTH);
      }
      case WEST -> {
        this.setDirection(Direction.NORTH);
      }
    }
  }

  public Direction getDirection() {
    return direction;
  }

  public void setDirection(Direction newDirection) {
    this.direction = newDirection;
  }

  public Point getCoOrds() {
    return coOrds;
  }

  public void setCoOrds(Point coOrds) {
    this.coOrds = coOrds;
  }

  public void addObstacle(Point obstacle) {
    obstacles.add(obstacle);
  }

  public float getMaxDistance() {
    return maxDistance;
  }

  public void setMaxDistance(float maxDistance) {
    this.maxDistance = maxDistance;
  }

  public int getNumOfObstacles() {
    return numOfObstacles;
  }

  public int getNumOfCommands() {
    return numOfCommands;
  }

  public float calcDistanceFromOrigin(Point p) {
    return (float) sqrt(Math.pow((p.getX()), 2) + Math.pow((p.getY()), 2));
  }

  public void setDistanceFromOrigin() {
    this.distanceFromOrigin = calcDistanceFromOrigin(coOrds);
  }

  public enum Direction {
    NORTH,
    SOUTH,
    EAST,
    WEST
  }

}

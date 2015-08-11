/*
 * Raymond Luu
 * 
 * TCSS 305 - Winter 2012
 * Assignment 2 - Easy Street
 */

import java.util.Map;
import java.util.Random;

/**
 * Truck subclass of Vehicle.
 * 
 * @author Raymond
 * @version 16 January 2012
 */
public class Truck extends AbstractVehicle implements Movable {
  /**
   * Constant for random number to choose from between 0 and 2.
   */
  private static final int RAND_NUM = 3;
  /**
   * Constant for file name(alive).
   */
  private static final String FILE_NAME_ALIVE = "truck.gif";
  
  /**
   * Constant for file name(dead).
   */
  private static final String FILE_NAME_DEAD = "truck_dead.gif";
  
  /**
   * Constant for death timer.
   */
  private static final int DEATH_TIMER = 0;
  
  /**
   * Constructor for Truck subclass.
   * 
   * @param the_x the x position.
   * @param the_y the y position.
   * @param the_dir the direction.
   */
  public Truck(final int the_x, final int the_y, final Direction the_dir) {
    super(the_x, the_y, the_dir, FILE_NAME_ALIVE, FILE_NAME_DEAD, DEATH_TIMER);
  }
  
  /**
   *{@inheritDoc}
   */
  @Override
  public Direction chooseDirection(final Map<Direction, Terrain> the_neighbors,
                                   final Light the_light) {
    Direction dir = getDirection();
    Boolean direction_found = false;
    
    if (the_neighbors.get(getDirection()) != Terrain.STREET &&
        the_neighbors.get(getDirection().left()) != Terrain.STREET &&
        the_neighbors.get(getDirection().right()) != Terrain.STREET &&
        the_neighbors.get(getDirection()) != Terrain.LIGHT) {
      dir = getDirection().reverse();
      direction_found = true;
    }

    dir = chooseDirectionHelper1(the_neighbors, dir, direction_found);
    
    return dir;
  }
  
  /**
   * Helper method for chooseDirection method.
   * 
   * @param the_neighbors Map of Directions and Terrains neighboring vehicle.
   * @param the_dir Direction of vehicle.
   * @param the_direction_found Boolean to see if direction of vehicle is determined.
   * @return returns a direction to move.
   */
  private Direction chooseDirectionHelper1(final Map<Direction, Terrain> the_neighbors,
                                           final Direction the_dir,
                                           final Boolean the_direction_found) {
    Direction dir = the_dir;
    final Random rand = new Random();
    Boolean direction_found = the_direction_found;
    
    while (!direction_found) {
      switch (rand.nextInt(RAND_NUM)) {
        case 0: 
          if (the_neighbors.get(getDirection()) == Terrain.STREET ||
              the_neighbors.get(getDirection()) == Terrain.LIGHT) {
            dir = getDirection();
            direction_found = true;
          }
          break;

        case 1:
          if (the_neighbors.get(getDirection().left()) == Terrain.STREET) {
            dir = getDirection().left();
            direction_found = true;
          }
          break;

        case 2:
          if (the_neighbors.get(getDirection().right()) == Terrain.STREET) {
            dir = getDirection().right();
            direction_found = true;
          }
          break;

        default:
          break;
      }
    }
    return dir;
  }
  /**
   * {@inheritDoc}
   */
  @Override
  public boolean canPass(final Terrain the_terrain, final Light the_light) {
    return super.canPass(the_terrain, the_light) || the_terrain == Terrain.LIGHT;
  }
}

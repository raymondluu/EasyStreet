/*
 * Raymond Luu
 * 
 * TCSS 305 - Winter 2012
 * Assignment 2 - Easy Street
 */

import java.util.Map;

/**
 * Bicycle subclass of Vehicle.
 * 
 * @author Raymond Luu
 * @version 16 January 2012
 */
public class Bicycle extends AbstractVehicle implements Movable {
  /**
   * Constant for file name(alive).
   */
  private static final String FILE_NAME_ALIVE = "bicycle.gif";
  
  /**
   * Constant for file name(dead).
   */
  private static final String FILE_NAME_DEAD = "bicycle_dead.gif";
  
  /**
   * Constant for death timer.
   */
  private static final int DEATH_TIMER = 20;
  
  /**
   * Constructor for Bicycle subclass.
   * 
   * @param the_x the x position.
   * @param the_y the y position.
   * @param the_dir the direction.
   */
  public Bicycle(final int the_x, final int the_y, final Direction the_dir) {
    super(the_x, the_y, the_dir, FILE_NAME_ALIVE, FILE_NAME_DEAD, DEATH_TIMER);
  }
  
  /**
   *{@inheritDoc}
   */
  @Override
  public Direction chooseDirection(final Map<Direction, Terrain> the_neighbors,
                                   final Light the_light) {
    Direction dir = Direction.CENTER;
    
    if (the_neighbors.get(getDirection()) == Terrain.LIGHT && the_light != Light.GREEN) {
      dir = getDirection();
    } else {
      if (the_neighbors.get(getDirection()) == Terrain.TRAIL) {
        dir = getDirection();
      } else if (the_neighbors.get(getDirection().left()) == Terrain.TRAIL) {
        dir = getDirection().left();
      } else if (the_neighbors.get(getDirection().right()) == Terrain.TRAIL) {
        dir = getDirection().right();
      } else {
        dir = super.chooseDirection(the_neighbors, the_light);
      }
    }
    return dir;
  }
  
  /**
   * {@inheritDoc}
   */
  @Override
  public boolean canPass(final Terrain the_terrain, final Light the_light) {
    return super.canPass(the_terrain, the_light) || the_terrain == Terrain.TRAIL;
  }
}

/*
 * Raymond Luu
 * 
 * TCSS 305 - Winter 2012
 * Assignment 2 - Easy Street
 */

import java.util.Map;

/**
 * Car subclass of Vehicle.
 * 
 * @author Raymond
 * @version 16 January 2012
 */
public class Car extends AbstractVehicle implements Movable {
  /**
   * Constant for file name(alive).
   */
  private static final String FILE_NAME_ALIVE = "car.gif";
  
  /**
   * Constant for file name(dead).
   */
  private static final String FILE_NAME_DEAD = "car_dead.gif";
  
  /**
   * Constant for death timer.
   */
  private static final int DEATH_TIMER = 10;
  
  /**
   * Constructor for Car subclass.
   * 
   * @param the_x the x position.
   * @param the_y the y position.
   * @param the_dir the direction.
   */
  public Car(final int the_x, final int the_y, final Direction the_dir) {
    super(the_x, the_y, the_dir, FILE_NAME_ALIVE, FILE_NAME_DEAD, DEATH_TIMER);
  }
  
  /**
  *{@inheritDoc}
  */
  @Override
  public Direction chooseDirection(final Map<Direction, Terrain> the_neighbors,
                                  final Light the_light) {
    return super.chooseDirection(the_neighbors, the_light);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean canPass(final Terrain the_terrain, final Light the_light) {
    return super.canPass(the_terrain, the_light) ||
          (the_terrain == Terrain.LIGHT && the_light != Light.RED);
  }
}

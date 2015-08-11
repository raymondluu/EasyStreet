/*
 * Raymond Luu
 * 
 * TCSS 305 - Winter 2012
 * Assignment 2 - Easy Street
 */

import java.util.Map;

/**
 * Human subclass of Vehicle.
 * 
 * @author Raymond
 * @version 16 January 2012
 */
public class Human extends AbstractVehicle implements Movable {
  /**
   * Constant for file name(alive).
   */
  private static final String FILE_NAME_ALIVE = "human.gif";
  
  /**
   * Constant for file name(dead).
   */
  private static final String FILE_NAME_DEAD = "human_dead.gif";
  
  /**
   * Constant for death timer.
   */
  private static final int DEATH_TIMER = 50;
  
  /**
   * The terrain that the human is on.
   */
  private final Terrain my_terrain;
  
  /**
   * Constructor for Human subclass.
   * 
   * @param the_x the x position.
   * @param the_y the y position.
   * @param the_dir the direction.
   * @param the_terrain the terrain.
   */
  public Human(final int the_x,
               final int the_y,
               final Direction the_dir,
               final Terrain the_terrain) {
    super(the_x, the_y, the_dir, FILE_NAME_ALIVE, FILE_NAME_DEAD, DEATH_TIMER);
    my_terrain = the_terrain;
  }
  
  /**
   *{@inheritDoc}
   */
  @Override
  public Direction chooseDirection(final Map<Direction, Terrain> the_neighbors,
                                   final Light the_light) {
    Direction dir = Direction.CENTER;
    
    do {
      dir = Direction.random();
      if (the_neighbors.get(dir) == Terrain.LIGHT) {
        break;
      }
    } while (the_neighbors.get(dir) != my_terrain);
    return dir;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean canPass(final Terrain the_terrain, final Light the_light) {
    return my_terrain.equals(the_terrain) || 
          (my_terrain == Terrain.STREET && the_terrain == Terrain.LIGHT);
  }
}

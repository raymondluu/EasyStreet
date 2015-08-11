/*
 * Raymond Luu
 * 
 * TCSS 305 - Winter 2012
 * Assignment 2 - Easy Street
 */

import java.util.Map;

/**
 * Vehicle Object Class.
 * 
 * @author Raymond Luu
 * @version 16 January 2012
 */

public abstract class AbstractVehicle implements Movable {
  /**
   * Vehicle x position.
   */
  private int my_current_x;
  
  /**
   * Vehicle y position.
   */
  private int my_current_y;
  
  /**
   * Vehicle direction.
   */
  private Direction my_current_dir;
  
  /**
   * Vehicle(alive) file name.
   */
  private final String my_file_name_alive;
  
  /**
   * Vehicle(dead) file name.
   */
  private final String my_file_name_dead;
  
  /**
   * Vehicle original x position.
   */
  private final int my_original_x;
  
  /**
   * Vehicle original y position.
   */
  private final int my_original_y;
  
  /**
   * Vehicle original direction.
   */
  private final Direction my_original_dir;
  
  /**
   * Vehicle original death timer.
   */
  private final int my_original_death_timer;
  
  /**
   * Vehicle life, True meaning alive and False meaning dead.
   */
  private Boolean my_life = true;
  
  /**
   * Vehicle death timer.
   */
  private int my_death_timer;
  
  /**
   * Constructor for Vehicle Object.
   * 
   * @param the_x the x position.
   * @param the_y the y position.
   * @param the_dir the direction.
   * @param the_file_name_alive Vehicle(alive) file name.
   * @param the_file_name_dead Vehicle(dead) file name.
   * @param the_death_timer Vehicle death timer.
   */
  public AbstractVehicle(final int the_x,
                         final int the_y,
                         final Direction the_dir,
                         final String the_file_name_alive,
                         final String the_file_name_dead,
                         final int the_death_timer) {
    my_current_x = the_x;
    my_current_y = the_y;
    my_current_dir = the_dir;
    my_death_timer = the_death_timer;
    my_file_name_alive = the_file_name_alive;
    my_file_name_dead = the_file_name_dead;
    my_original_x = the_x;
    my_original_y = the_y;
    my_original_dir = the_dir;
    my_original_death_timer = the_death_timer;
  }
  
  /**
   * Vehicle chooses a direction to move.
   * 
   * @param the_neighbors Map of Directions and Terrains neighboring vehicle.
   * @param the_light the stop lights.
   * @return returns a direction to move.
   */
  public Direction chooseDirection(final Map<Direction, Terrain> the_neighbors,
                                   final Light the_light) {
    Direction dir = Direction.CENTER;
    
    if (the_neighbors.get(getDirection()) == Terrain.STREET ||
        the_neighbors.get(getDirection()) == Terrain.LIGHT) {
      dir = getDirection();
    } else if (the_neighbors.get(getDirection().left()) == Terrain.STREET ||
               the_neighbors.get(getDirection().left()) == Terrain.LIGHT) {
      dir = getDirection().left();
    } else if (the_neighbors.get(getDirection().right()) == Terrain.STREET ||
               the_neighbors.get(getDirection().right()) == Terrain.LIGHT) {
      dir = getDirection().right();
    } else {
      dir = getDirection().reverse();
    }
    return dir;
  }
  
  /**
   * See if a vehicle can pass terrain with a given light.
   * 
   * @param the_terrain the terrain.
   * @param the_light the lights.
   * @return if a vehicle is able to pass.
   */
  public boolean canPass(final Terrain the_terrain, final Light the_light) {
    return the_terrain == Terrain.STREET ||
           the_terrain == Terrain.LIGHT && the_light == Light.GREEN;
  }
  
  /**
   * Notifies that this vehicle has collided with another.
   * 
   * @param the_other other vehicle.
   */
  public void collide(final Movable the_other) {
    if (getDeathTime() > the_other.getDeathTime()) {
      my_life = false;
    }
  }
  
  /**
   * Returns name of image file.
   * 
   * @return name of image file.
   */
  public String getImageFileName() {
    String file_name = "";
    
    if (isAlive()) {
      file_name = my_file_name_alive;
    } else {
      file_name = my_file_name_dead;
    }
    return file_name;
  }
  
  /**
   * Returns vehicles death timer.
   * 
   * @return death timer.
   */
  public int getDeathTime() {
    return my_original_death_timer;
  }
  
  /**
   * Returns direction of vehicle.
   * 
   * @return direction of vehicle.
   */
  public Direction getDirection() {
    return my_current_dir;
  }
  
  /**
   * Returns x coordinate of this vehicle.
   * 
   * @return x coordinate of this vehicle.
   */
  public int x() {
    return my_current_x;
  }
  
  /**
   * Returns y coordinate of this vehicle.
   * 
   * @return y coordinate of this vehicle.
   */
  public int y() {
    return my_current_y;
  }
  
  /**
   * Returns if a vehicle is dead or alive.
   * 
   * @return if a vehicle is dead or alive.
   */
  public boolean isAlive() {
    return my_life;
  }
  
  /**
   * Allows dead vehicles to keep track of how long they have been dead.
   */
  public void poke() {
    if (!isAlive()) {
      my_death_timer--;
    }
    if (my_death_timer == 0) {
      my_life = true;
      setDirection(Direction.random());
      my_death_timer = my_original_death_timer;
    }
  }
  
  /**
   * Resets vehicle to initial state.
   */
  public void reset() {
    setX(my_original_x);
    setY(my_original_y);
    setDirection(my_original_dir);
    my_life = true;
    my_death_timer = my_original_death_timer;
  }
  
  /**
   * Sets direction of this vehicle.
   * 
   * @param the_dir direction to set this vehicle.
   */
  public void setDirection(final Direction the_dir) {
    my_current_dir = the_dir;
  }
  
  /**
   * Sets x coordinate of this vehicle.
   * 
   * @param the_x new x coordinate of this vehicle.
   */
  public void setX(final int the_x) {
    my_current_x = the_x;
  }
  
  /**
   * Sets y coordinate of this vehicle.
   * 
   * @param the_y new y coordinate of this vehicle.
   */
  public void setY(final int the_y) {
    my_current_y = the_y;
  }
}

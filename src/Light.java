/*
 * TCSS 305 - Winter 2012 Homework 2: Easy Street
 * Author: Marty Stepp
 * Author: Daniel M. Zimmerman
 * Author: Alan Fowler
 */

/**
 * An enumeration of traffic light statuses.
 * 
 * @author Marty Stepp
 * @author Daniel M. Zimmerman
 * @author Alan Fowler
 * @version Winter 2012
 */

public enum Light {
  /**
   * Green means go.
   */
  GREEN,

  /**
   * Yellow means caution.
   */
  YELLOW,

  /**
   * Red means stop.
   */
  RED;

  /**
   * Returns the next light in sequence after this one. The sequence is GREEN,
   * YELLOW, RED.
   * 
   * @return the next light in sequence.
   */
  public Light advance() {
    Light result = Light.GREEN;

    switch (this) {
      case GREEN:
        result = YELLOW;
        break;

      case YELLOW:
        result = RED;
        break;

      case RED:
        result = GREEN;
        break;

      default:
    }

    return result;
  }
}
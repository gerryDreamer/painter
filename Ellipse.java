package drawing;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

public class Ellipse extends BoundedShape implements Serializable{
  private int count=0;
  /**
   * default constructor.
   */
    public Ellipse(){
          super(0,0,0,0,Color.BLACK,false);
    }
    /**
     * 
    *@param x1 sets origin of a vector, in the x-axis
        * @param y1 sets origin of a vector, in the y-axis
        * @param x2 sets final coordinate of a vector, in the x-axis
        * @param y2 sets final coordinate of a vector, in the y-axis
        * @param color sets the color of the current shape being drawn
        * @param b sets the current boolean that determines a filled or unfilled shape.  
     */
    public Ellipse(int x1, int y1, int x2, int y2,Color color,boolean b){
         super(x1,y1,x2,y2,color,b);
    }
    /**
     * 
     * @param g draws the current number of shapes
     */
     public void draw(Graphics g){
        g.setColor(getColor());
        if(getFilled()==true){
           g.fillOval(getOriginX(), getOriginY(), getFinalX(), getFinalY());  
        }
        else{
            g.drawOval(getOriginX(), getOriginY(), getFinalX(), getFinalY()); 
        }       
    }
     /**
      * @return -  returns the current number of objects drawn.
      */
    public int getCount(){
        return ++count;
    }
    /**
     * 
     * @return the default string implementation of this class.
     */
    public String toString(){
        return String.format("\nMyOval: %s\n", super.toString());
    }
}

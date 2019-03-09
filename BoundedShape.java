package drawing;

import java.awt.Color;
import java.io.Serializable;

public abstract class BoundedShape extends MyShape implements Serializable{
     private boolean isFilled;
     /**
      * this is the default arguments constructor, it initializes the default superclass methods,
      * and adds the isFilled boolean argument to determine if the shape is filled or not.
      */
    public BoundedShape(){
        super(0,0,0,0,Color.BLACK);
         setFilled(false);
    }
    /**
     * 
        *@param x1 sets origin of a vector, in the x-axis
        * @param y1 sets origin of a vector, in the y-axis
        * @param x2 sets final coordinate of a vector, in the x-axis
        * @param y2 sets final coordinate of a vector, in the y-axis
        * @param color sets the color of the current shape being drawn
        * @param b sets the current boolean that determines a filled or unfilled shape.        
     * @see MyShape
     */
    public BoundedShape(int x1, int y1, int x2, int y2,Color color,boolean b){
        super(x1,y1,x2,y2,color);
        setFilled(b);
    }
    /**
     * 
     * @param b signifies to the client application that the shape is either filled or not
     */
        public void setFilled(boolean b){
       isFilled = b; 
    }
     /**
      * 
      * @return returns true if the shape is (to be)filled or false if the shape is not (to be) filled.
      */
    public boolean getFilled(){
        return isFilled;
    }
    /**
     * 
     * @return the default string representation of the class.
     */
     public String toString(){
         return String.format("%s, %s", super.toString(),getFilled() == true ? "filled":"not filled");
     }
}

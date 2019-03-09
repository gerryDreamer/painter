package drawing;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

public class Line extends MyShape implements Serializable{
    private int count=0;
    /**
     * default constructor for this class.
     */
    public Line(){
        super(0,0,0,0,Color.BLACK);
    }
    /**
     * 
    *@param x1 sets origin of a vector, in the x-axis
        * @param y1 sets origin of a vector, in the y-axis
        * @param x2 sets final coordinate of a vector, in the x-axis
        * @param y2 sets final coordinate of a vector, in the y-axis
        * @param color sets the color of the current shape being drawn        
     */
    public Line(int x1, int y1, int x2, int y2,Color color){
        super(x1,y1,x2,y2,color);
    }
    /**
     * 
     * @param g invokes graphics to draw the current shape.
     * 
     */
    public void draw(Graphics g){
         g.setColor(getColor());
        g.drawLine(getOriginX(), getOriginY(), getFinalX(), getFinalY());
    }
    /**
     *
     * @return returns the current number of objects drawn.
     */
    public int getCount(){
        return ++count;
    }
    /**
     * 
     * @return default string representation.
     */
     public String toString(){
         return String.format("MyLine: %s\n", super.toString());
     }
}

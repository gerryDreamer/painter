package drawing;
import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

public abstract class MyShape implements Serializable{
    private int x1,y1,x2,y2;
    private Color color;
      private static final long serialVersionUID = 1993L;//the default serial version for files produced by this application
    /**
     * this is the default constructor, it initializes all the class methods to a default value.
     */
   public MyShape(){
      setOriginX(0);
      setOriginY(0);
      setFinalX(0);
      setFinalY(0);
      setColor(Color.BLACK);
   } 
   /**
    * 
    * @param x1 sets origin of a vector, in the x-axis
    * @param y1 sets origin of a vector, in the y-axis
    * @param x2 sets final coordinate of a vector, in the x-axis
    * @param y2 sets final coordinate of a vector, in the y-axis
    * @param color sets the color of the current shape being drawn
    */
   public MyShape(int x1, int y1, int x2, int y2,Color color){
      setOriginX(x1);
      setOriginY(y1);
      setFinalX(x2);
      setFinalY(y2);
      setColor(color);
   }
   /**
    * 
    * @param x1 initializes the origin of the x-axis as the value of this parameter.
    */
   public void setOriginX(int x1){
       this.x1 = (x1 < 0) ? 0:x1;
   }
   /**
    * 
    * @return the origin of the x-axis
    */
   public int getOriginX(){
       return x1;
   }
   /**
    * 
    * @param y1 initializes the origin of the y-axis as the value of this parameter.
    */
   public void setOriginY(int y1){
       this.y1 = (y1 < 0)? 0:y1;
   }
   /**
    * 
    * @return returns the origin of the y-axis.
    */
   public int getOriginY(){
       return y1;
   }
   /**
    * 
    * @param x2 sets the final coordinate in a coordinate space.
    */
   public void setFinalX(int x2){
       this.x2 = (x2 <0)? 0:x2;
   }
   /**
    * 
    * @return returns the final coordinate in the x-axis. 
    */
   public int getFinalX(){
       return x2;
   }
   /**
    * 
    * @param y2 sets the final coordinate in a coordinate space.
    */
   public void setFinalY(int y2){
       this.y2 = (y2 <0)? 0:y2;
   }
   /**
    * 
    * @return returns the final coordinate of type y2 in the y-axis.
    */
   public int getFinalY(){
       return y2;
   }
   /**
    * 
    * @param color modifies the value of the current color to the argument received here.
    */
   public void setColor(Color color){
       this.color = color;
   }
   /**
    * 
    * @return returns the current color as modified by the client application.
    */
   public Color getColor(){
       return color;
   }
   /**
    * 
    * @param g enables graphics capabilities for primitives overriding this method. 
    */
   public abstract void draw(Graphics g);
   /**
    * 
    * @return returns the current number of objects drawn by the client application.
    * this method is overridden by the subclasses.
    */
   public abstract int getCount();
   /**
    * 
    * @return returns the default string representation of this class.
    */
   public String toString(){
       return String.format("x1: %d, y1: %d , x2: %d, y2: %d\n"
               + "Color: %s", getOriginX(),getOriginY(),getFinalX(),
               getFinalY(),getColor().toString());
   }
}

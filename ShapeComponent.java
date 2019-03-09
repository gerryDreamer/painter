package drawing;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class ShapeComponent extends JPanel{
    private MyShape shapes[] = new MyShape[500];
    private MyShape currentShape;//rep. the current shape being drawn
    private Line lines;
   // private MyBoundedShape bounded;
    private Ellipse ovals;
    private Rectangle rect;
    private int shapeCount = 0;//counts # shapes in the array 
    private int shapeType;//deter. tpe of shape to draw
    private Color currentColor;
    private boolean filledShape;
    private JLabel statusLabel = new JLabel();  
    public ShapeComponent(JLabel label){
        statusLabel = label;
        setShapeType(0);
        setShapeCount(0);
        setCurrentShape(null);
        setCurrentColor(Color.BLACK);
        setBackground(Color.WHITE);
        addMouseListener(new MouseHandler());
        addMouseMotionListener(new MouseHandler());        
    }   
    private class MouseHandler extends MouseAdapter implements MouseMotionListener{
       @Override public void mousePressed(MouseEvent evt){
            //initialize both points of the current shape to the mouse position
           //assign current shape new shape specified by the shapeType
           int VAL = 5;           
           if(getShapeType()==0){
               setCurrentShape(new Line(evt.getX(),evt.getY(),evt.getX(),evt.getY(),getCurrentColor()));
            }//end if
            else if(getShapeType()==1){
                setCurrentShape(new Rectangle(evt.getX(),evt.getY(),VAL,VAL,getCurrentColor(),getFilledShape()));
            }//end else if
            else if(getShapeType()==2){
                setCurrentShape(new Ellipse(evt.getX(),evt.getY(),VAL,VAL,getCurrentColor(),getFilledShape()));
            }//end else if
        }
        @Override public void mouseReleased(MouseEvent evt){
            //finish drawing current shape
            //add current shape to the array
            /**
             * shape count determines the insertion index into the array
             */
            getCurrentShape().setFinalX(evt.getX());
            getCurrentShape().setFinalY(evt.getY());
            shapes[getShapeCount()] = getCurrentShape();
            setShapeCount(getShapeCount()+1);
            isReleased();
            repaint();           
           
        }
       @Override  public void mouseMoved(MouseEvent evt){
           //update the status label to show the mouse coordinates
            statusLabel.setText(String.format("X: %d, Y: %d\n", evt.getX(),evt.getY()));
        }
       @Override  public void mouseDragged(MouseEvent evt){
            //sets the second point of the current shape
            //to the current mouse pstn
            //allows the user to see the shape while dragging the mouse
             getCurrentShape().setFinalX(evt.getX());
            getCurrentShape().setFinalY(evt.getY());           
            repaint();
              statusLabel.setText(String.format("X: %d, Y: %d\n", evt.getX(),evt.getY()));
        }
    }
  @Override public void paintComponent(Graphics g){
        super.paintComponent(g);//shapeCount = 0 ; shapeCount <shapes.length;++shapeCount
       for(int i=0; i<getShapeCount();++i){
           if(getCurrentShape() != null){
               getCurrentShape().draw(g);
           }//end if           
       }//end iterator
     if(isReleased()){
          for(int i=0; i<getShapeCount();++i){
           shapes[i].draw(g);
        }//end for
     }//end if
    }//end paint component 
   public boolean isReleased(){
       return true;
   }
    public void clearDrawing(){
       setShapeCount(0);
       getShapeCount(); 
       repaint();
    }
    public void clearLastShape(){       
     setShapeCount(getShapeCount()-1);
     getShapeCount();
     repaint();
    }
    public void setShapeCount(int s){
        shapeCount = s < 0 ? 0:s;
    }
    public int getShapeCount(){
        return shapeCount;
    }
    public void setFilledShape(boolean f){
        filledShape = f;
    }
    public boolean getFilledShape(){
        return filledShape;
    }
    public void setCurrentColor(Color c){
        currentColor = c;
    }
    public Color getCurrentColor(){
        return currentColor;
    }
    public void setShapeType(int s){
        shapeType = s;
    }
    public int getShapeType(){
        return shapeType;
    }
    public void setCurrentShape(MyShape c){
        currentShape = c;
    }
    public MyShape getCurrentShape(){
        return currentShape;
    }
}

package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class ShapeViewer {

    /**
     * @param args the command line arguments
     */
 private static JLabel statusLabel = new JLabel();
     private static JPanel topPanel = new JPanel();
     private static JButton undoButton = new JButton("Undo");
      private static  JButton clearButton = new JButton("Clear");
      private static JComboBox colorBox;
       private static JComboBox shapeBox;
       private static JCheckBox checkBox = new JCheckBox();
       private static JLabel filledLabel = new JLabel("Filled");
       private static final String shapeNames[] = {"Line","rectangle","Oval"};
        private static final String colorNames[] = {"Red","Green","Black"};   
       private static Color colors[] = {Color.RED, Color.GREEN, Color.BLACK}; 
     private static ShapeComponent drawPanel = new ShapeComponent(statusLabel);
      private static JPanel lowerPanel = new JPanel();
    public static void main(String ...args){
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                createGUI();
            }
        });
    }
    public static void createGUI(){
        JFrame f = new JFrame("");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(500, 500);
        f.setVisible(true);
        f.setLayout(new BorderLayout());
        f.add(drawPanel,BorderLayout.CENTER);
        f.add(lowerPanel,BorderLayout.SOUTH);
        f.add(topPanel,BorderLayout.NORTH);
        lowerPanel.add(statusLabel);
        lowerPanel.setBackground(Color.WHITE);
        statusLabel.setForeground(Color.RED);
        //add components to JPanel
        colorBox = new JComboBox(colorNames);
        shapeBox = new JComboBox(shapeNames);
        topPanel.setLayout(new FlowLayout());
        topPanel.add(undoButton);
        topPanel.add(clearButton);
        topPanel.add(colorBox);
        topPanel.add(shapeBox);
        topPanel.add(checkBox);
        topPanel.add(filledLabel);
        topPanel.setBackground(Color.WHITE);
        colorBox.addItemListener(new ItemHandler());
        shapeBox.addItemListener(new ShapeHandler());
        undoButton.addActionListener(new ButtonHandler());
        clearButton.addActionListener(new ButtonHandler());
        checkBox.addItemListener(new CheckHandler());
    }
    private static class CheckHandler implements ItemListener{
    public void itemStateChanged(ItemEvent evt){
        if(evt.getStateChange()==ItemEvent.SELECTED){
            drawPanel.setFilledShape(checkBox.isSelected());
            drawPanel.getFilledShape();
        }//end if
        else if (!(evt.getStateChange()==ItemEvent.SELECTED))
        {
             drawPanel.setFilledShape(false);
            drawPanel.getFilledShape();
        }
    }
}
    private static class ButtonHandler implements ActionListener{
        public void actionPerformed(ActionEvent evt){
            if(evt.getSource()==undoButton){
                drawPanel.clearLastShape();
            }//end if
            else if(evt.getSource()==clearButton){
                drawPanel.clearDrawing();
            }//end else if
        }
    }
    private static class ItemHandler implements ItemListener{
        public void itemStateChanged(ItemEvent evt){
           if(evt.getStateChange()==ItemEvent.SELECTED){
              drawPanel.setCurrentColor(colors[colorBox.getSelectedIndex()]);
              drawPanel.getCurrentColor();              
           } //end if
        }
    }
    private static class ShapeHandler implements ItemListener{
        public void itemStateChanged(ItemEvent evt){
           if(evt.getStateChange()==ItemEvent.SELECTED){
              drawPanel.setShapeType(shapeBox.getSelectedIndex());
              drawPanel.getShapeType();
           } //end if
        }
    }}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vector.drawing.application;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author adelm
 */
public class Rectangle implements Shape {
    
    int width;
    int height;

    private Point p;
    private Map<String, Double> prop;
    private Color c;
    private Color fc;
    int result;
    public Rectangle() {
        prop = new HashMap<>();
        prop.put("width", 0.0);
        prop.put("height", 0.0);
        
                JTextField xField = new JTextField(5);
        JTextField yField = new JTextField(5);
        JTextField lengthField = new JTextField(5);
        JTextField widthField = new JTextField(5);
        
        int x=0;
        int y=0;
        lengthField.setText("");
        widthField.setText("");
        xField.setText(""+x);
        yField.setText(""+y);
        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("x:"));
        myPanel.add(xField);
        myPanel.add(Box.createHorizontalStrut(15)); // a spacer 
        myPanel.add(new JLabel("y:"));
        myPanel.add(yField);
        myPanel.add(Box.createHorizontalStrut(15));
        myPanel.add(new JLabel("Height: "));
        myPanel.add(lengthField);
        myPanel.add(Box.createHorizontalStrut(15));
        myPanel.add(new JLabel("Width: "));
        myPanel.add(widthField);
        result = JOptionPane.showConfirmDialog(null, myPanel, 
               "Please Enter X and Y Values", JOptionPane.OK_CANCEL_OPTION);
        if(result==JOptionPane.OK_OPTION){
            
            int width=Integer.parseInt(widthField.getText());
            int height=Integer.parseInt(lengthField.getText());
            prop.put("width", (double)width);
            prop.put("height", (double)height);
            x=Integer.parseInt(xField.getText());
            y=Integer.parseInt(yField.getText());
            p=new Point(x,y);
        }
       
    }
         public Rectangle(Shape shape){
        Rectangle s=(Rectangle)shape;
        this.p=s.p;
        this.prop=s.prop;
        c=s.c;
        c=s.fc;
        width=s.width;
        height=s.height; 
       
    }
    

    @Override
    public void setPosition(Point position) {
        p = position;
    }

    @Override
    public Point getPosition() {
        return p;
    }

    @Override
    public void setProperties(Map<String, Double> properties) {
        prop = properties;
    }

    @Override
    public Map<String, Double> getProperties() {
        return prop;
    }

    @Override
    public void setColor(Color color) {
        c = color;
    }

    @Override
    public Color getColor() {
        return c;
    }

    @Override
    public void setFillColor(Color color) {
        fc = color;
    }

    @Override
    public Color getFillColor() {
        return fc;
    }

    @Override
    public void draw(Graphics canvas) {
        
        canvas.setColor(fc);
        canvas.drawRect((int) p.getX(), (int) p.getY(), (int) (prop.get("width").doubleValue()), (int) (prop.get("height").doubleValue()));
        canvas.setColor(Color.BLACK);
        
        canvas.setColor(c);
        canvas.fillRect((int) p.getX(), (int) p.getY(), (int) (prop.get("width").doubleValue()), (int) (prop.get("height").doubleValue()));
        canvas.setColor(Color.BLACK);
    }
    

    @Override
    public Object clone() throws CloneNotSupportedException {
        
        Rectangle r = new Rectangle(this);
        return r;
    }
}

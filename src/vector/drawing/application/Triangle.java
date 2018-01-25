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
public class Triangle implements Shape {

    private Point p;
    private Map<String, Double> prop;
    private Color c;
    private Color fc;
    int result;

    public Triangle() {
        prop = new HashMap<>();
        prop.put("width", 0.0);
        prop.put("height", 0.0);
        
                JTextField xField = new JTextField(5);
        JTextField yField = new JTextField(5);
        JTextField widthField = new JTextField(5);
        JTextField heightField = new JTextField(5);

        int x = 0;
        int y = 0;
        widthField.setText("");
        heightField.setText("");
        xField.setText("" + x);
        yField.setText("" + y);
        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("x:"));
        myPanel.add(xField);
        myPanel.add(Box.createHorizontalStrut(15)); // a spacer 
        myPanel.add(new JLabel("y:"));
        myPanel.add(yField);
        myPanel.add(Box.createHorizontalStrut(15));
        myPanel.add(new JLabel("Width: "));
        myPanel.add(widthField);
        myPanel.add(Box.createHorizontalStrut(15));
        myPanel.add(new JLabel("Height: "));
        myPanel.add(heightField);
        myPanel.add(Box.createHorizontalStrut(15));

        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Please Enter X and Y Values", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            int width = Integer.parseInt(widthField.getText());
            prop.put("width", (double) width);
            int height = Integer.parseInt(heightField.getText());
            prop.put("height", (double) height);
            x = Integer.parseInt(xField.getText());
            y = Integer.parseInt(yField.getText());
            p = new Point(x, y);
        }
    }

    private Triangle(Shape shape) {
        Triangle s=(Triangle)shape;
        this.p=s.p;
        this.prop=s.prop;
        c=s.c;
        fc=s.fc;
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
    @SuppressWarnings("empty-statement")
    public void draw(Graphics canvas) {

        int[] xpoints = {(int) p.getX(), ((int) p.getX()) - ((prop.get("width").intValue())), ((int) p.getX()) + ((prop.get("width").intValue()) / 2)};
        int[] ypoints = {(int) p.getY(), (int) p.getY(), (int) p.getY() + (prop.get("height").intValue())};
        
        canvas.setColor(fc);
        canvas.drawPolygon(xpoints, ypoints, 3);
        canvas.setColor(Color.BLACK);
        
        canvas.setColor(c);
        canvas.fillPolygon(xpoints, ypoints, 3);
        canvas.setColor(Color.BLACK);
        
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Triangle t= new Triangle(this);
        return t;
    }

}

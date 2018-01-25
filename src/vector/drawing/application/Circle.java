/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vector.drawing.application;

import java.awt.Color;
import static java.awt.Color.BLACK;
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
public class Circle implements Shape {

    private Point p;
    private Map<String, Double> prop;
    private Color c;
    private Color fc;
    int result;
    //int diameter;
    //int x, y;

    public Circle() {
        prop = new HashMap<>();
        prop.put("diameter", 0.0);
        
        JTextField xField = new JTextField(5);
        JTextField yField = new JTextField(5);
        JTextField diameterField = new JTextField(5);

        int x = 0;
        int y = 0;
        diameterField.setText("");
        xField.setText("" + x);
        yField.setText("" + y);
        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("x:"));
        myPanel.add(xField);
        myPanel.add(Box.createHorizontalStrut(15)); // a spacer 
        myPanel.add(new JLabel("y:"));
        myPanel.add(yField);
        myPanel.add(Box.createHorizontalStrut(15));
        myPanel.add(new JLabel("Diameter: "));
        myPanel.add(diameterField);
        myPanel.add(Box.createHorizontalStrut(15));

        result = JOptionPane.showConfirmDialog(null, myPanel,
                "Please Enter X and Y Values", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {

            int diameter = Integer.parseInt(diameterField.getText());
            prop.put("diameter", (double) diameter);

            x = Integer.parseInt(xField.getText());
            y = Integer.parseInt(yField.getText());
            p = new Point(x, y);
        }
    }

    public Circle(Shape shape) {
        Circle s = (Circle) shape;
        this.p = p;
        c = s.c;
        fc=s.fc;
        this.prop=s.prop;
        
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
        canvas.drawOval((int) p.getX(), (int) p.getY(), (int) (prop.get("diameter").doubleValue()), (int) (prop.get("diameter").doubleValue()));
        canvas.setColor(BLACK);
        
        canvas.setColor(c);
        canvas.fillOval((int) p.getX(), (int) p.getY(), (int) (prop.get("diameter").doubleValue()), (int) (prop.get("diameter").doubleValue()));
        canvas.setColor(BLACK);
    }

    public Object clone() throws CloneNotSupportedException {
        Circle c = new Circle(this);
        return c;
    }

}

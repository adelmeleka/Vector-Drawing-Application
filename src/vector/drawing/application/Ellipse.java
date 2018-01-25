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
public class Ellipse implements Shape {

    private Point p;
    private Map<String, Double> prop;
    private Color c;
    private Color fc;
    int result;
    private int diameter1, diameter2;

    public Ellipse() {
        prop = new HashMap<>();
        prop.put("diameter1", 0.0);
        prop.put("diameter2", 0.0);
        
                JTextField xField = new JTextField(5);
        JTextField yField = new JTextField(5);
        JTextField diameter1Field = new JTextField(5);
        JTextField diameter2Field = new JTextField(5);

        int x = 0;
        int y = 0;
        diameter1Field.setText("");
        diameter2Field.setText("");
        xField.setText("" + x);
        yField.setText("" + y);
        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("x:"));
        myPanel.add(xField);
        myPanel.add(Box.createHorizontalStrut(15)); // a spacer 
        myPanel.add(new JLabel("y:"));
        myPanel.add(yField);
        myPanel.add(Box.createHorizontalStrut(15));
        myPanel.add(new JLabel("Diameter1: "));
        myPanel.add(diameter1Field);
        myPanel.add(Box.createHorizontalStrut(15));
        myPanel.add(new JLabel("Diameter2: "));
        myPanel.add(diameter2Field);
        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Please Enter X and Y Values", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {

            int diameter1 = Integer.parseInt(diameter1Field.getText());
            int diameter2 = Integer.parseInt(diameter2Field.getText());
            prop.put("diameter1", (double) diameter1);
            prop.put("diameter2", (double) diameter2);
            x = Integer.parseInt(xField.getText());
            y = Integer.parseInt(yField.getText());
            p = new Point(x, y);
        }

    }

    public Ellipse(Shape shape) {
        Ellipse s = (Ellipse) shape;
        this.p = p;
        this.prop = s.prop;
        c = s.c;
        fc = s.fc;

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

    //lma arssm 
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
        canvas.drawOval((int) p.getX(), (int) p.getY(), (int) (prop.get("diameter1").doubleValue()), (int) (prop.get("diameter2").doubleValue()));
        canvas.setColor(Color.BLACK);
        
        canvas.setColor(c);
        canvas.fillOval((int) p.getX(), (int) p.getY(), (int) (prop.get("diameter1").doubleValue()), (int) (prop.get("diameter2").doubleValue()));
        canvas.setColor(Color.BLACK);
        
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Ellipse e = new Ellipse(this);
        return e;
    }
}

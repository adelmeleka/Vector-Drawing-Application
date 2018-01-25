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
public class LineSegment implements Shape {

    private Point p;
    private Map<String, Double> prop;
    private Color c;
    private Color fc;
    int result;
    
        public LineSegment(Shape shape) {
        LineSegment s = (LineSegment) shape;
        this.p = s.p;
        this.prop = s.prop;
        c = s.c;
        fc = s.fc;
    }

    public LineSegment() {
        prop = new HashMap<>();
        prop.put("length", 0.0);


        JTextField xField = new JTextField(5);
        JTextField yField = new JTextField(5);
        JTextField point1Field = new JTextField(5);


        int x = 0;
        int y = 0;
        point1Field.setText("");

        xField.setText("" + x);
        yField.setText("" + y);
        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("x:"));
        myPanel.add(xField);
        myPanel.add(Box.createHorizontalStrut(15)); // a spacer 
        myPanel.add(new JLabel("y:"));
        myPanel.add(yField);
        myPanel.add(Box.createHorizontalStrut(15));
        myPanel.add(new JLabel("Length "));
        myPanel.add(point1Field);
        myPanel.add(Box.createHorizontalStrut(15));


        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Please Enter X and Y Values", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {

            int point1 = Integer.parseInt(point1Field.getText());

            prop.put("length", (double) point1);
       
            x = Integer.parseInt(xField.getText());
            y = Integer.parseInt(yField.getText());
            p = new Point(x, y);
        }
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

        canvas.setColor(c);
        canvas.drawRect((int) p.getX(), (int) p.getY(), (int) (prop.get("length").doubleValue()), 1);
       canvas.fillRect((int) p.getX(), (int) p.getY(), (int) (prop.get("length").doubleValue()),1);
        canvas.setColor(BLACK);

    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        LineSegment l = new LineSegment(this);
        return l;
    }

}

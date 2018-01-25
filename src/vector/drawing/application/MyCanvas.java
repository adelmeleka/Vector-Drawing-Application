/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vector.drawing.application;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author adelm
 */
public class MyCanvas extends JPanel implements DrawingEngine {

    ArrayList<Shape> shapes;
    ArrayList<Shape> undoneShapes = new ArrayList<>();
    List<Class<? extends Shape>> supportedShapes;

    //constructor
    public MyCanvas() {
        shapes = new ArrayList<>();
        undoneShapes = new ArrayList<>();
        supportedShapes = new ArrayList<Class<? extends Shape>>();
        setBorder(BorderFactory.createLineBorder(Color.black));
    }

    //eli beyesta5demo 3ashan yersem we a3mel loop 3ashan yersem 
    @Override //lel method eli mawgouda basta5demha we azaqwed 3aleha  
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Shape s : shapes) {
            s.draw(g);
        }
    }

    @Override
    public void addShape(Shape shape) {
        
        shapes.add(shape);
        this.repaint(); 
        undoneShapes = new ArrayList<>();
    }

    @Override
    public void removeShape(Shape shape) {
        shapes.remove(shape);
        this.repaint();
    }

    @Override
    public Shape[] getShapes() {
        return shapes.toArray(new Shape[shapes.size()]);
    }

    /**
     *
     * @param canvas
     */
    @Override
    public void refresh(Graphics canvas) {
        Graphics g = null;
        super.paintComponent(g);
        for (Shape s : shapes) {
            s.draw(g);
        }
        this.repaint();
    }

    @Override
    public List<Class<? extends Shape>> getSuppotedShapes() {
        return supportedShapes;
    }

    @Override
    public void installPluginShape(Class<? extends Shape> shapeClass) {
        supportedShapes.add(shapeClass);
    }

    @Override
    public void undo() {

        if (shapes.isEmpty()) {
            return;
        }
        undoneShapes.add(shapes.remove(shapes.size() - 1));
        this.repaint();

    }

    @Override
    public void redo() {

        if (undoneShapes.isEmpty()) {
            return;
        }
        shapes.add(undoneShapes.remove(undoneShapes.size() - 1));
        this.repaint();

    }
}

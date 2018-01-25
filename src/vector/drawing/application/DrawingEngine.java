/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vector.drawing.application;

/**
 *
 * @author adelm
 */
public interface DrawingEngine {
    /* Manage shapes objects */
    public void addShape(Shape shape);
    public void removeShape(Shape shape);
    
    /*return the created shapes objects */
    public Shape[] getShapes();
    /* redraw all shapes on the canvas*/
    public void refresh(java.awt.Graphics canvas);
    
    /*return the classes(types) of supported shapes that can be dynamically loaded at runtime (see part 3)*/
    public java.util.List<Class<? extends Shape>> getSuppotedShapes();
    /* add to the supported shapes the new shape class (part 3) */
    public void installPluginShape (Class<? extends Shape> shapeClass);
     
    /* limited to 20 steps. Only consider in undo & redo
    these operations: addShape, removeShape */
    public void undo();
    public void redo();
          
}

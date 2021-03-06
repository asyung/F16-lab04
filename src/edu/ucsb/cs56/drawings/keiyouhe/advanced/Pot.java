package edu.ucsb.cs56.drawings.keiyouhe.advanced;

import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;

import edu.ucsb.cs56.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.drawings.utilities.GeneralPathWrapper;

/**
   
   A vector drawing of a pot that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
 
 * @author: Huiyang He
 * @version: CS56 F16
 */


public class Pot extends GeneralPathWrapper implements Shape{
    /**
       Constructor
       
       @param x x coord of lower left corner of handle
       @param y y coord of lower left corner ofhandle
       @param width width of the pot body
       @param height of  the pot body
    */

    public Pot(double x, double y, double width, double height){

        double handleLength = width * 1.2; 
        double handleWidth = height * 0.2; 

        // make the handle
        Rectangle2D.Double handle = new Rectangle2D.Double(x, 0.2*handleWidth + y , handleLength, handleWidth);

        // make the pot body
        
        Line2D.Double left = new Line2D.Double(x+handleLength, y, x+handleLength, y+0.9*height);
        Line2D.Double right = new Line2D.Double(x+handleLength+width, y, x+handleLength+width, y+0.9*height);
        Line2D.Double leftSlide = new Line2D.Double(x+handleLength, y+0.9*height, x+handleLength+width*0.2, y+height);
        Line2D.Double rightSlide = new Line2D.Double(x+handleLength+width*0.8, y+height, x+handleLength+width, y+0.9*height);
        Line2D.Double bottom = new Line2D.Double(x+handleLength+width*0.2, y+height, x+handleLength+width*0.8, y+height);
        
        // put the handle and body together

        GeneralPath wholePot = this.get();
        wholePot.append(handle, false);
        wholePot.append(left, false);
        wholePot.append(right, false);
        wholePot.append(leftSlide, false);
        wholePot.append(rightSlide, false);
        wholePot.append(bottom, false);
    }
}

package ca.cmpt213.as3shapes;

import ca.cmpt213.as3shapes.Shape;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * PicturePanel class to setup Shapes using the draw function from ShapeImpl
 */
public class PicturePanel extends JPanel {

    //Fields
    private List<Shape> shapeList = new ArrayList<>();
    private Canvas canvas;
    private JLabel topTitle = new JLabel();
    private JLabel canvasPanel;

    /**
     * Constructor of PicturePanel
     * @param title title of the titlePanel
     * @param width width of the canvas
     * @param height height of the canvas
     */
    public PicturePanel(String title, int width, int height) {
        //title
        topTitle.setText(title);

        //Canvas
        CanvasIcon icon = new CanvasIcon(canvas = new Canvas(width, height));
        canvasPanel = new JLabel(icon);

        //Setting up the PicturePanel
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
        this.add(topTitle, BorderLayout.NORTH);
        this.add(canvasPanel, BorderLayout.SOUTH);
    }

    /**
     * Class to add in shapes from the front of the list
     * @param shape input shape
     */
    public void addFront(Shape shape) {
        shapeList.add(shape);

        //Drawing shapes from list
        for(Shape itr: shapeList) {
            itr.draw(canvas);
        }

        //Setting the canvasPanel for the newly added shapes
        CanvasIcon icon = new CanvasIcon(canvas);
        canvasPanel = new JLabel(icon);
        this.add(canvasPanel, BorderLayout.SOUTH);
    }

    /**
     * Class to add in shapes from the back of the list
     * @param shape input shape
     */
    public void addBack(Shape shape) {
        shapeList.add(0, shape);

        //Drawing shapes from list
        for(Shape itr: shapeList) {
            itr.draw(canvas);
        }

        //Setting the canvasPanel for the newly added shapes
        CanvasIcon icon = new CanvasIcon(canvas);
        canvasPanel = new JLabel(icon);
        this.add(canvasPanel, BorderLayout.SOUTH);
    }

}



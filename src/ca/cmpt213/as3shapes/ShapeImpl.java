package ca.cmpt213.as3shapes;

import ca.cmpt213.as3shapes.Canvas;

import java.awt.*;

/**
 * ShapeImpl implements the Shape Interface
 */
public abstract class ShapeImpl implements Shape {

    //Fields
    private char borderCharacter = '*';
    private Color color = Color.YELLOW;

    //Dimensions of the shape
    private int width;
    private int height;

    //Top left Corner location of the shape
    private int locationX;
    private int locationY;

    /**
     * Shape constructor
     * @param locationX the top left corner X coordinate of the Shape
     * @param locationY the top left corner Y coordinate of the Shape
     * @param width the width of the Shape
     * @param height the height of the Shape
     */
    public ShapeImpl(int locationX, int locationY, int width, int height) {
        this.locationX = locationX;
        this.locationY = locationY;
        this.width = width;
        this.height = height;
    }

    //Trivial methods
    public void setBorderChar(char borderCharacter) {
        this.borderCharacter = borderCharacter;
    }

    public char getBorderChar() {
        return borderCharacter;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public int getLocationX() {
        return locationX;
    }

    public int getLocationY() {
        return locationY;
    }

    protected int getWidth() {
        return width;
    }

    protected int getHeight() {
        return height;
    }

    /**
     * Draw method draws shape onto the canvas
     * @param canvas the given canvas to draw onto
     */
    public void draw(Canvas canvas) {

        for(int col = locationX; col < locationX + width; col++) { //Col X
            for(int row = locationY; row < locationY + height; row++) { //Row Y

                if(isBorder(col, row)) { //draws border
                    canvas.setPointColor(col, row, color);
                    canvas.setPointText(col, row, borderCharacter);
                }
                else if(isInside(col, row)) { //draws inside
                    canvas.setPointText(col, row, ' ');
                    canvas.setPointColor(col, row, color);
                }
            }
        }
    }

    protected abstract boolean isBorder(int xLocation, int yLocation);

    protected abstract boolean isInside(int xLocation, int yLocation);
}





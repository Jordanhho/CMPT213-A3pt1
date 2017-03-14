package ca.cmpt213.as3shapes;

/**
 * Rectangle class to create a rectangle object shape
 */
public class Rectangle extends ShapeImpl {

    /**
     * Rectangle constructor
     * @param locationX the top left corner X coordinate of the Rectangle
     * @param locationY the top left corner Y coordinate of the Rectangle
     * @param width the width of the rectangle
     * @param height the height of the rectangle
     */
    public Rectangle(int locationX, int locationY, int width, int height) {
        super(locationX, locationY, width, height);
    }

    /**
     * isBorder method checks if given X and Y coordinate is a border of the rectangle or not and returns the boolean value for it
     * @param testLocationX the test X coordinate location of the canvas if it is a border of the rectangle or not
     * @param testLocationY the test Y coordinate location of the canvas if it is a border of the rectangle or not
     * @return a boolean value if border or not
     */
    protected boolean isBorder(int testLocationX, int testLocationY) {
        if ((testLocationX == getLocationX() || testLocationX == getLocationX() + getWidth() - 1)) { //if lines up with Left or Right side Border
            return true;
        }
        else if ((testLocationY == getLocationY() || testLocationY == getLocationY() + getHeight() - 1)) { //if lines up with Top or Bottom Border
            return true;
        }
        else {
            return false; //Not a border
        }
    }

    /**
     * isInside method checks if given X and Y coordinate is inside of the rectangle or not and returns the boolean value for it
     * @param testLocationX the test X coordinate location of the canvas if it is inside of the rectangle or not
     * @param testLocationY the test Y coordinate location of the canvas if it is inside of the rectangle or not
     * @return a boolean value if inside or not
     */
    protected boolean isInside(int testLocationX, int testLocationY) {
        if(!isBorder(testLocationX, testLocationY)) {
            return true;
        }
        else {
            return false;
        }
        /*
        if ((testLocationX > getLocationX() && testLocationX < getLocationX() + getWidth() - 1) && (testLocationY > getLocationY() && testLocationY < getLocationY() + getHeight() - 1)) {
            return true;
        } else {
            return false;
        }
        */
    }
}

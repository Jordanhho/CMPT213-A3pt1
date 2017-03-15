package ca.cmpt213.as3shapes;

/**
 * Triangle class to create a triangle object shape
 */
public class Triangle extends ShapeImpl {

    //Field
    private int size;

    /**
     * triangle constructor
     * @param locationX the top left corner X coordinate of the triangle
     * @param locationY the top left corner Y coordinate of the triangle
     * @param size size of the triangle
     */
    public Triangle(int locationX, int locationY, int size) {
        super(locationX, locationY, size, size);
        this.size = size;
    }

    /**
     * Get side of triangle
     * @return returns size of triangle
     */
    public int getSize() {
        return size;
    }

    /**
     * isBorder method checks if given X and Y coordinate is a border of the triangle or not and returns the boolean value for it
     * @param testLocationX the test X coordinate location of the canvas if it is a border of the triangle or not
     * @param testLocationY the test Y coordinate location of the canvas if it is a border of the triangle or not
     * @return a boolean value if border or not
     */
    protected boolean isBorder(int testLocationX, int testLocationY) {
        //Offset X - Y of the coordinate to translate
        int offset = getLocationX() - getLocationY();

        //Temp locations
        int shapeLocationX = getLocationX();
        int shapeLocationY = getLocationY();
        int testOffSetLocationX = testLocationX;
        int testOffSetLocationY = testLocationY;

        //Translating the triangle
        if(offset < 0) { //Y is greater than X, equalize both numbers
            shapeLocationY = shapeLocationY - (-1)*offset;
            testOffSetLocationY = testOffSetLocationY - (-1)*offset;
        }
        else if(offset > 0) { //X is greater than Y, equalize both numbers
            shapeLocationX = shapeLocationX - offset;
            testOffSetLocationX = testOffSetLocationX - offset;
        }

        if(testOffSetLocationX == shapeLocationX) { //if on left on left length of triangle set as border
            return true;
        }
        else if (testOffSetLocationY == shapeLocationY + getHeight() - 1) { //if on bottom length of triangle set as border
            return true;
        }
        else if (testOffSetLocationX == testOffSetLocationY) { //if on hypotenuse of triangle, set as border
            return true;
        }
        else { //Not  a border
            return false;
        }
    }

    /**
     * isInside method checks if given X and Y coordinate is inside of the triangle or not and returns the boolean value for it
     * @param testLocationX the test X coordinate location of the canvas if it is inside of the triangle or not
     * @param testLocationY the test Y coordinate location of the canvas if it is inside of the triangle or not
     * @return a boolean value if inside or not
     */
    protected boolean isInside(int testLocationX, int testLocationY) {;

        //Offset X - Y of the coordinate to translate
        int offset = getLocationX() - getLocationY();

        //Temp location
        int testOffSetLocationX = testLocationX;
        int testOffSetLocationY = testLocationY;

        //Translating the triangle
        if(offset < 0) { //Y is greater than X
            testOffSetLocationY = testOffSetLocationY - (-1)*offset;
        }
        else if(offset > 0) { //X is greater than Y
            testOffSetLocationX = testOffSetLocationX - offset;
        }

        if(!isBorder(testLocationX, testLocationY) && testOffSetLocationY > testOffSetLocationX) { //Not a border and Y is always greater than X
            return true;
        }
        else { //Not a border or inside triangle
            return false;
        }
    }
}

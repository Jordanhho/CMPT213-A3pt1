package ca.cmpt213.as3shapes;

/**
 * TextBox class to create a textBox object shape
 */
public class TextBox extends Rectangle {

    //Field
    private  String textMessage;

    /**
     * textBox constructor
     * @param locationX the top left corner X coordinate of the textBox
     * @param locationY the top left corner Y coordinate of the textBox
     * @param width the width of the rectangle
     * @param height the height of the textBox
     * @param textMessage the message inside the textBox
     *
     */
    public TextBox(int locationX, int locationY, int width, int height, String textMessage) {
        super(locationX, locationY, width, height);
        this.textMessage = textMessage;
    }

    //Trivial methods
    public String getMessage() {
        return textMessage;
    }

    public void setMessage(String textMessage) {
        this.textMessage = textMessage;
    }



    @Override
    public void draw(Canvas canvas) {

    }
}

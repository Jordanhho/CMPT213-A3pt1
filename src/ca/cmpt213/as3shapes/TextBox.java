package ca.cmpt213.as3shapes;

import java.util.ArrayList;
import java.util.List;

/**
 * TextBox class to create a textBox object shape
 */
public class TextBox extends Rectangle {

    //Field
    private String textMessage;

    /**
     * textBox constructor
     *
     * @param locationX   the top left corner X coordinate of the textBox
     * @param locationY   the top left corner Y coordinate of the textBox
     * @param width       the width of the rectangle
     * @param height      the height of the textBox
     * @param textMessage the message inside the textBox
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

    /**
     * Draw method for a textbox
     *
     * @param canvas the given canvas to draw onto
     */
    @Override
    public void draw(Canvas canvas) {

        int slots = getWidth() - 2; //the number of inside space for text on a row

        //Convert message into array of words without spaces
        String[] wordList = textMessage.split("\\s+");
        for (int i = 0; i < wordList.length; i++) {
            wordList[i] = wordList[i].replaceAll("^\\w]", "");
        }

        //Checks if word is longer than textBox size, if so, add the 2nd half to a new slot
        List<String> wordArray = new ArrayList<>();
        for (int i = 0; i < wordList.length; i++) {
            if(wordList[i].length() > slots) {//Crop the word into 2 halves and add it

                char[] currentWord = wordList[i].toCharArray();
                int charIndex = 0;

                while(charIndex < currentWord.length) {
                    String textString = "";
                    int limit = slots; //the length to loop through
                    boolean init = false;
                    if(!init && currentWord.length - charIndex == currentWord.length % slots) { //sets the new slot number
                        limit = currentWord.length % slots;
                        init = true;
                    }
                    for(int j = 0; j < limit; j++) { //build string
                        textString = textString + currentWord[charIndex];
                        charIndex++;
                    }
                    wordArray.add(textString); //add to the list
                }
            }
            else { //just add the word without editing
                wordArray.add(wordList[i]);
            }
        }

        if (wordArray.get(0).length() == 0) { //if first character is a space, remove it
            wordArray.remove(0);
        }

        //Generates blank space for empty row;
        String blankSpace = "";
        for(int i = 0; i < slots; i++) {
            blankSpace = blankSpace + " ";
        }

        //Converting the TextString into format for the textBox
        String convertedTextMsg = "";
        int arrayIndex = 0;
        boolean noWordsLeft = false;
        for (int row = 0; row < getHeight() - 2; row++) { //Row Loops through each row

                    boolean newRow = true;
                    boolean filled = false;
                    String textString = "";

                    while (!filled) {
                        if (newRow && !noWordsLeft) {  //adds the first word to the testString
                            textString = textString + wordArray.get(arrayIndex);
                            arrayIndex++;
                            newRow = false;
                        }
                        else if(arrayIndex > wordArray.size()) { //If no more words left
                            convertedTextMsg = convertedTextMsg + blankSpace;
                            filled = true;
                        }
                        else if ((arrayIndex != wordArray.size()) && ((textString.length() + 1 + wordArray.get(arrayIndex).length()) <= slots)) { //checks if the textString + next word and a space is smaller than space avaliable
                            textString = textString + " " + wordArray.get(arrayIndex);
                            arrayIndex++;
                        }
                        else { //if no more space then fill the padding and set to the new String
                            int spaceLeft = (slots - textString.length());
                            if (spaceLeft != 0) {
                                //Adds padding to left and right of the word
                                int leftPadding = Math.floorDiv(spaceLeft, 2);
                                int rightPadding = spaceLeft - leftPadding;

                                for (int l = 0; l < leftPadding; l++) {
                                    textString = " " + textString;
                                }
                                for (int r = 0; r < rightPadding; r++) {
                                    textString = textString + " ";
                                }
                            }

                            //Sets the word
                            convertedTextMsg = convertedTextMsg + textString;

                            //Sets condition to exit loop
                            filled = true;
                            if(arrayIndex == wordArray.size()) {
                                arrayIndex++;
                                noWordsLeft = true;
                            }

                        }
                    }
               }

        //draws onto canvas
        int charIndex = 0;
        char[] charTextMsgArray = convertedTextMsg.toCharArray();
        for (int row = getLocationY(); row < getLocationY() + getHeight(); row++) { //Row Y
            for (int col = getLocationX(); col < getLocationX() + getWidth(); col++) { //Col X

                if (isBorder(col, row)) { //Checks and draws border
                    canvas.setPointColor(col, row, getColor());
                    canvas.setPointText(col, row, getBorderChar());
                }
                else if (isInside(col, row)) { //checks and draws the inside and character
                    canvas.setPointText(col, row, ' ');
                    canvas.setPointColor(col, row, getColor());

                    //Draws text
                    canvas.setPointText(col, row, charTextMsgArray[charIndex]);
                    charIndex++;
                }
            }
        }
    }
}



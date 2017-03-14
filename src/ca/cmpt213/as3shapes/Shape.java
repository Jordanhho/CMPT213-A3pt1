package ca.cmpt213.as3shapes;


import java.awt.*;

/**
 * Created by Nova on 03/03/2017.
 */
public interface Shape {

    public int getLocationX();

    public int getLocationY();

    public void setBorderChar(char borderCharacter);

    public char getBorderChar();

    public void setColor(Color color);

    public Color getColor();

    public void draw(ca.cmpt213.as3shapes.Canvas canvas);
}


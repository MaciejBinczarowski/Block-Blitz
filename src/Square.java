
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Square extends Rectangle
{
    public Square()
    {
        super(40, 40);
        setStroke(Color.DARKGRAY);
        setFill(Color.BLACK);
    }

    public Square(Color color)
    {
        super(40, 40);
        setStroke(Color.DARKGRAY);
        setFill(color);
    }
}

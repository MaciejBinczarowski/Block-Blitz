
import javafx.scene.paint.Color;

public class ZFigure extends Figure
{
    // private Color Color.MEDIUMBLUE = Color.MEDIUMBLUE;
    // private Block[] IBlocks = {new Block(Color.MEDIUMBLUE, 0, 4), new Block(Color.MEDIUMBLUE, 0, 5), new Block(Color.MEDIUMBLUE, 0, 6), new Block(Color.MEDIUMBLUE,7, 6)};

    public ZFigure()
    {
        super("ZFigure", 1, new Block[] {new Block(Color.MEDIUMBLUE, 1, 3), new Block(Color.MEDIUMBLUE, 1, 4), new Block(Color.MEDIUMBLUE, 0, 4), new Block(Color.MEDIUMBLUE,0, 5)});
    }    
}

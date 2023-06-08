
import javafx.scene.paint.Color;

public class SFigure extends Figure
{
    // private Color Color.YELLOW = Color.YELLOW;
    // private Block[] IBlocks = {new Block(Color.YELLOW, 0, 4), new Block(Color.YELLOW, 0, 5), new Block(Color.YELLOW, 0, 6), new Block(Color.YELLOW,7, 6)};

    public SFigure()
    {
        super("SFigure", 2, new Block[] {new Block(Color.YELLOW, 0, 3), new Block(Color.YELLOW, 0, 4), new Block(Color.YELLOW, 1, 4), new Block(Color.YELLOW,1, 5)});
    }    
}

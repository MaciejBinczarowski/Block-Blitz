
import javafx.scene.paint.Color;

public class LFigure extends Figure
{
    // private Color Color.DEEPSKYBLUE = Color.DEEPSKYBLUE;
    // private Block[] IBlocks = {new Block(Color.DEEPSKYBLUE, 0, 4), new Block(Color.DEEPSKYBLUE, 0, 5), new Block(Color.DEEPSKYBLUE, 0, 6), new Block(Color.DEEPSKYBLUE,7, 6)};

    public LFigure()
    {
        super("LFigure", 2, new Block[] {new Block(Color.DEEPSKYBLUE, 0, 5), new Block(Color.DEEPSKYBLUE, 1, 3), new Block(Color.DEEPSKYBLUE, 1, 4), new Block(Color.DEEPSKYBLUE,1, 5)});
    }    
}

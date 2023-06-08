
import javafx.scene.paint.Color;

public class IFigure extends Figure
{
    // private Color Color.DEEPPINK = Color.DEEPPINK;
    // private Block[] IBlocks = {new Block(Color.DEEPPINK, 0, 4), new Block(Color.DEEPPINK, 0, 5), new Block(Color.DEEPPINK, 0, 6), new Block(Color.DEEPPINK,7, 6)};

    public IFigure()
    {
        super("IFigure", 0,new Block[] {new Block(Color.DEEPPINK, 0, 3), new Block(Color.DEEPPINK, 0, 4), new Block(Color.DEEPPINK, 0, 5), new Block(Color.DEEPPINK, 0, 6)});
    }
}

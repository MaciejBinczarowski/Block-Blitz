
import javafx.scene.paint.Color;

public class OFigure extends Figure
{
    // private Color Color.LIME = Color.LIME;
    // private Block[] IBlocks = {new Block(Color.LIME, 0, 4), new Block(Color.LIME, 0, 5), new Block(Color.LIME, 0, 6), new Block(Color.LIME,7, 6)};

    public OFigure()
    {
        super("OFigure", 0, new Block[] {new Block(Color.LIME, 0, 4), new Block(Color.LIME, 0, 5), new Block(Color.LIME, 1, 4), new Block(Color.LIME, 1, 5)});
    }

    @Override
    public void rotate()
    {

    }
}

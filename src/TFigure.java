
import javafx.scene.paint.Color;

public class TFigure extends Figure
{
    // private Color Color.GREY = Color.GREY;
    // private Block[] IBlocks = {new Block(Color.GREY, 0, 4), new Block(Color.GREY, 0, 5), new Block(Color.GREY, 0, 6), new Block(Color.GREY,7, 6)};

    public TFigure()
    {
        super("TFigure", 0, new Block[] {new Block(Color.GREY, 0, 4), new Block(Color.GREY, 1, 4), new Block(Color.GREY, 0, 3), new Block(Color.GREY,0, 5)});
    }    
}

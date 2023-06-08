
import javafx.scene.paint.Color;

public class JFigure extends Figure
{
    // private Color Color.DARKVIOLET = Color.DARKVIOLET;
    // private Block[] IBlocks = {new Block(Color.DARKVIOLET, 0, 4), new Block(Color.DARKVIOLET, 0, 5), new Block(Color.DARKVIOLET, 0, 6), new Block(Color.DARKVIOLET,7, 6)};

    public JFigure()
    {
        super("JFigure", 2, new Block[] {new Block(Color.DARKVIOLET, 0, 3), new Block(Color.DARKVIOLET, 1, 3), new Block(Color.DARKVIOLET, 1, 4), new Block(Color.DARKVIOLET,1, 5)});
    }    
}


public class FigureCopy extends Figure
{

    public FigureCopy(Figure figureToCopy, Block[] blocksCopy) 
    {
        super("copy", figureToCopy.getPivotCenterIndex(), blocksCopy);
    }
    
}

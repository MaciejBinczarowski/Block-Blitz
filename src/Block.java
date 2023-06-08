
import javafx.scene.paint.Color;

public class Block extends Square
{
    private int row;
    private int column;

    public Block(Color color, int row, int column)
    {
        super(color);
        this.row = row;
        this.column = column;
    }

    public Block(String name, Color color, int row, int column)
    {
        super(color);
        this.row = row;
        this.column = column;
    }

    public void moveDown()
    {
        this.row += 1;
    }

    public void moveRight()
    {
        this.column += 1;
    }

    public void moveLeft()
    {
        this.column -= 1;
    }

    public int getRow()
    {
        return this.row;
    }

    public int getColumn()
    {
        return this.column;
    }

    public void setRow(int row) 
    {
        this.row = row;
    }

    public void setColumn(int column) 
    {
        this.column = column;
    }
}

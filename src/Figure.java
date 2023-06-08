
import javafx.scene.layout.GridPane;

public abstract class Figure implements InterfaceFigure
{
    private final String name;
    protected final Block[] blocks;
    int pivotCenterIndex;

    public Figure(String name, int pivotCenterIndex,Block[] blocks)
    {
        this.name = name;
        this.blocks = blocks;
        this.pivotCenterIndex = pivotCenterIndex;
    }

    public void moveDown()
    {
        System.out.println(name + " moved down");
        for (Block block : blocks) 
        {
            block.moveDown();
        }
    }

    public void moveRight()
    {
        System.out.println(name + " moved right");
        for (Block block : blocks) 
        {
            block.moveRight();
        }
    }

    public void moveLeft()
    {
        System.out.println(name + " moved left");
        for (Block block : blocks) 
        {
            block.moveLeft();
        }
    }

    public void rotate()
    {
        Block pivotCenter = blocks[pivotCenterIndex];

        for (Block block : blocks) 
        {
            int currentColumn = block.getColumn();
            int currentRow = block.getRow();

            block.setColumn(currentRow + pivotCenter.getColumn() - pivotCenter.getRow());
            block.setRow(pivotCenter.getColumn() + pivotCenter.getRow() - currentColumn);           
        }
    }

    public String getName() 
    {
        return this.name;
    }

    public Block[] getBlocks() 
    {
        return blocks;
    }

    public int getPivotCenterIndex() 
    {
        return pivotCenterIndex;
    }

    protected Block[] copyBlocks()
    {
        Block[] blocksCopy = new Block[blocks.length];
        for (int blockNumber = 0; blockNumber < blocks.length; blockNumber++) 
        {
            Block blockCopy = new Block("copy", null, blocks[blockNumber].getRow(), blocks[blockNumber].getColumn());
            blocksCopy[blockNumber] = blockCopy;
        }

        return blocksCopy;
    }
}

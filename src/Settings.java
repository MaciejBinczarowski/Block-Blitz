
public class Settings 
{
    private static int rows = 20;
    private static int columns = 10;

    public static int getRows() 
    {
        return rows;
    }

    public static void setRows(int rows) 
    {
        Settings.rows = rows;
    }

    public static int getColumns() 
    {
        return columns;
    }

    public static void setColumns(int columns) 
    {
        Settings.columns = columns;
    }
}

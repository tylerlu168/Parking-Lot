import java.util.Arrays;

public class ParkingLot
{
    private ParkingSpace[] lot;
    private int rows;

    /**
     * Constructs a ParkingLot with an equal number of ParkingSpaces per row.
     *
     * Precondition: 0 < spaces
     *               0 < rows <= spaces
     *               0 < rows <= 26
     *
     * Postcondition: ParkingSpaces are not occupied.
     *                The first two ParkingSpaces in each row are accessible.
     *
     * @param spaces
     * @param rows
     */
    public ParkingLot(int spaces, int rows)
    {
        this.rows = rows;

        lot = new ParkingSpace[spaces];
        // ParkingLot(10, 2)
        int spacesPerRow = spaces / rows;                   // 5
        String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        for (int i = 0; i < lot.length; i++)
        {
            char letter = abc.charAt(i / spacesPerRow);
            int num = i % spacesPerRow + 1;
            lot[i] = new ParkingSpace(letter, num, false, num <= 2);
        }
    }

    /**
     * Sets the target ParkingSpace to occupied and returns true
     *      if it exists; returns false otherwise.
     * @param target
     * @return true if target exists in lot; false otherwise
     */
    public boolean occupy(String target)
    {
        for(ParkingSpace space : lot)
        {
            if(space.getLabel().equals(target))
            {
                space.setOccupied(true);
                return true;
            }
        }

        return false;
    }

    /**
     * @return the percentage of occupied ParkingSpaces
     */
    public double capacity()
    {
        double occupied = 0;

        for(ParkingSpace space : lot)
            if(space.isOccupied())
                occupied++;

        return occupied / lot.length;
    }

    /**
     * @return true if an accessible ParkingSpace is available; false otherwise
     */
    public boolean accessibleAvailable()
    {
        for(ParkingSpace space : lot)
            if(space.isAccessible() && !space.isOccupied())
                return true;

        return false;
    }

    /**
     * @param accessible true if the ParkingSpace should be accessible,
     *                   false if the ParkingSpace should not be accessible
     * @return the first ParkingSpace that is not occupied base on accessible;
     *          null if no available ParkingSpaces are found.
     */
    public ParkingSpace firstAvailable(boolean accessible)
    {
        for (int i = 0; i < lot.length; i++)
            if(lot[i].isAccessible() == accessible && !lot[i].isOccupied())
                return lot[i];

        return new ParkingSpace("A00", false, false);
    }

    public String toString()
    {
        String rtn = "";

        // ParkingLot(20, 4)
        int spacesPerRow = lot.length / rows;   // 5

        int row = 0;

        while(row < rows)
        {
            for (int i = spacesPerRow * row; i < spacesPerRow * (row + 1); i++)
            {
                rtn += lot[i].getLabel() + " ";
            }

            rtn += '\n';

            for (int i = spacesPerRow * row; i < spacesPerRow * (row + 1); i++)
            {
                if(lot[i].isAccessible())
                    rtn += "(";
                else
                    rtn += "[";

                if(lot[i].isOccupied())
                    rtn += "X";
                else
                    rtn += " ";

                if(lot[i].isAccessible())
                    rtn += ") ";
                else
                    rtn += "] ";
            }

            rtn += "\n";

            row++;
        }

        return rtn;
    }
}
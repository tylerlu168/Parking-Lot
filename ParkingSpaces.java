public class ParkingSpaces
{
    private boolean occupied;
    private String label;
    private boolean accessible;         // space is for people with disabilities

    /** Precondition: label is an alphabetic character followed by two digits
     * @param occupied
     * @param label
     * @param accessible
     */
    public ParkingSpaces(String label, boolean occupied, boolean accessible)
    {
        this.occupied = occupied;
        this.label = label;
        this.accessible = accessible;
    }

    /** precondition: num > 0 && num < 100
     *               letter is alphabetic
     * @param letter
     * @param num
     * @param occupied
     * @param accessible
     */
    public ParkingSpaces(char letter, int num, boolean occupied, boolean accessible)
    {
        String label = letter + "";

        if(num < 10)
            label += "0";
        label += num;

        this.occupied = occupied;
        this.accessible = accessible;
        this.label = label;
    }

    public boolean isOccupied() { return occupied; }

    public void setOccupied(boolean occupied) { this.occupied = occupied; }

    public String getLabel() { return label; }

    public void setLabel(String label) { this.label = label; }

    public boolean isAccessible() { return accessible; }

    public void setAccessible(boolean accessible) { this.accessible = accessible; }

    /**
     * @return a string representation of ParkingSpace in the format:
     *       A01 ( )       // accessible
     *       A01 [ ]      // not accessible
     *       A01 [X]     // not accessible, occupied
     */
    public String toString()
    {
        String rtn = label + " ";
        if(accessible)
            rtn += "(";
        else
            rtn += "[";

        if(occupied)
            rtn += "X";
        else
            rtn += " ";

        if(accessible)
            rtn += ")";
        else
            rtn += "]";

        return rtn;
    }
}


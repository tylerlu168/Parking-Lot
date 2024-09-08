public class Driver
{
    public static void main(String[] args)
    {
        ParkingLot myLot = new ParkingLot(5, 1);
        System.out.println(myLot);

        String[] spots = {"A01", "A03", "A04", "A05"};

        for(String spot : spots)
            myLot.occupy(spot);

        System.out.println(myLot);      // myLot.toString()
        System.out.println(myLot.capacity());
        System.out.println(myLot.accessibleAvailable());
        System.out.println(myLot.firstAvailable(false));
    }
}

package com.gojek;

/*
 * @author Ahmad Emir Alfatah
 */

public class Parking_lot
{
    private int MAX_SIZE = 0;
    private Car slot[];

    public void createParkingLot(String size)
    {
        MAX_SIZE = Integer.parseInt(size);
        slot = new Car[MAX_SIZE];
        System.out.println("Create a parking lot with "+size+" slots");
    }

    public void parkCar(String number, String colour)
    {
        System.out.println(number);
        System.out.println(colour);
    }

    public void leavePark(String slot)
    {
        System.out.println(slot);
    }

    public void status()
    {
        System.out.println("test size");
    }

    public void regNumWcol(String colour)
    {
        System.out.println(colour);
    }

    public void slotNumWcol(String colour)
    {
        System.out.println(colour);
    }

    public void slotNumWnum(String number)
    {
        System.out.println(number);
    }

}
package com.gojek;

/*
 * @author Ahmad Emir Alfatah
 */

public class Parking_lot
{
    private Car slot[];
    private int MAX_SIZE = 0;

    public void createParkingLot(String size)
    {
        MAX_SIZE = Integer.parseInt(size);
        slot = new Car[MAX_SIZE];
        System.out.println("Create a parking lot with "+size+" slots");
    }

    public void parkCar(String number, String colour)
    {
        int i = 0;
        boolean setSlot = false;
        while(i < MAX_SIZE && !setSlot)
        {
            if(slot[i] == null){
                Car car = new Car(number,colour);
                slot[i] = car;
                setSlot = true;
                System.out.println("Allocated slot number: "+(i+1));
            }else if(i == MAX_SIZE-1){
                System.out.println("Sorry, parking lot is full");
            }
            i++;
        }
        
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
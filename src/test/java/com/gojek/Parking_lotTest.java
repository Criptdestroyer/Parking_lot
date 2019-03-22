package com.gojek;

/*
 * @author Ahmad Emir Alfatah
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

 public class Parking_lotTest
 {
    private ByteArrayOutputStream output = new ByteArrayOutputStream();
    private Parking_lot parking_lot = new Parking_lot();
    @Before
    public void setStream()
    {
        System.setOut(new PrintStream(output));
    }

    @After
    public void cleanStream()
    {
        System.setOut(null);
    }

    @Test
    public void createParkingLotTest()
    {
        //expected
        int expectedMaxSize = 2;
        int expectedSlotSize = 2;
        Car expectedSlot[] = {null,null};
        boolean expectedTest = false;
        String expectedOutput = "Created a parking lot with 2 slots\n";

        //call function
        parking_lot.createParkingLot("2");

        //test
        assertEquals(expectedMaxSize, parking_lot.getMaxSize());
        assertEquals(expectedSlotSize, parking_lot.getSlot().size());
        assertEquals(expectedOutput,output.toString());
        assertEquals(expectedTest,cekSlot(expectedSlot));
    }

    @Test
    public void testParkCar()
    {
        //expected
        String expectedSizeNotSet = "Parking lot size must to set first\n";
        Car expectedSlot[] = {new Car("B 1120 AC","Gold"), null};
        boolean expectedTest = false;
        String expectedOutput = "Allocated slot number: 1\n"; 
        String expectedOutputFull = "Sorry, parking lot is full\n"; 

        //call function
        parking_lot.parkCar("B 1120 AC","Gold");

        //test if parking lot is not set
        assertEquals(expectedSizeNotSet,output.toString());
        parking_lot.createParkingLot("2");
        output.reset();
        
        //test park car
        parking_lot.parkCar("B 1120 AC","Gold");
        assertEquals(expectedOutput,output.toString());
        parking_lot.parkCar("B 1121 AC","Red");
        output.reset();

        //test if slot is full
        parking_lot.parkCar("B 1122 AC","Black");
        assertEquals(expectedOutputFull,output.toString());
        parking_lot.leavePark("2");

        //cek slot
        assertEquals(expectedTest,cekSlot(expectedSlot));
    }

    @Test
    public void testLeavePark()
    {
        //expected
        String expectedOutput = "Parking lot size must to set first\n"
                                +"Created a parking lot with 1 slots\n"
                                +"There is no car in slot 1\n"
                                +"Allocated slot number: 1\n"
                                +"Slot number 1 is free\n"
                                +"There is no slot with number 2\n";
        Car expectedSlot[] = {null};
        boolean expectedTest = false;

        //test if parking lot is not set
        parking_lot.leavePark("1");

        //test if there is no car in input slot 
        parking_lot.createParkingLot("1");
        parking_lot.leavePark("1");

        //test if slot is free
        parking_lot.parkCar("B 1120 AC","Gold");
        parking_lot.leavePark("1");

        //test if there is no leave number in slot
        parking_lot.leavePark("2");

        assertEquals(expectedOutput,output.toString());

        //cek slot
        assertEquals(expectedTest,cekSlot(expectedSlot));
    }


    public boolean cekSlot(Car expectedSlot[])
    {
        boolean cek = false;
        for(int i=0; i < expectedSlot.length; i++)
        {
            if((expectedSlot[i] != null && parking_lot.getSlot().get(i)!=null) || (expectedSlot[i] == null && parking_lot.getSlot().get(i) == null)){
                Car car1 = expectedSlot[i];
                Car car2 = (Car) parking_lot.getSlot().get(i);
                if(car1 != null && car2 != null){
                    if(car1.getRegNumber() != car2.getRegNumber() || car1.getColour() != car2.getColour() ){
                        cek = true;
                    }
                }
            }else {
                cek = true;
            }
        }
        return cek;
    } 
 }
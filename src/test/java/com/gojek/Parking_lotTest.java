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
        //call function
        parking_lot.createParkingLot("2");

        //expected
        int expectedMaxSize = 2;
        int expectedSlotSize = 2;
        Car expectedSlot[] = {null,null};
        boolean expectedTest = false;
        String expectedOutput = "Created a parking lot with 2 slots\n";

        //test
        assertEquals(expectedMaxSize, parking_lot.getMaxSize());
        assertEquals(expectedSlotSize, parking_lot.getSlot().size());
        assertEquals(expectedOutput,output.toString());
        
        boolean cek = false;
        for(int i=0; i < expectedSlot.length; i++)
        {
            if(expectedSlot[i] != parking_lot.getSlot().get(i)){
                cek = true;
            }
        }

        assertEquals(expectedTest,cek);
    }

    @Test
    public void testParkCar()
    {
        //call function
        parking_lot.parkCar("B 1120 AC","Gold");

        //expected
        String expectedSizeNotSet = "Parking lot size must to set first\n";
        Car expectedSlot[] = {new Car("B 1120 AC","Gold"), null};
        boolean expectedTest = false;
        String expectedOutput = "Allocated slot number: 1\n"; 
        String expectedOutputFull = "Sorry, parking lot is full\n"; 

        //test if MAX_SIZE is not set
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

        //test slot
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

        assertEquals(expectedTest,cek);
    }

    @Test
    public void testLeavePark()
    {
        
    }
 }
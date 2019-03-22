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
 }
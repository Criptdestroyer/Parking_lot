package com.gojek;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.FileNotFoundException;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class InputTest 
{
    // Input input = new Input("file_inputs.txt");
    // private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    // String expected = "create_parking_lot 6\npark KA-01-HH-1234 White\npark KA-01-HH-9999 White\npark KA-01-BB-0001 Black\npark KA-01-HH-7777 Red\npark KA-01-HH-2701 Blue\npark KA-01-HH-3141 Black\nleave 4\nstatus\npark KA-01-P-333 White\npark DL-12-AA-9999 White\nregistration_numbers_for_cars_with_colour White\nslot_numbers_for_cars_with_colour White\nslot_number_for_registration_number KA-01-HH-3141\nslot_number_for_registration_number MH-04-AY-1111";
    
    // @Before
    // public void setUpStreams()
    // {
    //     System.setOut(new PrintStream(outContent));
    // }

    // @After
    // public void cleanUpStreams()
    // {
    //     System.setOut(null);
    // }
    
    // @Test
    // public void parseFileInput() throws Exception
    // {
    //     input.fileParse("file_inputs.txt");
    //     assertEquals(expected, outContent.toString().trim().replace(" ", ""));
    //     //  input.fileParse("file_inputs.txt");
    //     // assertEquals("Invalidinput\nSorry,parkinglotisnotcreated", outContent.toString().trim().replace(" ", ""));
    // } 
}

package com.gojek;

/*
 * author : Ahmad Emir Alfatah
 */

import org.apache.commons.codec.digest.DigestUtils;

public class App 
{
    public static void main( String[] args )
    {
        //check argument 
        Input inputParser = new Input(args[0]);
        inputParser.parser();
    }
}

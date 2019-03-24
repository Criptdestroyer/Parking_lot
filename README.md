# Parking Lot v1.4.2 - GO_SQUADS TECH 3.0
### Author: Ahmad Emir Alfatah
<hr>
This is my solution for Parking Lot program assignment (<a>Parking Lot v.1.4.2.pdf</a>)

## Requirements
- JDK 8 or above
- Maven 3.5.3 or above // build tool
- Ruby // for Ruby functional specs

## Bin directory
In Parking_lot root directory has a bin directory for setup, testing and run the program
1. ```./bin/setup``` is a executable script for install dependencies and compile the code and then run ruby unit test suite
2. ```./bin/run_functional_tests``` is a executable script for run ruby unit test suite
3. ```./bin/parking_lot```
        or
    ```./bin/parking_lot [filename]``` is a executable script for runs the program and takes an input file as an argument


## Usage
#### 1. Build
```./bin/setup```
#### 2. Run Ruby functional specs
```./bin/run_functional_tests```
#### 3. Run Program
- File input mode:
```./bin/parking_lot file_inputs.txt```
- Interactive mode:
```./bin/parking_lot```

<b>If executable script not run please input command ```chmod +x [script file]``` in terminal. Then run again</b>


## Command
1. `create_parking_lot [Number of size slot]` 
    - command for create parking lot with number of size slot
    - output: `Created a parking lot with [Number of size slot] slots`

2. `park [Registration number] [Car colour]`
    - command for park car to the slot
    - output: `Allocated slot number: [number of slot]`

3. `leave [Number of slot]`
    - command for make car slot in input number is free
    - output: `Slot number [number of slot] is free`

4. `status`
    - command for check status of parking lot
    - output:
    ```
    Slot No.    Registration No    Colour
    [slot num] [Registration num]  [colour]
    ```

5. `registration_numbers_for_cars_with_colour [Car colour]`
    - command for search registration number of car with car colour
    - output: `[Registation number]`

6. `slot_numbers_for_cars_with_colour [Car colour]`
    - command for search slot number of car with car colour
    - output: `[slot number]`
    
7. `slot_number_for_registration_number [Registration number]`
    - command for search slot number with registration number
    - ouput: `[slot number`

8. `exit`
    - command for exit from iteractive method program
    - output: `exit the program`
<hr>

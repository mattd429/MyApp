package com.pluralsight.myapp;

//Single Type Imports 
import com.pluralsight.calengine.Adder;
import com.pluralsight.calengine.CalculateBase;
import com.pluralsight.calengine.CalculateHelper;
import com.pluralsight.calengine.Divider;
import com.pluralsight.calengine.InvalidStatementException;
import com.pluralsight.calengine.MathEquation;
import com.pluralsight.calengine.Multiplier;
import com.pluralsight.calengine.Subtractor;
import sun.nio.cs.ext.MacThai;

public class Main {
  
    public static void main(String[] args){
        //useMathEquation();
        //useCalculatorBase();
        
    String[] statements = {
            "add 1.0",            //Error: incorrect number of values
            "add xx 25.0",        //Error: non-numeric data
            "addX 0.0 0.0",       //Error: invalid command
            "divide 100.0 50.0",  //100.0 / 50.0 = 2.0 
            "add 25.0 92.0",      //25.0 + 92.0 = 117.0
            "subtract 225.0 17.0",//225.0 - 117.0 = 108.0
            "mulitply 11.0 3.0"   //11.0 * 3.0 = 33.0
    
    };
    
    CalculateHelper helper = new CalculateHelper();
    //Loop through all the statemetns in array class CalculateHelper
    //Tell helper to process them
    //Ask the helper to write it out.
    for (String statement : statements)
      try {
        helper.process(statement);
        System.out.println(helper);
      } catch(InvalidStatementException e) {
          System.out.println(e.getMessage());
          if(e.getCause() != null)
            //look back at getCause and getMessage -- prints out for input string: "xx"
            //getCause is ran under non-numeric becuase of the 2nd constructor
            //in InvalidStatementException(has class throwable with cause method)
            //we see in our CalculateHelper class that we throw string "xx" is invlaid needs to be
            //a number instead of letters will result in compile error
            System.out.println("Original exception: " + e.getCause().getMessage());
          }
          
    } 

}

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
        //useCalculateHelper();
        
    String[] statements = {
            "add 25.0 92.0",      //25.0 + 92.0 = 117.0
            "power 5.0 2.0"      //5.0 ^ 2.0 = 25.0 
    
    };
      
    //run the synamic helper vaiable and new up a dynamic helper and pass in a new array for MathProcessing[]
    DynamicHelper helper = new DynamicHelper(new MathProcessing [] {
          //add the implementations we have for MathPRocessing which at thsi point is just Add and Power
          new Adder(),
          new PowerOf()
    });
      
    for (String statement : statments) {
        //loop through each statement and pass them into our helper.
        //the string is called output which is equaled to helper which is our new variable in Main
        //we want to run the method String process(statement) in our DynamicHelper class
        String output = helper.process(statement);
        //we will print our the results for helper.
        System.out.println(output;)
    }

          
    }
  static void useCalculateHelper() {
    String[] statements = {
          "add 1.0",			//Error: incorrect number of values
					"add xx 25.0",		//Error: non-numeric data
					"addX 0.0 0.0",		//Error: invalid command
					"divide 100.0 50.0", //100.0 / 50.0 = 2.0
					"add 25.0 92.0", //25.0 + 92.0 = 117.0
					"substract 225.0 17.0", //225.0 - 17.0 = 108.0
					"multiply 11.0 3.0" //11.0 * 3.0 = 33.0
      
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
    /*MathEquation testEquation = new MathEquation();
		testEquation.execute();
		System.out.print("test=");
		System.out.println(testEquation.getResult());*/

		MathEquation[] equations = new MathEquation[4];
		equations[0] = new MathEquation('d', 100.0d, 50.0d); //these are instances of arrays
		equations[1] = new MathEquation('a', 25.0d, 92.0d);
		equations[2] = new MathEquation('s',225.0d, 17.0d);
		equations[3] = new MathEquation('m',11.0d, 3.0d);

		for(MathEquation equation : equations) {
			//call the array MathEquation call the variable equation, and loop through equations
			equation.execute();
			//it will call execute method and run the switch statement in class MathEquations.
			System.out.print("Result = ");
			System.out.println(equation.getResult());
		}

		System.out.println();
		System.out.println("Using Overloads");
		System.out.println();

		double leftDouble = 9.0d;
		double rightDouble = 4.0d;

		int leftInt = 9;
		int rightInt = 4;

		MathEquation equationOverload = new MathEquation('d');

		equationOverload.execute(leftDouble, rightDouble);
		System.out.print("result=");
		System.out.println(equationOverload.getResult());

		equationOverload.execute(leftInt, rightInt);
		System.out.print("result=");
		System.out.println(equationOverload.getResult());

		//will not be able to run int becuase its a narrowing conversion not legal
		//so instead it will run both ints as a double
		equationOverload.execute((double)leftInt, rightInt);
		System.out.print("result=");
		System.out.println(equationOverload.getResult());

		System.out.println();
		System.out.println("Using Inheritance");
		System.out.println();

		CalculateBase[] calculators = {
				new Divider(100.0d, 50.0d),
				new Adder(25.0d, 92.0d),
				new Subtracter(225.0d, 17.0d),
				new Multiplier(11.0d, 3.0d)
		};
		//declaring varible called calculator that's going to loop through our calculators.
		//then inside each calculator calls calculate method
		for (CalculateBase calculator:calculators) {
			calculator.calculate();
			System.out.print("result=");
			System.out.println(calculator.getResult());
		}

  }

}

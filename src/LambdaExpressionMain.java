
public class LambdaExpressionMain {

	public static void main(String[] args) {
		int num1 = 50;
		int num2 = 100;
		MathematicalOperation mo = new MathematicalOperation();
		Operator subtraction = (a, b) -> a - b;
		int num3 = mo.performMathFunction(num1, num2, subtraction);
		System.out.println("Subtraction is " + num3);
		int num4 = mo.performMathFunction(num1, num2, (a, b) -> a * b);
		System.out.println("Multiplcations is " + num4);
		
		System.out.println("Its time to play with some strings ");
		
		String input = "This is just greatness";
		
		StringOperation sop = new StringOperation();
		System.out.println("After operation "+sop.performStringOperation(input, String::toUpperCase));
		

	}

}

/* classs to wrap the Math operation */
class MathematicalOperation {
	public int performMathFunction(int a, int b, Operator o) { /* Behavior will be passed from the calling class*/
		return o.perform(a, b);
	}
}
/* classs to wrap the String operation */
class StringOperation {
	public String performStringOperation(String s, StringOperator o) { /* Behavior will be passed from the calling class */
		return o.perform(s);
	}
}

@FunctionalInterface /* Function interface always has a single method */
interface Operator {
	public int perform(int a, int b);
}

@FunctionalInterface /* Function interface always has a single method */
interface StringOperator {
	public String perform(String s);
}

import org.jgap.gp.CommandGene;
import org.jgap.gp.GPFitnessFunction;
import org.jgap.gp.IGPProgram;
import org.jgap.gp.terminal.Variable;

public class RegressionFitnessFunction extends GPFitnessFunction {

	private Float[] x;
	private Float[] y;

	public RegressionFitnessFunction(Float[] x, Float[] y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	protected double evaluate(IGPProgram ind) {
		double error = 0.0f;
		Object[] noargs = new Object[0];
		// Evaluate function for input numbers 0 to 20.
		// --------------------------------------------
		for (int i = 0; i < 20; i++) {
			// Provide the variable X with the input number.
			// -------------------------------------------------------------
			CommandGene var = ind.getNodeSets()[0][0];
			if(var instanceof Variable){
				Variable v = (Variable) var;
				v.set(x[i]);
			}else {
				System.out.println("KILL ME PLEASE!!!");
			}
			try {
				// Execute the GP program representing the function to be evolved.
				// As in method create(), the return type is declared as float (see
				// declaration of array "types").
				// ----------------------------------------------------------------
				double result = ind.execute_float(0, noargs);
				// Sum up the error between actual and expected result to get a defect
				// rate.
				// -------------------------------------------------------------------
				error += Math.abs(result - y[i]);
				// If the error is too high, stop evlauation and return worst error
				// possible.
				// ----------------------------------------------------------------
				if (Double.isInfinite(error)) {
					return Double.MAX_VALUE;
				}
			} catch (ArithmeticException ex) {
				// This should not happen, some illegal operation was executed.
				// ------------------------------------------------------------
				System.out.println("x = " + x[i].floatValue());
				System.out.println(ind);
				throw ex;
			}
		}
		// In case the error is small enough, consider it perfect.
		// -------------------------------------------------------
		if (error < 0.0001) {
			error = 0.0d;
		}
		return error;
	}

}
import org.jgap.FitnessFunction;
import org.jgap.IChromosome;
import org.jgap.gp.impl.GPGenotype;

public class RegressionFitnessFunction extends FitnessFunction {

	private double[] testXImputs;
	private double[] testYOutputs;

	public RegressionFitnessFunction(double[] testXImputs, double[] testYOutputs) {
		super();
		this.testXImputs = testXImputs;
		this.testYOutputs = testYOutputs;
	}



	@Override
	protected double evaluate(IChromosome arg0) {
		GPGenotype gp;
		gp.
	}

}

package com.placester.test;

/*
 * Implement a 6 sided die with weights on the sides, so that we don't have an even probability distribution, but it is 
 * weighted by a list of weights passed in at construction time
 * 
 * After 10k iterations of throwing this die, the results should closely match the desired distribution, and this should
 * be reproducible in the unit test in
 * 
 * src/test/com/placester/test/WeightedDiceTest
 */
public class SixSidedWeightedDie extends WeightedDie
{
    //NOTE: since these are weights on a probability distribution, these should sum to one, and the incoming array
    // should be of length 6. You should throw if either of these preconditions is false
    private int[] sidesSet;
    public SixSidedWeightedDie(float[] weights)
    {
        super(weights);
        try {
            if (weights.length) != 6 throw new IIOException("The number of weights should be 6, please fix.");
            float sum = 0.0;
            for (float i : weight) sum += sum;
            if (sum != 1.0) throw new IIOException("The sum of weights should be 1.0, please fix.")
        
            
        }
        catch (Exception e)
        {
            System.err.println(e);
        }
        
        
    }
        // TODO Auto-generated constructor stub
    }

    //Throw the die: this should produce a value in [1,6]
    @Override
    public int throwDie()
    {
        // TODO Auto-generated method stub
        return 0;
    }

}

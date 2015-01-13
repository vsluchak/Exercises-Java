package com.placester.test;

//import javax.imageio.IIOException;

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
    private int[] sidesSet = new int[100];  
    private int[] frequency = new int[6];
    
   public SixSidedWeightedDie(float[] weights) 
    {
        super(weights);
        try {
            if (weights.length != 6) throw new Exception("The number of weights should be 6, please fix.");
            float sum = 0.0f;
            for (float w : weights) sum = sum + w ;
            System.out.println("Sum: " + sum);
            if (sum != 1.0f) throw new Exception("The sum of weights should be 1.0, please fix.");
        // Fill up the sides set with the numbers from 1 to 6 repeated according to the weights
        int start = 0;
        int end = 0 ;
        for (int i=0;i<6;i++)
        {
        frequency[i] = (int)(100*weights[i]);
        end = start + frequency[i];     
        for (int j=start;j<end;j++) 
        { 
            sidesSet[j] = i+1 ;
        }
        start = end;
        }
        }
        catch (Exception e)
        {
            System.err.println(e);
        }
        
        
    }
        // TODO Auto-generated constructor stub
    

    //Throw the die: this should produce a value in [1,6]
    @Override
    public int throwDie()
    {
        // TODO Auto-generated method stub
        int randomChoice = (int)(100*Math.random());
        //return (1);
        return sidesSet[randomChoice];
        
    }

}

import java.util.*;


public class probaDistro{
    public static void main (String[] args) {
        long startTime = System.nanoTime();
        String[] testString = new String[1000];
        int[] testInt = new int[1000];
        String[] ref = {"0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111","1000", "1001", "1010", "1011", "1100", "1101", "1110", "1111" };
        int[] refInt = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        int[] counter = new int[16];
        double[] proba = new double[16];
        double sum = 0;
        double mean;

        for (int i = 0; i < testString.length; i++)
        {
            testString[i] = ref[(int)(Math.random()*4) + 6];
            //testString[i] = ref[8];
        }
        
        for (int i = 0; i < testString.length; i++)
        {
            for (int j = 0; j < ref.length; j++)
            {
                if(testString[i] == ref[j])
                {
                    testInt[i] = j;
                }
            }
            
        }
        
        
        
        System.out.print("Binary String: " + testString[50] + " Equivalent Decimal: ");
        System.out.println(testInt[50]);
        
        for (int i = 0; i < testString.length; i++)
         {
             for (int j = 0; j < ref.length; j++)
             {
                 if(testString[i] == ref[j])
                 {
                     counter[j]++;
                 }
             }
         
         }
        for (int i = 0; i < counter.length; i++)
        {
            sum += counter[i];
        }
        System.out.println(sum);
        int sumTotal = 0;
        for (int i = 0; i < refInt.length; i++)
        {
            sumTotal += refInt[i] * counter[i];
        }
        
        mean = (int)(sumTotal / (double)testString.length);
        double standardDeviation = 0;
        
        for(int i = 0; i < refInt.length; i++) {
            standardDeviation += Math.pow(testInt[i] - mean, 2);
        }
        standardDeviation = (int)(Math.sqrt(standardDeviation/refInt.length));
        
        System.out.println("Sum Total: " + sumTotal);
        System.out.println("Mean: " + mean);
        System.out.println("Standard Deviation: " + standardDeviation);
        
        for (int i = 0; i < proba.length; i++)
        {
            proba[i] = (1/(standardDeviation * Math.sqrt(2*Math.PI)))*(Math.exp((-1*((Math.pow(refInt[i] - mean,2))/(2*(Math.pow(standardDeviation,2)))))));
        }
        

        for (int i = 0; i < proba.length; i++){
            /*System.out.print(counter[i]);
            System.out.print(" ");
            System.out.println((counter[i]/sum));
             */
            //proba[i] = (double)(counter[i]/sum);
        }
        
        
        
        
        for (int i = 0; i < proba.length; i++)
        {
            System.out.print("Reference Integer: ");
           // System.out.println(proba[i]);
            System.out.print(refInt[i]);
            System.out.print(" Probability: ");
            System.out.print(proba[i]);
            System.out.print(" Counter: " );
            System.out.println(counter[i]);
            System.out.println("------------------------------------");
        }
        long endTime   = System.nanoTime();
        long totalTime = (endTime - startTime);
        //System.out.println(totalTime);
        
    }
}



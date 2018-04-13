import java.util.*;
public class ConcurrentArraySum implements Runnable {

public static int NUM_THREADS = 1; // modify: select 1,2,3,4 (also try far more than cores are on your machine)
public static enum ALGORITHM { BASELINE, SYNCHRONIZED, VOLATILE, LOCAL};
public static ALGORITHM algorithm = ALGORITHM.LOCAL; // modify: choose from the enum in line 4

public final static int Array_SIZE = 5000 * 10000; // reduce if java.lang.OutOfMemoryError is thrown
public static volatile long volatile_counter = 0;

public static long[] Array;
public static long[] ArraySumResult;

private final int sliceNumber;
private final int ArrayStartIndex;
private final int ArrayEndIndex;


    public ConcurrentArraySum(int sliceNumber, int numberOfSlices)
    {    	
        this.sliceNumber = sliceNumber;
       
        int chunkSize = Array_SIZE/NUM_THREADS +1;
       
        this.ArrayStartIndex = sliceNumber * chunkSize;
       
        //limit the end index by size of Array
        this.ArrayEndIndex =  (this.ArrayStartIndex + chunkSize) < Array_SIZE ?
                               (this.ArrayStartIndex + chunkSize) : Array_SIZE ;       
    }

    public void run()
    {
//        System.out.println("Thread " + (sliceNumber + 1) + " starts adding Array elements from index "
//                + ArrayStartIndex + " to " + (ArrayEndIndex - 1) + ".");
       
       
           
	    switch(algorithm) 
	    {
		    case BASELINE:
		        for (int i = ArrayStartIndex; i < ArrayEndIndex ; i++)
				{
		          ArraySumResult[sliceNumber] += Array[i]; 
				}
		    break;
		        	
		    case SYNCHRONIZED:
		    	
		        for (int i = ArrayStartIndex; i < ArrayEndIndex ; i++)
				{
		          	synchronized(ArraySumResult) 
		          	{ 
		          		ArraySumResult[sliceNumber] += Array[i]; 
		          	}
				}
		    break;    
		        
		    case VOLATILE:
		        for (int i = ArrayStartIndex; i < ArrayEndIndex ; i++)        	
		        {
		        	volatile_counter+=Array[i];
		        }
		    break;
		        	
		    case LOCAL:
		    	final ThreadLocal<Long> local_array = new ThreadLocal<Long>();
		    	for (int i = ArrayStartIndex; i < ArrayEndIndex ; i++)
		    	{
		    		local_array.set(Array[i]);
		    	}
		    			    	
		    break;
		        
		    default:
		    	 System.out.println("Algorithm not implemented:" + algorithm);
		    	 
	    }   
    }
   
   
    private static void runArraySumTest()
            throws InterruptedException //pass on from call to join
    {
        Thread[] threads = new Thread[NUM_THREADS];
       
        for(int i = 0 ; i < threads.length; ++i) 
            threads[i] = new Thread(new ConcurrentArraySum(i,NUM_THREADS));
 
        for(Thread t:threads)
            t.setPriority(Thread.MAX_PRIORITY);
        
        for(Thread t:threads)
            t.start();
       
        for(Thread t:threads)
            t.join();   
    }

   
    public static void main(String[] args)
        throws Exception //pass on from call to join in runArraySumTest()
    {
    	   for(int xx=0; xx<5; xx++){
    	   for(int xxx = 0; xxx<16; xxx++){
        Array = new long[Array_SIZE];
        ArraySumResult = new long[NUM_THREADS]; //initialized to 0 by default
       
        //initialize Array with random values and compute checksum
        int sequentialCheckSum = 0;
        
        //initialize array with deterministic random numbers
        Random rand = new Random(0);
        for(int i = 0; i < Array_SIZE ; ++i)
            sequentialCheckSum += Array[i] = (int)(rand.nextFloat() * 10);
               
        //run test and measure runtime as accurately as possible
        long startTime = System.nanoTime();
        runArraySumTest();
        long endTime = System.nanoTime();
       
//        System.out.println("Adding " + Array_SIZE + " array elements with "
//                        + NUM_THREADS + " thread" + ((NUM_THREADS>1)?"s":"") + " took "
//                        + (endTime-startTime)/1000 + " microseconds.");
//        System.out.println("Sequenctial result: " + sequentialCheckSum);
          System.out.println((endTime-startTime)/1000);
        
        long parallelResult = 0;
        for(int i = 0 ; i < ArraySumResult.length; ++i)
            parallelResult += ArraySumResult[i];
           
//        System.out.println("Parallel result: " + parallelResult);
//        System.out.println("Volatile counter: " + volatile_counter);
        
//        	System.out.println("-- Thread Separator, currently testing " + NUM_THREADS + " threads --");   
        	NUM_THREADS++;
           
       	  }
    	   NUM_THREADS = 1;
    	   System.out.println("Test"+xx);
       }
    }
}
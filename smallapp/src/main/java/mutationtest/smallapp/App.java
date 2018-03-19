package mutationtest.smallapp;

/**
 * Hello world!
 *
 */
public class App 
{
	public double add(double a,double b)
	{
		return a+b;
	}
	public int addint(int a,int b)
	{
		return a+b;
	}
	
	public double minus(double a,int b)
	{
		return a-b;
	}
	
	public int bigger(int a,int b)
	{
	    if(a>=b)
	    {
	        return 1;
	    }
	    
        return 0;
	    
	}
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}

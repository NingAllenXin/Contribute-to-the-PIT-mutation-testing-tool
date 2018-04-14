package mutationtest.smallapp;

/**
 * Hello world!
 *
 */
public class App 
{
    double Dou;
    int Int;
//	public double add(double a,double b)
//	{
//		return a+b;
//	}
//	public int addint(int a,int b)
//	{
//		return a+b;
//	}
//	
//	public double minus(double a,double b)
//	{
//		return a-b;
//	}
//	
//	public int biggerequal(int a,int b)
//	{
//	    if(a>=b)
//	    {
//	        return 1;
//	    }
//	    
//        return 0;
//	    
//	}
//	public double muti(double a,double b)
//	{
//	    return a*b;
//	}
    public int checkM1(int num,App a)
    {
        if(num==1)
        {
            return a.Int;
        }
        else
        {
            return new App().Int;
        }
    }
    public int checkM1(int num)
    {
        if(num==1)
        {
            return null;
        }
        else
        {
            return new App();
        }
    }
    public static void main( String[] args )
    {
        App a=null;
        new App().checkM1(2,a);
        
    }
}

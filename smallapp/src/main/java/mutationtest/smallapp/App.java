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
//	    a=a+b;
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
//    public int checkM1(int num,App a)
//    {
//        if(num==1)
//        {
//            return a.Int;
//        }
//        else
//        {
//            return new App().Int;
//        }
//    }
//    public int  checkM1()
//    {
//        
//        App a = null;
//        return a.Int;
//            
//    }
    public int checkM4()
    {
        int a = 0;
        int c = 0;
         a = 3;  
        return a;
    }
//    public int checkM2(int i,int j)
//    {
//       return 2; 
//    }
//    public int checkM2(int i)
//    {
//        return 1;
//    }
//    public double checkselfadd(int a)  //a -> a++
//    {
//        double b=1.0;
//        double k=b;
//        k=b;
//        return k==1.0?1.0:k;
//        
//    }
//    public double checkNEG(int a)   //already tested right for NEG
//    {
//        double b=1.0;
//        String s = String.valueOf(b);
//        return s.equals("1.0")?1.0:Double.valueOf(s.substring(1,s.length()));
//        
//    }
//  public double checkselfadd(int a)   //already tested right for NEG
//  {
//      double b=1.5;
//      String s = String.valueOf(b);
//      System.out.println(b);
//      return s.equals("1.0")?1.0:Double.valueOf(s.substring(1,s.length()));
//      
//  }
//    public double checkselfadd(double a)
//    {
//        double b=1.0;
//        String s=String.valueOf(b);
//        s=String.valueOf(b);
//        return s.equals("1.0")?1.0:(Double.valueOf(s));
//    }
//    public int checkAND(int c) {
//        int a = 1;
//        int b = 2;
//        String s = String.valueOf((a & b));
//        return s.equals("0") ? 0 : Integer.valueOf(s)-3;
//    }
    public static void main( String[] args )
    {
        App a=new App();
       //System.out.println(a.checkselfadd(2));
    }
}

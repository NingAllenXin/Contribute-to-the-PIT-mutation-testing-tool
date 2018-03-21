package mutationtest.smallapp;

import org.junit.Test;

import junit.framework.TestCase;
/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
//    @Test
//    
//    public void testApp()
//    {
//    		App a=new App();
//        assertEquals( 1.0,a.add(0.0, 1.0) );
//    }
//
// @Test
// 
// public void testApp3()
// {
// 		App a=new App();
//     assertEquals( 1.0,a.minus(3.0, 2) ); //3.0-2=1  should survive in AOR (3%2=1)
// }
//    @Test
//    
//    public void testApp3()
//    {
//           App a=new App();
//        assertEquals( 3.0,a.minus(5.0, 2) ); //3.0-2=1  should be killed in AOR 
//    }
//    @Test
    
//    public void testROR()
//    {
//           App a=new App();
//        assertEquals( 1,a.bigger(5, 2) ); //3.0-2=1  should survive in ROR 
//    }
 @Test
 
 public void testApp4()
 {
 		App a=new App();
     assertEquals(2,a.addint(0, 2) );
 }
}

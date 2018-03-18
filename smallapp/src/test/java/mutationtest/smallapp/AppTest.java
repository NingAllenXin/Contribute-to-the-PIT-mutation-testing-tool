package mutationtest.smallapp;

import org.junit.Test;

import junit.framework.TestCase;
/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    @Test
    
    public void testApp()
    {
    		App a=new App();
        assertEquals( 1.0,a.add(1.0, 0.0) );
    }
 @Test
    
    public void testApp2()
    {
    		App a=new App();
        assertEquals( 5.0,a.add(3.0, 2.0) );
    }
 @Test
 
 public void testApp3()
 {
 		App a=new App();
     assertEquals( 3.0,a.minus(5.0, 2) );
 }
 @Test
 
 public void testApp4()
 {
 		App a=new App();
     assertEquals(2,a.addint(2, 0) );
 }
}

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
        assertEquals( 2,a.add(1, 1) );
    }
}

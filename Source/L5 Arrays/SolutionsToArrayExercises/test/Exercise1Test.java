/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sd3.src.com.Ex1;

/**
 *
 * @author Alan.Ryan
 */
public class Exercise1Test {
    
   
    
    @Test
    public void testSmallestInArray() {
        
        int array[] = {12, 81, 16, 89,7, 45};
        assertEquals(7, Ex1.determineSmallest(array));
        
    }
}

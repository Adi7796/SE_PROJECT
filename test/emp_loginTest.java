/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author adity
 */
public class emp_loginTest {
    
    public emp_loginTest() {
        
        
    }

    /**
     * Test of main method, of class emp_login.
     */
    @Test
    public void testMain() {
    String username="Aditya7796";
        String id ="1001";
        String item = "See Salary Details";
        emp_login login = new emp_login(username,id,item);
    }
    @Test
    public void login(){
        login_page login = new login_page();
        String username="Aditya7796";
        String password="Sephiroth";
        String e_id="1001A";
        login.test(username, password, e_id);
        
    }
    @Test
    public void bm_login(){
        Branch_login bm=new Branch_login();
        String bm_uname="Hem45";
        String bm_id="BM_1520";
        String password="12345";
    }
}

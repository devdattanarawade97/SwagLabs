package SwagLabs;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwagLabsMain {

    // WebDriver driver;
    // public SwagLabs(WebDriver driver){
    //    this.driver= driver;
    // }
    public static boolean TestCase01(WebDriver driver) throws InterruptedException{
    	
       boolean status=true;
       driver.manage().window().maximize();
        Home home = new Home(driver);
        System.out.println("opening website");
        home.getHome("https://www.saucedemo.com/"); //1
        Login login= new Login(driver);
       
       status= login.loginCart("standard_user","secret_sauce");//2
       System.out.println("login to cart successfully:"+status);
        AddToCart add= new AddToCart(driver);
        
        status= add.addToCart("Sauce Labs Backpack");    //3
        System.out.println("adding Sauce Labs Backpack to cart successfully:"+status);
        status=add.addToCart("Sauce Labs Bolt T-Shirt");
        System.out.println("adding Sauce Labs Bolt T-Shirt to cart successfully:"+status);
        Checkout check= new Checkout(driver);
        System.out.println("opening cart");
        check.clickOnCart();     //4
        List<String>list=new ArrayList<>(Arrays.asList("Sauce Labs Backpack","Sauce Labs Bolt T-Shirt"));
        status=check.verifyCartContent(list);
        if(!status) {
        	System.out.println("verification of cart content successfull :"+status);
        }
        System.out.println("verfication of cart content successfull :"+status);
        check.checkout();        //6
        status= check.address("Devdatta", "n", "111000");//6
        System.out.println("adding address successfull :"+status);
        status= check.order();         //8
        System.out.println("placing order successfull :"+status);
        driver.quit();
        return status;
    }

    public static void main(String[] args) throws InterruptedException{

        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        int testCount=0;
      boolean val= TestCase01(driver);
      if(val){
        testCount++;
        System.out.println("total testcase passed: "+testCount );
      }
    }
    
}


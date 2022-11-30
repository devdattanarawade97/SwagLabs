package SwagLabs;


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
        System.out.println("login to cart");
        login.loginCart("standard_user","secret_sauce");//2
        AddToCart add= new AddToCart(driver);
        System.out.println("adding to cart");
        add.addToCart("Sauce Labs Backpack");    //3
        add.addToCart("Sauce Labs Bolt T-Shirt");
        
        Checkout check= new Checkout(driver);
        System.out.println("opening cart");
        check.clickOnCart();     //4
        check.checkout();        //5
        System.out.println("adding address");
        check.address("Devdatta", "n", "111000");//6
        System.out.println("placing order");
        check.order();         //7
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


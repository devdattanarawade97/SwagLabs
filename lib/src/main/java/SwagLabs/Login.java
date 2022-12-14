package SwagLabs;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login {
 WebDriver driver;
    public Login(WebDriver driver){
    this.driver=driver;
    }

    public boolean loginCart(String Username, String Password) throws InterruptedException{
        boolean status=false;
        try{
        WebElement username=driver.findElement(By.id("user-name"));
        username.sendKeys(Username);
        Thread.sleep(2000);
        WebElement password=driver.findElement(By.id("password"));
        password.sendKeys(Password);
        Thread.sleep(2000);
        WebElement loginButton=driver.findElement(By.xpath("//input[@id='login-button']"));
        loginButton.click();
        Thread.sleep(2000);
        if(driver.getCurrentUrl().endsWith("inventory.html")){
            status= true;
          
        }
        
    }catch(Exception e){
        System.out.println("login failed with exception :"+e.getMessage());
       return status;
    }
    return status;
    }
    
}



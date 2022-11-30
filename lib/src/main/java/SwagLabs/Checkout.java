package SwagLabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Checkout {

WebDriver driver;
public Checkout(WebDriver driver){
    this.driver=driver;
}

public boolean clickOnCart(){
    boolean status=false;
    WebElement cartButton=driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
    cartButton.click();
    if(driver.getCurrentUrl().endsWith("cart.html")){
        status= true;
    }
    else{
    return status;
    }
    return status;
    
}

public boolean checkout(){
    boolean status=false;
    WebElement checkoutButton=driver.findElement(By.xpath("//button[@id='checkout']"));
    checkoutButton.click();
    if(driver.getCurrentUrl().endsWith("checkout-step-one.html")){
        status= true;
    }
    else{
    return status;
    }
    return status;
}

public boolean address(String firstName1,String lastName1,String zipCodeNumber) throws InterruptedException{
    boolean status=false;
    WebElement firstName=driver.findElement(By.id("first-name"));
    firstName.sendKeys(firstName1);
    Thread.sleep(2000);
    WebElement lastName=driver.findElement(By.id("last-name"));
    lastName.sendKeys(lastName1);
    Thread.sleep(2000);
    WebElement zipCode=driver.findElement(By.id("postal-code"));
    zipCode.sendKeys(zipCodeNumber);
    Thread.sleep(2000);
    WebElement conitnueButton=driver.findElement(By.xpath("//input[@id='continue']"));
    conitnueButton.click();
    Thread.sleep(2000);
    if(driver.getCurrentUrl().endsWith("checkout-step-two.html")){
        status= true;
    }
    else{
    return status;
    }
    return status;
   
}


public boolean order() throws InterruptedException{
    boolean status=false;
    try{
    WebElement finishButton=driver.findElement(By.xpath("//button[@id='finish']"));
    finishButton.click();
    Thread.sleep(2000);
    if(driver.getCurrentUrl().endsWith("checkout-complete.html")){
        status= true;
    }
    }catch(Exception e){
    System.out.println("failed with Exception:"+e.getMessage());
    return status;
    }
    return status;
   
}
    
}


package SwagLabs;

import org.openqa.selenium.WebDriver;

public class Home {
 
    WebDriver driver;
    Home(WebDriver driver){
      this.driver=driver;
    }
    public boolean getHome(String url){
       if(!driver.getCurrentUrl().equals(url)){
       driver.get(url);
      
       }
       return true;
    }
    
}

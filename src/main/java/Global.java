import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Global {
    public WebDriver driver;

    public Global(WebDriver d){
        this.driver=d;
    }

    public void isVisibleinPage(WebElement element){
        loadPage();
        try{
            WebDriverWait wait = new WebDriverWait(driver,80);
            wait.until(ExpectedConditions.visibilityOf(element));
        }catch(Exception ex){
            System.out.println("isVisibleinPage no pudo detectar el objeto: "+ex.getMessage());
        }
    }

    public void isEditable(WebElement element){
        loadPage();
        try{
            WebDriverWait wait = new WebDriverWait(driver,100);
            wait.until(ExpectedConditions.elementToBeClickable(element));

        }catch(Exception ex){
            System.out.println("isEditable no pudo detectar el objeto: "+ex.getMessage());
        }
    }

    public void waitTillObjectHasAttr(WebElement elem,String attr,String value){
        WebDriverWait wait = new WebDriverWait(driver,100);
        wait.until(ExpectedConditions.attributeContains(elem,attr,value));
    }

    public Boolean checkIsDisplayed(WebElement elem, WebElement parent){
        Boolean check=false;
        try{
            check=elem.isDisplayed();
        }catch(Exception ex){
            check=true;
        }
        return check;
    }

    public void loadPage(){
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(pageLoadCondition);
    }


}

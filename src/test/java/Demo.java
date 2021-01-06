import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Demo extends BaseTest{

    Global glo= new Global(driver);

    @Test
    private void demo() throws InterruptedException {

        String productoBuscar="Smart TV Noblex";
        String valorEsperado="$36.999";

        Thread.sleep(3000);
        WebElement inputSearch = driver.findElement(By.id("autocomplete-input"));
        inputSearch.sendKeys(productoBuscar);
        inputSearch.sendKeys(Keys.ENTER);

        //selecciono el primer item
        WebElement divProduct = driver.findElement(By.xpath("//div[@class='itemList']/div/div[1]"));
        divProduct.click();

        //selecciono el primer item
        WebElement divPrice = driver.findElement(By.className("itemBox--price"));

        Assert.assertTrue(divPrice.getText().equals(valorEsperado), "Valido que el precio del producto sea el correcto");

    }

}

package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class SauceDemoTest {

    @Test
    public void usingAllLocatorsTest() throws InterruptedException {

        ClassLoader loader = getClass().getClassLoader();
        File file = new File(loader.getResource("drivers/chromedriver.exe").getFile());
        String absolutePath = file.getAbsolutePath();
        System.setProperty("webdriver.chrome.driver", absolutePath);

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

// 1. Поиск по ID.
        WebElement byID = driver.findElement(By.id("user-name"));

//2.  Поиск по name.
        WebElement byName = driver.findElement(By.name("password"));
 //....................................................
        byID.sendKeys("standard_user"+ Keys.ENTER);
        byName.sendKeys("secret_sauce" + Keys.ENTER);
 ///......................................................

//3. Поиск по classname.
        WebElement byClassName = driver.findElement(By.className("submit-button"));
//.........................................................
        byClassName.click();                                             //
        driver.findElement(By.cssSelector("[id ='item_1_title_link'] div")).click(); //движемся по странице.
//.........................................................

// 4.Поиск по tagname.
        WebElement byTagName = driver.findElement(By.tagName("style"));
//.............................................................
        driver.findElement(By.id("back-to-products")).click();
//...............................................................

// 5. Поиск по linktext.
       //WebElement ByLinkText = driver.findElement(By.linkText("About")); //  не находит

// 6. Поиск по partiallinktext.
       // WebElement ByPartialLinkText = driver.findElement(By.linkText("State"));// не находит
        Thread.sleep(3000);
//        xpath
//        Поиск по атрибуту, например By.xpath("//tag[@attribute='value']");
//        Поиск по тексту, например By.xpath("//tag[text()='text']");
//        Поиск по частичному совпадению атрибута, например By.xpath("//tag[contains(@attribute,'text')]");
//        Поиск по частичному совпадению текста, например By.xpath("//tag[contains(text(),'text')]");
//        ancestor, например //*[text()='Enterprise Testing']//ancestor::div
//        descendant
//                following
//        parent
//                preceding
//        Подсказка:  XPath Axes
//*поиск элемента с условием AND, например //input[@class='_2zrpKA _1dBPDZ' and @type='text']
//        css
//                .class
//                .class1.class2
//                .class1 .class2
//#id
//                tagname
//        tagname.class
//                [attribute=value]
//                [attribute~=value]
//[attribute|=value]
//[attribute^=value]
//[attribute$=value]
//[attribute*=value]
        driver.close();

    }
}

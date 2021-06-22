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
        byID.sendKeys("standard_user" + Keys.ENTER);
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
        driver.findElement(By.id("react-burger-menu-btn")).click();
//...............................................................

// 5. Поиск по linktext.
        WebElement ByLinkText = driver.findElement(By.linkText("ABOUT"));
//..................................................................
// 6. Поиск по partiallinktext.
        WebElement ByPartialLinkText = driver.findElement(By.partialLinkText("STATE"));
//.............................................................................
        driver.findElement(By.id("react-burger-cross-btn")).click();
        driver.findElement(By.id("back-to-products")).click();
        //Thread.sleep(3000);
//      2.  xpath
//      2.1  Поиск по атрибуту, например By.xpath("//tag[@attribute='value']");


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
//  3.       css
//  3.1    Поиск по одному классу .class
        WebElement byClass = driver.findElement(By.cssSelector(".page_wrapper"));

//.......................................................................
        driver.findElement(By.cssSelector("#item_0_title_link > div")).click();
//........................................................................

//  3.2    Поиск по двум классам .class1.class2
        WebElement byClasses = driver.findElement(By.cssSelector(".inventory_details_desc.large_size"));

//.......................................................................
        driver.findElement(By.cssSelector("#back-to-products")).click();
//........................................................................

//   3.3 Поиск дочернего элемента по классу  .class1 .class2
        WebElement childElementByClass = driver.findElement(By.cssSelector(".inventory_item .inventory_item_label"));
//..............................................................................

//   3.4 Поиск по #id
        WebElement byIdCss = driver.findElement(By.cssSelector("#header_container"));
//................................................................................
//    3.5 Поиск по tagname
        WebElement byTagNameCss = driver.findElement(By.cssSelector("title"));
//..........................................................................
//    3.6 Поиск по tagname &.class
        WebElement byTagNameAndClass = driver.findElement(By.cssSelector("div.page_wrapper"));
//.....................................................................................
//    3.7 Поиск по значению атрибута [attribute=value]
        WebElement byAtributeVolue = driver.findElement(By.cssSelector("[rel = 'stylesheet']"));
//.......................................................................................
//    3.8 Поиск по содержанию текста в атрибуте [attribute~=value]
        WebElement byContainTextCss =driver.findElement(By.cssSelector("[content ~= 'Labs']"));
//..................................................................................
//    3.9 Поиск по атрибуту и тексту с которого стартует атрибут [attribute|=value]
        WebElement byStartTextCss = driver.findElement(By.cssSelector("[rel |= 'apple' ]"));
//.....................................................................................
//    3.10 Поиск по атрибуту начинающегося с указанного значения [attribute^=value]
        WebElement ByStartFromValue = driver.findElement(By.cssSelector("[content ^= 'wi']"));
//.....................................................................................
//     3.11 Поиск по атрибуту заканчивающимся указанным значением[attribute$=value]
        WebElement ByEndValue = driver.findElement(By.cssSelector("[content $= '1' ]"));
//......................................................................................
//     3.11 Поиск по атрибуту имеющего указанное значение [attribute*=value]
        WebElement ByContainValue = driver.findElement(By.cssSelector("[content *= 'ff' ]"));
//..................................................................................
        driver.close();

    }
}

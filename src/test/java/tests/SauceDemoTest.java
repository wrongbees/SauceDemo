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

// 1.1 Поиск по ID.
        WebElement byID = driver.findElement(By.id("user-name"));

// 1.2  Поиск по name.
        WebElement byName = driver.findElement(By.name("password"));
        //....................................................
        byID.sendKeys("standard_user" + Keys.ENTER);
        byName.sendKeys("secret_sauce" + Keys.ENTER);
        ///......................................................

// 1.3 Поиск по classname.
        WebElement byClassName = driver.findElement(By.className("submit-button"));
//.........................................................
        byClassName.click();                                             //
        driver.findElement(By.cssSelector("[id ='item_1_title_link'] div")).click(); //движемся по странице.
//.........................................................

// 1.4 Поиск по tagname.
        WebElement byTagName = driver.findElement(By.tagName("style"));
        System.out.println(driver.findElements(By.tagName("style")).size());
//.............................................................
        driver.findElement(By.id("react-burger-menu-btn")).click();
//...............................................................

// 1.5 Поиск по linktext.
        WebElement ByLinkText = driver.findElement(By.linkText("ABOUT"));
//..................................................................
// 1.6 Поиск по partiallinktext.
        WebElement ByPartialLinkText = driver.findElement(By.partialLinkText("STATE"));
//.............................................................................
        driver.findElement(By.id("react-burger-cross-btn")).click();
        driver.findElement(By.id("back-to-products")).click();
//......................................................................
//      2.  xpath
//      2.1  Поиск по атрибуту, например By.xpath("//tag[@attribute='value']");
        WebElement byAttributeXPath = driver.findElement(By.xpath("//*[@class = 'primary_header']"));
//.............................................................................................
//
//      2.2  Поиск по тексту, например By.xpath("//tag[text()='text']");
        WebElement byTextXPath = driver.findElement(By.xpath("//noscript[text() = 'You need to enable JavaScript to run this app.']"));
//..................................................................................

//      2.3  Поиск по частичному совпадению атрибута, например By.xpath("//tag[contains(@attribute,'text')]");
        WebElement byContainsTextAttributeXPath = driver.findElement(By.xpath("//div[contains(@class, 'header_secondary')]"));
//...........................................................................................................

//      2.4  Поиск по частичному совпадению текста, например By.xpath("//tag[contains(text(),'text')]");
        WebElement byContainsText = driver.findElement(By.xpath("//*[contains(text(), 'JavaScript')]"));
//................................................................................

//       2.5 Поиск по ancestor, например //*[text()='Enterprise Testing']//ancestor::div
        WebElement byAncestorXPath = driver.findElement(By.xpath("//*[@class = 'social']//ancestor :: footer"));
//.......................................................................................

//       2.6 Поиск по descendant
        WebElement byDescendantXPath = driver.findElement(By.xpath("//*[@class='primary_header']//descendant :: div"));
//....................................................................................

//       2.7 Поиск по following
        WebElement byFollowingXPath = driver.findElement(By.xpath("//*[@class='header_label']//following:: div"));
//........................................................................

//       2.8 Поиск по parent
        WebElement byParentXPath = driver.findElement(By.xpath("//*[@class='shopping_cart_container']//parent:: div"));
//....................................................................
//       2.9 Поиск по preceding
        WebElement byPrecedingXPath = driver.findElement(By.xpath("//*[@id='contents_wrapper'] //preceding::noscript"));
//.................................................................
//
//       2.10 Поиск элемента с условием AND, например //input[@class='_2zrpKA _1dBPDZ' and @type='text']
        WebElement byСonjunctionXPath = driver.findElement(By.xpath("//*[contains(@class, 'bm-menu-w') and contains(@style, '100%')]"));
//...............................................................................

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

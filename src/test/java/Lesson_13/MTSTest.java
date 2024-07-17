package Lesson_13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;

public class MTSTest {

    private WebDriver driver;

    @BeforeTest
    private void beforeTest() {
        driver = new ChromeDriver();
        driver.get("https://www.mts.by/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        WebElement button = driver.findElement(By.xpath("//*[@id='cookie-agree']"));
        button.click();
    }

    @Test(priority = 1)
    public void checkOnlineReplenishment() {
        Assert.assertEquals(driver.findElement(By.cssSelector("div.pay__wrapper h2")).getText(),
                "Онлайн пополнение\nбез комиссии");
    }

    @Test(priority = 2)
    public void checkLogoPaymentSystems() {
        WebElement logo = driver.findElement(By.xpath("//div[@class='pay__partners']//img"));
        Actions action = new Actions(driver);
        action.moveToElement(logo).perform();
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='pay__partners']//img")), logo);
    }

    @Test(priority = 3)
    public void checkLinkWork() {
        WebElement link = driver.findElement(By.xpath("//a[contains(@href,'/help/poryadok-oplaty')]"));
        link.click();
        driver.get("https://www.mts.by/");
    }

    @Test(priority = 4)
    public void checkButtonContinue() {
        WebElement input1 = driver.findElement(By.xpath("//input[@placeholder='Номер телефона']"));
        input1.sendKeys("297777777");
        WebElement input2 = driver.findElement(By.xpath("//input[@placeholder='Сумма']"));
        input2.sendKeys("1");
        WebElement input3 = driver.findElement(By.xpath(
                "//form[@class='pay-form opened']//button[@class='button button__default ']"));
        input3.click();
    }

}
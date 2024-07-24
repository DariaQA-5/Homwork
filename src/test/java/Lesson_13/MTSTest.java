package Lesson_13;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class MTSTest {
    private WebDriver driver;

    @BeforeClass
    void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.mts.by/");
        WebElement click = driver.findElement(By.xpath("//button[contains(@class, 'cookie__cancel')]"));
        click.click();
    }


    @Test(priority = 1)
    void titleTest() {
        WebElement title = driver.findElement(By.xpath("//h2[text()='Онлайн пополнение ']"));
        Assert.assertEquals(title.getText(), "Онлайн пополнение без комиссии",
                "Different actual result. Click the link below for details");
    }

    @Test(priority = 2)
    void logoTest() {
        WebElement visa = driver.findElement
                (By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[2]/ul/li[1]/img"));
        Assert.assertTrue(visa.isDisplayed());

        WebElement verifiedByVisa = driver.findElement
                (By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[2]/ul/li[2]/img"));
        Assert.assertTrue(verifiedByVisa.isDisplayed());

        WebElement masterCard = driver.findElement
                (By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[2]/ul/li[3]/img"));
        Assert.assertTrue(masterCard.isDisplayed());

        WebElement maserCardSecure = driver.findElement
                (By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[2]/ul/li[4]/img"));
        Assert.assertTrue(maserCardSecure.isDisplayed());

        WebElement belKart = driver.findElement
                (By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[2]/ul/li[5]/img"));
        Assert.assertTrue(belKart.isDisplayed());
    }

    @Test(priority = 3)
    void linkTest() {
        WebElement readMore = driver.findElement(By.linkText("Подробнее о сервисе"));
        Assert.assertTrue(readMore.isEnabled());
        readMore.click();
        driver.navigate().back();
    }

    @Test(priority = 4)
    void topUpFormTest() {
        WebElement number = driver.findElement(By.xpath("//input[@id='connection-phone']"));
        number.sendKeys("297777777");

        WebElement money = driver.findElement(By.xpath("//input[@id='connection-sum']"));
        money.sendKeys("10");

        WebElement continueButton = driver.findElement(By.xpath("//*[@id='pay-connection']/button"));
        Assert.assertTrue(continueButton.isEnabled());
    }

    @AfterClass
    void shutDown() {
        driver.quit();
    }
}

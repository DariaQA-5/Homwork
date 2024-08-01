import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;

public class MTSTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.mts.by/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='cookie__wrapper']"))));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[contains(@class, 'cookie__cancel')]")))).click();
    }

    @Test
    void communicationServiceTest() {
        String phoneNumberPlaceholder = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//input[@id='connection-phone']"))).getAttribute("placeholder");
        Assert.assertEquals(phoneNumberPlaceholder, "Номер телефона",
                "Ожидаемый текст внутри незаполненного поля: Номер телефона");

        String sumFieldText = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//input[@id='connection-sum']"))).getAttribute("placeholder");
        Assert.assertEquals(sumFieldText, "Сумма", "Ожидаемый текст внутри незаполненного поля: Сумма");

        String emailFieldText = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//input[@id='connection-email']"))).getAttribute("placeholder");
        Assert.assertEquals(emailFieldText, "E-mail для отправки чека",
                "Ожидаемый текст внутри незаполненного поля: E-mail для отправки чека");
    }

    @Test
    void homeInternetTest() {
        clickServiceButton();
        wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//p[@class='select__option'][text()='Домашний интернет']"))).click();

        String userNumberPlaceholder = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//input[@id='internet-phone']"))).getAttribute("placeholder");
        Assert.assertEquals(userNumberPlaceholder, "Номер абонента",
                "Ожидаемый текст внутри незаполненного поля: ");

        String sumFieldText = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//input[@id='internet-sum']"))).getAttribute("placeholder");
        Assert.assertEquals(sumFieldText, "Сумма", "Ожидаемый текст внутри незаполненного поля: Сумма");

        String emailFieldText = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//input[@id='internet-email']"))).getAttribute("placeholder");
        Assert.assertEquals(emailFieldText, "E-mail для отправки чека",
                "Ожидаемый текст внутри незаполненного поля: E-mail для отправки чека");
    }

    @Test
    void installmentPlanTest() {
        clickServiceButton();
        wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//p[@class='select__option'][text()='Рассрочка']"))).click();

        String userNumberPlaceholder = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//input[@id='score-instalment']"))).getAttribute("placeholder");
        Assert.assertEquals(userNumberPlaceholder, "Номер счета на 44",
                "Ожидаемый текст внутри незаполненного поля: Номер счета на 44");

        String sumFieldText = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//input[@id='instalment-sum']"))).getAttribute("placeholder");
        Assert.assertEquals(sumFieldText, "Сумма", "Ожидаемый текст внутри незаполненного поля: Сумма");

        String emailFieldText = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//input[@id='instalment-email']"))).getAttribute("placeholder");
        Assert.assertEquals(emailFieldText, "E-mail для отправки чека",
                "Ожидаемый текст внутри незаполненного поля: E-mail для отправки чека");
    }

    @Test
    void debtTest() {
        clickServiceButton();
        wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//p[@class='select__option'][text()='Задолженность']"))).click();

        String userNumberPlaceholder = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//input[@id='score-arrears']"))).getAttribute("placeholder");
        Assert.assertEquals(userNumberPlaceholder, "Номер счета на 2073",
                "Ожидаемый текст внутри незаполненного поля: Номер счета на 2073");

        String sumFieldText = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//input[@id='arrears-sum']"))).getAttribute("placeholder");
        Assert.assertEquals(sumFieldText, "Сумма",
                "Ожидаемый текст внутри незаполненного поля: Сумма");

        String emailFieldText = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//input[@id='arrears-email']"))).getAttribute("placeholder");
        Assert.assertEquals(emailFieldText, "E-mail для отправки чека",
                "Ожидаемый текст внутри незаполненного поля: E-mail для отправки чека");
    }

    @Test
    void nextWindowTest() {
        clickServiceButton();
        wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//p[@class='select__option'][text()='Услуги связи']"))).click();

        WebElement phoneNumberField = driver.findElement(By.xpath("//*[@id='connection-phone']"));
        WebElement sumField = driver.findElement(By.xpath("//*[@id='connection-sum']"));
        WebElement continueButton = driver.findElement(By.xpath("//*[@id='pay-connection']/button"));

        phoneNumberField.sendKeys("297777777");
        sumField.sendKeys("10");
        continueButton.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@class='bepaid-iframe']")));

        Assert.assertEquals("10.00 BYN", wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector(".pay-description__cost > span:nth-child(1)"))).getText());
        Assert.assertEquals("Оплата: Услуги связи Номер:375297777777", driver.findElement
                (By.cssSelector(".pay-description__text > span")).getText());
        Assert.assertEquals("Оплатить 10.00 BYN", driver.findElement
                (By.cssSelector(".colored.disabled")).getText());

        Assert.assertEquals("Номер карты",
                wait.until(ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//label[text()='Номер карты']"))).getText());
        Assert.assertEquals("Срок действия",
                wait.until(ExpectedConditions.presenceOfElementLocated
                        (By.xpath("//label[text()='Срок действия']"))).getText());
        Assert.assertEquals("CVC",
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='CVC']"))).getText());
        Assert.assertEquals("Имя держателя (как на карте)",
                wait.until(ExpectedConditions.presenceOfElementLocated
                        (By.xpath("//label[text()='Имя держателя (как на карте)']"))).getText());

        ArrayList<String> paymentIcons = new ArrayList<>(Arrays.
                asList("assets/images/payment-icons/card-types/mastercard-system.svg",
                        "assets/images/payment-icons/card-types/visa-system.svg",
                        "assets/images/payment-icons/card-types/belkart-system.svg",
                        "assets/images/payment-icons/card-types/mir-system-ru.svg",
                        "assets/images/payment-icons/card-types/maestro-system.svg"));
        for (String paymentIcon : paymentIcons) {
            Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated
                    (By.xpath("//img[@src='" + paymentIcon + "']"))).isDisplayed());
        }
    }

    @AfterClass
    void exit() {
        driver.quit();
    }

    private void clickServiceButton() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='select__header']"))).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
    }
}
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
        wait.until(ExpectedConditions.visibilityOf(driver.findElement
                (By.xpath("//div[@class='cookie__wrapper']"))));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement
                (By.xpath("//button[contains(@class, 'cookie__cancel')]")))).click();
    }
    @Test// кооректность отображение суммы, номера телефона, реквизитов, наличие иконок платежных систем
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

    @Test//домашний интернет
    void homeInternetTest() {
        wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//li[@class='select__item']//p[text()='Домашний интернет']"))).click();

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

    @Test//рассрочка
    void installmentPlanTest() {
        wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//li[@class='select__item']//p[text()='Рассрочка']"))).click();

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

    @Test//задолженность
    void debtTest() {
        wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//li[@class='select__item']//p[text()='Задолженность']"))).click();

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

    @Test//услуги связи
    void nextWindowTest() {
        wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//li[@class='select__item']//p[text()='Услуги связи']"))).click();

        WebElement phoneNumberField = driver.findElement(By.xpath("//*[@id='connection-phone']"));
        WebElement sumField = driver.findElement(By.xpath("//*[@id='connection-sum']"));
        WebElement continueButton = driver.findElement(By.xpath("//*[@id='pay-connection']/button"));

        phoneNumberField.sendKeys("297777777");
        sumField.sendKeys("10");
        continueButton.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath
                ("//iframe[@class='bepaid-iframe']")));

        Assert.assertEquals("100.00 BYN", wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector(".pay-description__cost > span:nth-child(1)"))).getText());
        Assert.assertEquals("Оплата: Услуги связи Номер:37512779123", driver.findElement
                (By.cssSelector(".pay-description__text > span")).getText());
        Assert.assertEquals("Оплатить 100.00 BYN", driver.findElement
                (By.cssSelector(".colored.disabled")).getText());

        Assert.assertEquals("Номер карты",
                wait.until(ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//label[text()='Номер карты']"))).getText());
        Assert.assertEquals("Срок действия",
                wait.until(ExpectedConditions.presenceOfElementLocated
                        (By.xpath("//label[text()='Срок действия']"))).getText());
        Assert.assertEquals("CVC",
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                        ("//label[text()='CVC']"))).getText());
        Assert.assertEquals("Имя держателя (как на карте)",
                wait.until(ExpectedConditions.presenceOfElementLocated
                        (By.xpath("//label[text()='Имя держателя (как на карте)']"))).getText());

        ArrayList<String> paymentIcons = new ArrayList<>(Arrays.
                asList("assets/images/payment-icons/card-types/mastercard-system.svg",
                        "assets/images/payment-icons/card-types/visa-system.svg",
                        "assets/images/payment-icons/card-types/mir-system-ru.svg"));

        for (String paymentIcon : paymentIcons) {
            Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated
                    (By.xpath("//img[@src='" + paymentIcon + "']"))).isDisplayed());
        }
    }

    @AfterClass
    void exit() {
        driver.quit();
    }

}
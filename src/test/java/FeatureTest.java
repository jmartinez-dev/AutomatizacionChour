import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import com.github.javafaker.Faker;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.awt.event.KeyEvent;
import java.awt.*;
import java.time.Duration;

public class FeatureTest {
    private ChromeDriver driver;
    private Wait<WebDriver> wait;


    Faker faker=new Faker();

    public FeatureTest() throws AWTException {
    }

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        driver.get("https://www.utest.com");
        driver.manage().window().maximize();

    }
    // Cuando ingrese por el boton Join Today
    @Test
    public void whenClickOnJoinButton() throws InterruptedException {
        var button = driver.findElement(By.className("unauthenticated-nav-bar__sign-up"));
        button.click();
        Thread.sleep(Duration.ofSeconds(2));
        var currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
        Assertions.assertTrue("https://www.utest.com/signup/personal".equals(currentUrl));
        whenYouEnterStepOne();

    }

    // Cuando ingreso mi primer nombre, apellido, correo, fecha de nacimiento Y hago clic en el botón Next:Location
    public void whenYouEnterStepOne() throws InterruptedException {

        var firstName = driver.findElement(By.id("firstName"));
        var lastName = driver.findElement(By.id("lastName"));
        var email = driver.findElement(By.id("email"));
        var birthMonth = driver.findElement(By.id("birthMonth"));
        var birthDay = driver.findElement(By.id("birthDay"));
        var birthYear= driver.findElement(By.id("birthYear"));

        firstName.sendKeys(faker.name().firstName());
        lastName.sendKeys(faker.name().lastName());
        email.sendKeys(faker.internet().emailAddress());
        birthMonth.findElement(By.xpath("//option[. = 'March']")).click();
        birthDay.findElement(By.xpath("//option[. = '14']")).click();
        birthYear.findElement(By.xpath("//option[. = '1992']")).click();
        whenClickNextLocationButton();

    }
    // Mouse over en "Next: Location"
    // Hacer click en "Next: Location"
    // Entonces debería ver la página de direcciones "https://www.utest.com/signup/address"
    public void whenClickNextLocationButton() throws InterruptedException {
        var buttonNext = driver.findElement(By.xpath("//span[contains(.,'Next: Location')]"));
        Thread.sleep(Duration.ofSeconds(5));
        buttonNext.click();
        Thread.sleep(Duration.ofSeconds(5));
        var currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
        Assertions.assertTrue("https://www.utest.com/signup/address".equals(currentUrl));
        whenYouEnterStepTwo();
    }

    // Cuando ingreso a el paso "Agrega tu dirección"
    // Entonces el sistema lo autodetecta o ingreso los datos solicitados y hago clic en el botón Next:Devices
    public void whenYouEnterStepTwo() throws InterruptedException {

    var zip = driver.findElement(By.id("zip"));
    zip.clear();
    zip.sendKeys("114121");

    driver.findElement(By.cssSelector(".ng-not-empty > .ui-select-match > .btn")).click();
    driver.findElement(By.cssSelector("#ui-select-choices-row-2-51 div")).click();
    whenClickNextDevicesButton();

    }
    // Mouse over en "Next: Devices"
    // Hacer click en "Next: Devices"
    // Entonces debería ver la página de direcciones "https://www.utest.com/signup/devices"
    public void whenClickNextDevicesButton() throws InterruptedException {
        var buttonNext = driver.findElement(By.xpath("//span[contains(.,'Next: Devices')]"));
        Thread.sleep(Duration.ofSeconds(5));
        buttonNext.click();
        Thread.sleep(Duration.ofSeconds(5));
        var currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
        Assertions.assertTrue("https://www.utest.com/signup/devices".equals(currentUrl));
        whenYouEnterStepThree();
    }

    // Cuando ingrese a el paso "Cuéntanos sobre tus dispositivos"
    // Entonces ingreso los datos solicitados y hago clic en el botón Next:Last Step
    public void whenYouEnterStepThree() throws InterruptedException {


        whenClickNextLastStepButton();

    }
    // Mouse over en "Next: Last Step"
    // Hacer click en "Next: Last Step"
    // Entonces debería ver la página de direcciones "https://www.utest.com/signup/complete"
    public void whenClickNextLastStepButton() throws InterruptedException {
        var buttonNext = driver.findElement(By.xpath("//span[contains(.,'Next: Last Step')]"));
        Thread.sleep(Duration.ofSeconds(5));
        buttonNext.click();
        Thread.sleep(Duration.ofSeconds(5));
        var currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
        Assertions.assertTrue("https://www.utest.com/signup/complete".equals(currentUrl));
        whenYouEnterStepFour();
        //driver.close();
    }
    // Cuando ingrese a el paso "El último paso"
    // Cuando complete la contraseña y confirme la contraseña y hago clic en aceptar terminos, condiciones y politicas
    public void whenYouEnterStepFour() throws InterruptedException {

        driver.findElement(By.id("password")).sendKeys("Administrator12*");
        driver.findElement(By.id("confirmPassword")).sendKeys("Administrator12*");

        driver.findElement(By.cssSelector(".signup-consent__checkbox--highlight")).click();
        driver.findElement(By.cssSelector(".error:nth-child(4)")).click();
        driver.findElement(By.cssSelector(".error")).click();
        whenClickCompleteSetupButton();

    }
    // Entonces mi usuario se deberia crear correctamente
    public void whenClickCompleteSetupButton() throws InterruptedException {
        var buttonNext = driver.findElement(By.cssSelector("#laddaBtn > span"));
        Thread.sleep(Duration.ofSeconds(5));
        buttonNext.click();
        Thread.sleep(Duration.ofSeconds(5));
        var currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
        Assertions.assertTrue("https://www.utest.com/welcome?from=signup".equals(currentUrl));
        whenYouEnterStepFour();

    }

    @AfterEach
    public void close() {
        driver.close();
    }

}

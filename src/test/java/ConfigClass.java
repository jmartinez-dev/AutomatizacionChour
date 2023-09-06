import org.openqa.selenium.WebDriver;

public class ConfigClass {

    private final WebDriver driver;

    public ConfigClass(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }
}

package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    @BeforeAll
    public static void beforeSettings() {
        Configuration.holdBrowserOpen   = true;
        Configuration.browserSize       = "1920x1080";
        Configuration.baseUrl           = "https://demoqa.com";
    }
}

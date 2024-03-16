package demoqa.com.setup;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

public class BrowserSetup {
    private static Browser browser;

    public static void setup() {
        // Ustawiamy Playwright do uzyskania instancji przeglądarki
        Playwright playwright = Playwright.create();
        BrowserType browserType = playwright.chromium(); // Użyjemy tutaj Chromium.
        browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false));
    }

    public static Browser getBrowser() {
        // Jeśli przeglądarka nie została jeszcze zainicjalizowana, zrób to
        if (browser == null){
            setup();
        }
        // Zwróć instancję przeglądarki
        return browser;
    }

    public static void tearDown() {
        // Zamknij przeglądarkę.
        browser.close();
        // Ustaw wartość przeglądarki na null po zakończeniu
        browser = null;
    }
}

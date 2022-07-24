package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.DelailsPage;
import pages.SearchPage;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class googleTests {
    private static WebDriver driver;
    private static SearchPage searchPage;
    private static DelailsPage detailsPage;

    @BeforeAll
    public static void init() {
    System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
    ChromeOptions options = new ChromeOptions();
    options.addArguments("start-maximazed");
    driver = new ChromeDriver(options);
    searchPage = new SearchPage(driver);
    detailsPage = new DelailsPage(driver);
    }

    @BeforeEach
    public void setup (){
        driver.get("http://google.com");
    }

    @Test
    @DisplayName("Поиск числа результатов")
    public void test1(){
        searchPage.search("selenium");
        assertEquals (13, searchPage.results.size());
    }
    @Test
    @DisplayName("Проверка деталей ресурса")
    public void test2 () {
        driver.get("http://google.com");
        searchPage.search("selenium");
        assertAll(
            ()-> assertEquals("Selenium", detailsPage.getName()),
            ()-> assertEquals("Apache License 2.0",detailsPage.getLicense()),
            ()-> assertEquals("4.1.0 (22 ноября 2021; 8 месяцев назад)",detailsPage.getLastVersion()));
    }

    @AfterAll
    public static void teardown() {
    driver.quit();
    }
}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import static org.openqa.selenium.support.PageFactory.initElements;

public class DelailsPage
{
    @FindBy (css = "#wp-tab-container div[data-attrid*='poslednyaya_versiya'] .LrzXr.kno-fv")
    private WebElement lastVersion;

    @FindBy (css = "#wp-tab-container div[data-attrid*='licenziya'] .LrzXr.kno-fv")
    private WebElement license;

    @FindBy (css = "#wp-tab-container h2[data-attrid*='title']")
    private WebElement name;

    public DelailsPage(WebDriver driver) {
        initElements(driver, this);
    }
    public String getName(){return name.getText();}
    public String getLastVersion(){
        return lastVersion.getText();
    }
    public String getLicense(){
        return license.getText();
    }
}

package org.test.Imdb;

import com.codeborne.selenide.*;
import static com.codeborne.selenide.Selenide.*;

public class ImdbTopRatedMoviesPage {

    private String movieItemsListElement = "tbody.lister-list tr";
    private ElementsCollection movieItemsList = $$(movieItemsListElement);

    public ImdbTopRatedMoviesPage() {
        System.setProperty("webdriver.chrome.driver", "src/test/java/resources/chromedriverWin.exe");
        //System.setProperty("webdriver.chrome.driver", "src/test/java/resources/chromedriverLinux.exe");
        //System.setProperty("webdriver.chrome.driver", "src/test/java/resources/chromedriverMac.exe");
        System.setProperty("selenide.browser", "Chrome");
        Configuration.baseUrl = "https://www.imdb.com/chart/top?ref_=nv_mv_250_6";
    }

    public void openBrowser() {
        Selenide.open("/");
    }

    public void closeBrowser() {
        Selenide.closeWebDriver();
    }

    public void refreshBrowser() {
        Selenide.refresh();
    }

    public void openTopRatedMovies() {
        $("#explore-more .float-left", 0).$("a",0).click();
    }

    public String getMovieItemsListElement() {
        return movieItemsListElement;
    }

    public ElementsCollection getMovieItemsList() {
        return movieItemsList;
    }

    public int getRandomMovieItemIndex() {
        return Utility.random(0, movieItemsList.size() - 1);
    }

    public String getMovieItemTitle(int itemIndex) {
        return $(movieItemsListElement, itemIndex).$("td", 1).$("a").getText();
    }

}

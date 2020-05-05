package org.test.Imdb;

import com.codeborne.selenide.*;
import static com.codeborne.selenide.Selenide.*;

public class ImdbTopRatedMoviesPageAddToWl {

    private String movieWatchListElement  = ".lister-item-header a";

    public ImdbTopRatedMoviesPage imdbTrmPage = new ImdbTopRatedMoviesPage();

    public void addRemoveItemToFromWl(int itemIndex){
        $(this.imdbTrmPage.getMovieItemsListElement(), itemIndex).$("td", 4).$(".wl-ribbon").click();
    }

    public boolean isItemAddedToWl(int itemIndex){
        return $(this.imdbTrmPage.getMovieItemsListElement(), itemIndex).$("td", 4).$(".wl-ribbon.inWL").exists();
    }

    public void openWlViaUserMenu(){
        $("._3x17Igk9XRXcaKrcG3_MXQ").click();
        $("#navUserMenu-contents .ipc-list a", 2).click();
    }

    public boolean isItemFoundInWl(String itemTitle){
        SelenideElement element = $(".lister-item", 0).$(movieWatchListElement);
        if (!element.exists()) {return false;}
        String text = element.getText();
        return itemTitle.equals(text);
    }

    public String itemTitleFoundInWl(){
        return $(movieWatchListElement, 0).getText();
    }

    public void removeFromWl(){
        $(".wl-ribbon").click();
    }

}

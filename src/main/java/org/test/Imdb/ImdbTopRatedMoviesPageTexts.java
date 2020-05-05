package org.test.Imdb;

import static com.codeborne.selenide.Selenide.$;

public class ImdbTopRatedMoviesPageTexts {

    String tableColumns = ".lister .chart th";

    // get the text of the article of Top Rated Movies functionality
    public String getTopRatedMoviesArticleText() {
        return $( "#main .seen-collection .article h3").getText();
    }

    // get the text of the header of Top Rated Movies functionality
    public String getTopRatedMoviesHeaderText() {
        return $( ".header").getText();
    }

    // get the text of the summary of Top Rated Movies functionality
    public String getTopRatedMoviesSummaryText() {
        return $( ".byline").getText();
    }

    // get the text of the share option of Top Rated Movies functionality
    public String getTopRatedMoviesShareText() {
        return $( ".share-button-title").getText();
    }

    // get the text of the description of Top Rated Movies functionality
    public String getTopRatedMoviesDescriptionText() {
        return $( ".desc").getText();
    }

    // get the text of the sorting of Top Rated Movies functionality
    public String getTopRatedMoviesSortingText() {
        return $( ".lister-sort-by-label").getText();
    }

    // get the text of the poster of Top Rated Movies functionality
    public String getTopRatedMoviesPosterText() {
        return $( tableColumns,0).getText();
    }

    // get the text of the Rank & Title of Top Rated Movies functionality
    public String getTopRatedMoviesRankTitleText() {
        return $( tableColumns,1).getText();
    }

    // get the text of the IMDb rating of Top Rated Movies functionality
    public String getTopRatedMoviesImdbRatingText() {
        return $( tableColumns,2).getText();
    }

    // get the text of the user rating of Top Rated Movies functionality
    public String getTopRatedMoviesUserRatingText() {
        return $( tableColumns,3).getText();
    }

    // get the text of the Add to watchlist of Top Rated Movies functionality
    public String getTopRatedMoviesAddToWatchlistText() {
        return $( tableColumns,4).getText();
    }

}

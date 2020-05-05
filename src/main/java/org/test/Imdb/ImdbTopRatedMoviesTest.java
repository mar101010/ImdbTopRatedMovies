package org.test.Imdb;

import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class ImdbTopRatedMoviesTest {

    public String imdbUserEmail = "marina.pavlishina@gmail.com";
    public String imdbUserPwd = "maro1986";

    public ImdbTopRatedMoviesPage imdbTrmPage = new ImdbTopRatedMoviesPage();
    public ImdbTopRatedMoviesPageTexts imdbTrmPageTexts = new ImdbTopRatedMoviesPageTexts();
    public ImdbTopRatedMoviesPageAddToWl imdbTrmPageAddToWl = new ImdbTopRatedMoviesPageAddToWl();
    public ImdbSignInSignOutPage imdbSioPage = new ImdbSignInSignOutPage();
    public SoftAssert softAssert = new SoftAssert();

    @BeforeClass
    public void openPage() {
        imdbTrmPage.openBrowser();
    }

    @AfterClass
    public void tearDown() {
        imdbTrmPage.closeBrowser();
    }

    @BeforeGroups ("loggedInUser") //log in before logged in users tests
    public void  signIn(){
        imdbSioPage.signInAsImdbUser(imdbUserEmail, imdbUserPwd);
    }

    @AfterGroups ("loggedInUser") //log out after logged in users test
    public void  signOutAndGoToTrmPage() {
        imdbSioPage.signOut();
        imdbTrmPage.openTopRatedMovies();
    }

    //Test #4
    @Test
    public void userSeesCorrectTexts(){
        //given
        String trmArticleTextExpected = "IMDb Charts";
        String trmHeaderTextExpected = "Top Rated Movies";
        String trmSummaryTextExpected = "Top 250 as rated by IMDb Users";
        String trmShareTextExpected = "SHARE";
        String trmDescriptionTextExpected = "Showing 250 Titles";
        String trmSortingTextExpected = "Sort by:";
        String trmPosterTextExpected = "Poster";
        String trmRankTitleTextExpected = "Rank & Title";
        String trmImdbRatingTextExpected = "IMDb Rating";
        String trmUserRatingTextExpected = "Your Rating";
        String trmAddToWatchlistTextExpected = "Add to Watchlist";
        //when
        String trmArticleTextActual = imdbTrmPageTexts.getTopRatedMoviesArticleText();
        String trmHeaderTextActual = imdbTrmPageTexts.getTopRatedMoviesHeaderText();
        String trmSummaryTextActual = imdbTrmPageTexts.getTopRatedMoviesSummaryText();
        String trmShareTextActual = imdbTrmPageTexts.getTopRatedMoviesShareText();
        String trmDescriptionTextActual = imdbTrmPageTexts.getTopRatedMoviesDescriptionText();
        String trmSortingTextActual = imdbTrmPageTexts.getTopRatedMoviesSortingText();
        String trmPosterTextActual = imdbTrmPageTexts.getTopRatedMoviesPosterText();
        String trmRankTitleTextActual = imdbTrmPageTexts.getTopRatedMoviesRankTitleText();
        String trmImdbRatingTextActual = imdbTrmPageTexts.getTopRatedMoviesImdbRatingText();
        String trmUserRatingTextActual = imdbTrmPageTexts.getTopRatedMoviesUserRatingText();
        String trmAddToWatchlistTextActual = imdbTrmPageTexts.getTopRatedMoviesAddToWatchlistText();
        //then
        softAssert.assertEquals(trmArticleTextActual, trmArticleTextExpected);
        softAssert.assertEquals(trmHeaderTextActual, trmHeaderTextExpected);
        softAssert.assertEquals(trmSummaryTextActual, trmSummaryTextExpected);
        softAssert.assertEquals(trmShareTextActual, trmShareTextExpected);
        softAssert.assertEquals(trmDescriptionTextActual, trmDescriptionTextExpected);
        softAssert.assertEquals(trmSortingTextActual, trmSortingTextExpected);
        softAssert.assertEquals(trmPosterTextActual, trmPosterTextExpected);
        softAssert.assertEquals(trmRankTitleTextActual, trmRankTitleTextExpected);
        softAssert.assertEquals(trmImdbRatingTextActual, trmImdbRatingTextExpected);
        softAssert.assertEquals(trmUserRatingTextActual, trmUserRatingTextExpected);
        softAssert.assertEquals(trmAddToWatchlistTextActual, trmAddToWatchlistTextExpected);
        softAssert.assertAll();
    }

    // Test #8
    @Test (groups = { "loggedInUser" })
    public void signedInUserCanAddMovieInItemsListToWatchlist(){
        //given
        int movieItemIndex1 = imdbTrmPage.getRandomMovieItemIndex();
        int movieItemIndex2 = imdbTrmPage.getRandomMovieItemIndex();
        String itemTitle1Expected = imdbTrmPage.getMovieItemTitle(movieItemIndex1);// for reporting
        String itemTitle2Expected = imdbTrmPage.getMovieItemTitle(movieItemIndex2);
        System.out.println("First movie index: " + movieItemIndex1 + ", title: " + itemTitle1Expected);// for reporting
        System.out.println("Second movie index: " + movieItemIndex2 + ", title: " + itemTitle2Expected);// for reporting
        imdbTrmPageAddToWl.addRemoveItemToFromWl(movieItemIndex1);
        Utility.delay(1000);
        boolean isItem1AddedToWl= imdbTrmPageAddToWl.isItemAddedToWl(movieItemIndex1);
        System.out.println("First movie is added to the watchlist: " + isItem1AddedToWl); // for reporting
        imdbTrmPageAddToWl.addRemoveItemToFromWl(movieItemIndex2);
        Utility.delay(1000);
        boolean isItem2AddedToWl= imdbTrmPageAddToWl.isItemAddedToWl(movieItemIndex2);
        System.out.println("Second movie is added to the watchlist: " + isItem2AddedToWl); // for reporting
        imdbTrmPageAddToWl.addRemoveItemToFromWl(movieItemIndex1);
        Utility.delay(1000);
        boolean isItem1AddedToWlAfterRemove= imdbTrmPageAddToWl.isItemAddedToWl(movieItemIndex1);
        System.out.println("First movie is added to the watchlist: " + isItem1AddedToWlAfterRemove); // for reporting
        imdbTrmPageAddToWl.openWlViaUserMenu();
        //when
        System.out.println("Watchlist is opened"); // for reporting
        boolean isItem2InWl = imdbTrmPageAddToWl.isItemFoundInWl(itemTitle2Expected);
        System.out.println("is second movie in watchlist: " + isItem2InWl);// for reporting
        String itemTitle2Actual = imdbTrmPageAddToWl.itemTitleFoundInWl();
        System.out.println("movie found in watchlist: " + itemTitle2Actual);// for reporting
        imdbTrmPageAddToWl.removeFromWl();
        imdbTrmPage.refreshBrowser();
        System.out.println("we removed movie and refreshed browser...");// for reporting
        boolean isItem2InWlAfterRemove = imdbTrmPageAddToWl.isItemFoundInWl(itemTitle2Actual);
        System.out.println("is second movie in watchlist: " + isItem2InWlAfterRemove);// for reporting
        //then
        softAssert.assertTrue(isItem1AddedToWl);
        softAssert.assertTrue(isItem2AddedToWl);
        softAssert.assertFalse(isItem1AddedToWlAfterRemove);
        softAssert.assertTrue(isItem2InWl);
        softAssert.assertEquals(itemTitle2Actual, itemTitle2Expected);
        softAssert.assertFalse(isItem2InWlAfterRemove);
        softAssert.assertAll();
    }

}

package org.test.Imdb;

import static com.codeborne.selenide.Selenide.$;

public class ImdbSignInSignOutPage {

    //sign in as IMDb user
    public void  signInAsImdbUser(String email, String pwd){
        $("._3x17Igk9XRXcaKrcG3_MXQ").click();
        $(".list-group a", 0).click();
        $("#ap_email").setValue(email);
        $("#ap_password").setValue(pwd);
        $("span .a-button-inner").click();
    }

    //sign out
    public void signOut(){//input is needed
        $("._3x17Igk9XRXcaKrcG3_MXQ").click();
        $("#navUserMenu-contents a.imdb-header-account-menu__sign-out").click();
    }

}

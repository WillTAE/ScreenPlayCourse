package starter.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import starter.ui.SwagLabsStoreUI;

public class OnThePrincipalPage implements Question {

    public static Question<String> theTitleIs() { //String porque lo que vamos a obtener es un texto unicamente
        return new OnThePrincipalPage();
    }

    @Override
    public Object answeredBy(final Actor actor) {
        return BrowseTheWeb.as(actor).find(SwagLabsStoreUI.PRODUCTS_TITLE).getText();
    }
}

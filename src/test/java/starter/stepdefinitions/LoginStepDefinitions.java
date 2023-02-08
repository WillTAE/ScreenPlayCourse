package starter.stepdefinitions;

import static org.hamcrest.CoreMatchers.equalTo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import starter.navigation.NavigateTo;
import starter.questions.OnThePrincipalPage;
import starter.tasks.DoLogin;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class LoginStepDefinitions {

    @Given("{actor} is a {}")
    public void userNavigatesToHomePage(Actor actor, String customerType) {
        actor.wasAbleTo(NavigateTo.theSauceHomePage());

    }

    @When("{actor} tries to login")
    public void userTriesToLogin(Actor actor) {
        actor.attemptsTo(
                DoLogin.withCredentials("standard_user", "secret_sauce")
        );
    }

    @When("{actor} tries to login with username {} and password {}")
    public void userTriesToLoginWithCredentials(Actor actor, String username, String password) {
        actor.attemptsTo(
                DoLogin.withCredentials(username, password)
        );
    }

    @Then("{actor} should see to products list")
    public void userShouldSeeProductsList(Actor actor) {
        actor.should(
                seeThat("the displayed title",
                        OnThePrincipalPage.theTitleIs(), equalTo("PRODUCTS")
                )
        );
        //another way to implement the question
        theActorInTheSpotlight().should(
                seeThat("the displayed title",
                        OnThePrincipalPage.theTitleIs(), equalTo("PRODUCTS")
                )
        );
    }

}

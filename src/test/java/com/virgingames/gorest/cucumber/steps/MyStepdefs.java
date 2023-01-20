package com.virgingames.gorest.cucumber.steps;

import com.virgingames.gamesinfo.BingoLobbyFeedSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;

public class MyStepdefs {

    static ValidatableResponse response;

    @Steps
    BingoLobbyFeedSteps bingoLobbyFeedSteps;

    @Given("^I am on virgin games bingo field$")
    public void iAmOnVirginGamesBingoField() {
    }

    @When("^I send Get request to the Lobby feed endpoint$")
    public void iSendGetRequestToTheLobbyFeedEndpoint() {
        response = bingoLobbyFeedSteps.getAllBingoLobbyFeed();
    }

    @Then("^I get valid status code 200$")
    public void iGetValidStatusCode() {
        response.statusCode(200);
    }

    @And("^I verify that the stream name is \"([^\"]*)\" at streams index$")
    public void iVerifyThatTheStreamNameIsAtStreamsIndex(String name) {
        HashMap<String, Object> streamMap = bingoLobbyFeedSteps.getStreamNameFromStreams(name);
        Assert.assertThat(streamMap, hasValue(name));
    }
}
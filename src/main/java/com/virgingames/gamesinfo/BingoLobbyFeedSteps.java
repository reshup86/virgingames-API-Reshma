package com.virgingames.gamesinfo;

import com.virgingames.constants.EndPoints;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.util.HashMap;

public class BingoLobbyFeedSteps {
    @Step("Getting all field")
    public ValidatableResponse getAllBingoLobbyFeed(){
        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .when()
                .get(EndPoints.GET_ALL_FIELD)
                .then();
    }

    @Step("Getting frequency")
    public HashMap<String, Object> getStreamNameFromStreams(String streamName) {
        String p1 = "bingoLobbyInfoResource.streams.findAll{it.streamName == '";
        String p2 = "'}.get(0)";

        RestAssured.registerParser("text/plain", Parser.JSON);

        return SerenityRest.given().log().all()
                .when()
                .get(EndPoints.GET_ALL_FIELD)
                .then()
                .statusCode(200)
                .extract()
                .path(p1 + streamName + p2);
    }
}

package pl.imgw.requests;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class ApiDataSynop {

    public ApiDataSynop(){
        RestAssured.baseURI = "https://danepubliczne.imgw.pl";
    }

    public String getApiDataSynop(){
        return
                given()
                    .relaxedHTTPSValidation()
                .when()
                    .get("/api/data/synop")
                .then()
                    .assertThat()
                    .statusCode(200)
                .and()
                    .extract()
                    .body()
                    .asString();
    }

    public String getApiDataSynop(final String stationName){
        return
                given()
                        .relaxedHTTPSValidation()
                        .when()
                        .get("/api/data/synop/station/" + stationName)
                        .then()
                        .assertThat()
                        .statusCode(200)
                        .and()
                        .extract()
                        .body()
                        .asString();
    }
}

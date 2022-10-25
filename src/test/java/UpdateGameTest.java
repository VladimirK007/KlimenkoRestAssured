import dataEntity.Game.VideoGame;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UpdateGameTest extends SpecificationsRestAssured {

    @Test
    public void updateGame(){

        Response response = given()
                .spec(gamesRequestSpecification)
                .when()
                .get("/videogames/77");

        VideoGame updateGame = response.as(VideoGame.class);
        updateGame.setName("Road Rage 2000");
        updateGame.setCategory("Driving");
        updateGame.setRating("105");
        given().spec(gamesRequestSpecification)
                .body(updateGame)
                .when()
                .put("videogames/77")
                .then()
                .assertThat().body(Matchers.containsString("Driving"))
                .spec(gamesResponseSpecification)
                .log()
                .body();




    }


}

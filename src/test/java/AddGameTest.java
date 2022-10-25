import dataEntity.Game.VideoGame;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class AddGameTest extends SpecificationsRestAssured {

@Test
    public void addGame() {

        VideoGame GamePostRequestPayload = new VideoGame
                ("Far Cry 7", 51, "Shooter", "2022-08-12");
        given().spec(gamesRequestSpecification)
                .body(GamePostRequestPayload)
                .when()
                .post("/videogames")
                .then()
                .assertThat()
                .body(Matchers.containsString("Record Added Successfully"))
                .spec(gamesResponseSpecification)
                .log()
                .body();
    }
}

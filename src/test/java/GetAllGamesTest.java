import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;

public class GetAllGamesTest extends SpecificationsRestAssured {

    @Test
    public void getAllGames() {
        Response response = given()
                .spec(gamesRequestSpecification)
                .when()
                .get("/videogames");

        response
                .then()
                .assertThat()
                .time(Matchers.lessThan(3000L))
                .body(Matchers.containsString("Resident Evil"))
                .spec(gamesResponseSpecification)
                .log()
                .body();

        long responseTime = response.getTimeIn(TimeUnit.MILLISECONDS);

        System.out.println("Time of Response is: " + responseTime + "ms");
    }


}



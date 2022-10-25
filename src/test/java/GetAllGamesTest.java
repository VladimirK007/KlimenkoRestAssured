import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class GetAllGamesTest extends SpecificationsRestAssured {

    @Test
    public void getAllGames() {
        long responseTime;
        responseTime = given()
                .spec(gamesRequestSpecification)
                .when()
                .get("/videogames")
                .then()
                .assertThat()
                .time(Matchers.lessThan(6000l))
                .body(Matchers.containsString("Resident Evil"))
                .spec(gamesResponseSpecification)
                .log()
                .body()
                .extract()
                .response()
                .getTime();

        System.out.println("Time of Response is: " + responseTime + " ms");
    }


}



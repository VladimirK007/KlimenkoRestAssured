import dataEntity.Game.VideoGame;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

public class GetGameByIdTest extends SpecificationsRestAssured {


    @Test
    public void gameDetailsVerification() {
        printGameDetails(5);
        Assert.assertEquals(getGameById(5).getName(), "The Legend of Zelda: Ocarina of Time");
        Assert.assertEquals(getGameById(5).getCategory(), "Adventure");


    }

    private List<VideoGame> getAllGames() {

        Response response = given()
                .spec(gamesRequestSpecification)
                .when()
                .get("/videogames");

        return Arrays.asList(response.as(VideoGame[].class));

    }

    private VideoGame getGameById(int id) {
        return
                getAllGames()
                        .stream()
                        .filter(gameById -> gameById.getId() == id)
                        .findFirst()
                        .get();
    }

    private void printGameDetails(int id) {

        System.out.println(getGameById(id));

    }

}




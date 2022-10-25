import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeMethod;


public class SpecificationsRestAssured {

    static RequestSpecification gamesRequestSpecification;
    static ResponseSpecification gamesResponseSpecification;


    @BeforeMethod
    public void setGamesRequestSpecification() {
        gamesRequestSpecification = new RequestSpecBuilder()
                .setBaseUri("http://localhost:8080/app")
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON)
                .build();

    }

    @BeforeMethod
    public void setGamesResponseSpecification() {
        gamesResponseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(HttpStatus.SC_OK)
                .expectContentType(ContentType.JSON)
                .build();


    }


}

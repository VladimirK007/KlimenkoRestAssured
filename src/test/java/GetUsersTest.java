import dataEntity.Users.Users;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

public class GetUsersTest {

    @Test
    public void getUsersCollection() {

        Response response = given()

                .when()
                .get("https://jsonplaceholder.typicode.com/users");

        Users[] listUsers = response.as(Users[].class);
        Arrays.stream(listUsers).forEach(System.out::println);

        List<Users> usersList = Arrays.asList(response.as(Users[].class));
        String firstUserName = usersList.get(0).getName();
        int id = usersList.get(0).getId();
        Assert.assertEquals(firstUserName, "Leanne Graham");
        Assert.assertEquals(id, 1);


    }
}

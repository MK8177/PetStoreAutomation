package api.endpoints;
import static io.restassured.RestAssured.*;
import api.payload.User;
import io.restassured.response.Response;
import io.restassured.http.ContentType;

//userendpoints.java= CRUD opration(Create,Read,update,delete)
public class UserEndPoints extends Routes {
	
	
	public static Response createUser(User payload)
	{
		Response response=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
			.when()
			 .post("https://petstore.swagger.io/v2/user");
		return response;
	}

	
	public static Response readUser(String userName)
	{
		Response response=given()
				.pathParam("username", userName)
				
			.when()
			 .get("https://petstore.swagger.io/v2/user/{username}");
		return response;
	}
	
	public static Response updateUser(User payload, String userName)
	{
		Response response=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				.pathParam("username", userName)
			.when()
			 .put("https://petstore.swagger.io/v2/user/{username}");
		return response;
	}
	
	public static Response deleteUser(String userName)
	{
		Response response=given()
				.pathParam("username", userName)
				
			.when()
			 .delete("https://petstore.swagger.io/v2/user/{username}");
		return response;
	}
}

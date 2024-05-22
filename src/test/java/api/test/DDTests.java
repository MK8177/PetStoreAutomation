package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DDTests {
	User uerPayload;
	
	@Test(priority=1, dataProvider="LoginData", dataProviderClass=DataProviders.class)
	public void testPostUser(String userID,String userName, String fname, String lname, String usermail,
			String pwd, String ph)
	{

    
		uerPayload= new User();
		uerPayload.setId(Integer.parseInt(userID));
		uerPayload.setUsername(userName);
		uerPayload.setFirstname(fname);
		uerPayload.setLastname(lname);
		uerPayload.setEmail(usermail);
		uerPayload.setPassword(pwd);
		uerPayload.setPhone(ph);
		Response response=UserEndPoints.createUser(uerPayload);		
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	
	@Test(priority=2, dataProvider="UserNames", dataProviderClass=DataProviders.class)
	public void testdeleteuserbyname(String username) {
		
		
		Response response=UserEndPoints.deleteUser(username);
		Assert.assertEquals(response.getStatusCode(), 200);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

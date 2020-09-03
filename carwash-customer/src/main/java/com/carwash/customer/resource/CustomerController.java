package com.carwash.customer.resource;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.UUID;

import org.bson.Document;
import com.amazonaws.services.lambda.runtime.Context;
import com.carwash.customer.model.Car;
import com.carwash.customer.model.Customer;
import com.carwash.customer.model.Request;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class CustomerController {
	
	public static Object handleRequests(Request request, Context context) throws IOException
	{
		MongoClientURI uri = new MongoClientURI("mongodb+srv://admin:admin@cluster0.u9q0x.mongodb.net/test?retryWrites=true&w=majority");
		MongoClient mongoClient = new MongoClient(uri);
		MongoDatabase database = mongoClient.getDatabase("test");
		MongoCollection<Document> collection = database.getCollection("customer");
    	Customer customer = request.getCustomer();
    	Document document = new Document();
    	document.put("customerId", UUID.randomUUID());
    	document.put("addressLine1", customer.getAddressLine1());
    	document.put("addressLine2", customer.getAddressLine2());
    	document.put("city",customer.getCity());
    	collection.insertOne(document);
    	mongoClient.close();
    	insertCarDetails(new Car(customer.getCustomerId(), customer.getCustomerName(), customer.getCarType(), customer.getCarModel()));
    	return customer;
    }
	
	public static void insertCarDetails(Car car) throws IOException
	{
		final String POST_PARAMS =  "{\r\n    \"id\": \""+car.getId()+"\",\r\n    \"owner\": \""+car.getOwner()+"\",\r\n    \"type\": \""+car.getType()+"\",\r\n    \"model\": \""+car.getModel()+"\"\r\n}";
	    System.out.println(POST_PARAMS);
	    URL obj = new URL("https://fxnsz6idi7.execute-api.us-east-2.amazonaws.com/dev/car");
	    HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
	    postConnection.setRequestMethod("POST");
	    postConnection.setRequestProperty("Content-Type", "application/json");
	    postConnection.setDoOutput(true);
	    OutputStream os = postConnection.getOutputStream();
	    os.write(POST_PARAMS.getBytes());
	    os.flush();
	    os.close();
	    int responseCode = postConnection.getResponseCode();
	    System.out.println("POST Response Code :  " + responseCode);
	    System.out.println("POST Response Message : " + postConnection.getResponseMessage());
	    if (responseCode == HttpURLConnection.HTTP_CREATED) { //success
	        BufferedReader in = new BufferedReader(new InputStreamReader(
	            postConnection.getInputStream()));
	        String inputLine;
	        StringBuffer response = new StringBuffer();
	        while ((inputLine = in .readLine()) != null) {
	            response.append(inputLine);
	        } in .close();
	        System.out.println(response.toString());
	    }

	}
	 
}

package com.carwash.washer.resource;

import java.io.IOException;

import org.bson.Document;

import com.amazonaws.services.lambda.runtime.Context;
import com.carwash.washer.model.Appointment;
import com.carwash.washer.model.Request;
import com.carwash.washer.model.Washer;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class washerController {

	public static Object handleLoginRequests(Request request, Context context) throws IOException
	{
		MongoClientURI uri = new MongoClientURI("mongodb+srv://admin:admin@cluster0.u9q0x.mongodb.net/test?retryWrites=true&w=majority");
		MongoClient mongoClient = new MongoClient(uri);
		MongoDatabase database = mongoClient.getDatabase("test");
		MongoCollection<Document> collection = database.getCollection("userDetails");
		try {
			Washer washer = request.getWasher();
			BasicDBObject query = new BasicDBObject();
			query.put("email", washer.getEmail());
			Document result = collection.find(query).iterator().next();
			if(result.getString("password").equals(washer.getPassword())) {
				mongoClient.close();
				return TokenGenerator.getToken(washer.getEmail(), washer.getPassword(), result.getString("name"));
				}
			else
			{
				return "Wrong Password";
			}
	}catch (Exception e) {
	   System.out.println("Exception Raised");
	}
		return collection;

}
	
	public static Object handleRegisterRequests(Request request, Context context) {
		MongoClientURI uri = new MongoClientURI("mongodb+srv://admin:admin@cluster0.u9q0x.mongodb.net/test?retryWrites=true&w=majority");
		MongoClient mongoClient = new MongoClient(uri);
		MongoDatabase database = mongoClient.getDatabase("test");
		MongoCollection<Document> collection = database.getCollection("appointment");
		
		Appointment appointment = request.getAppointment();
		
		return "Entry Recorded";
	}

}

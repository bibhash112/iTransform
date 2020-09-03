package com.carwash.loginRegister.resource;

import java.io.IOException;

import org.bson.Document;

import com.amazonaws.services.lambda.runtime.Context;
import com.carwash.model.Request;
import com.carwash.model.User;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;


public class UserController {
	
	public static Object handleLoginRequests(Request request, Context context) throws IOException
	{
		MongoClientURI uri = new MongoClientURI("mongodb+srv://admin:admin@cluster0.u9q0x.mongodb.net/test?retryWrites=true&w=majority");
		MongoClient mongoClient = new MongoClient(uri);
		MongoDatabase database = mongoClient.getDatabase("test");
		MongoCollection<Document> collection = database.getCollection("userDetails");
		try {
			User user = request.getUser();
			BasicDBObject query = new BasicDBObject();
			query.put("email", user.getEmail());
			Document result = collection.find(query).iterator().next();
			if(result.getString("password").equals(user.getPassword())) {
				mongoClient.close();
				return TokenGenerator.getToken(user.getEmail(), user.getPassword(), result.getString("name"));
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
		MongoCollection<Document> collection = database.getCollection("userDetails");
		
		User user = request.getUser();
		Document document = new Document();
		document.put("userID", user.getUserID());
		document.put("name", user.getName());
		document.put("email", user.getEmail());
		document.put("password", user.getPassword());
		collection.insertOne(document);
		mongoClient.close();
		return "Entry Recorded";
	}
}

package com.carwash.cardetails.resource;


import org.bson.Document;
import com.amazonaws.services.lambda.runtime.Context;
import com.carwash.cardetails.model.Car;
import com.carwash.cardetails.model.Request;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class CarController {
	
	
	public static Object handleRequests(Request request, Context context)
	{
		MongoClientURI uri = new MongoClientURI("mongodb+srv://admin:admin@cluster0.u9q0x.mongodb.net/test?retryWrites=true&w=majority");
		MongoClient mongoClient = new MongoClient(uri);
		MongoDatabase database = mongoClient.getDatabase("test");
		MongoCollection<Document> collection = database.getCollection("test");
		switch (request.getHttpMethod()) {
		case "GET":
			
			BasicDBObject query = new BasicDBObject();
			query.put("id", request.getId());
			Document result = collection.find(query).iterator().next();
			mongoClient.close();
				return new Car(result.getString("id"), result.getString("owner"), result.getString("type"), result.getString("model"));
             
    	case "POST":
    		Car car = request.getCar();
    		Document document = new Document();
    	    document.put("id", car.getId());
    	    document.put("owner", car.getOwner());
    	    document.put("type", car.getType());
    	    document.put("model", car.getModel());
    		collection.insertOne(document);
    		mongoClient.close();
    		return car;
		default:
			mongoClient.close();
			break;
		}
		return null;
    	}
	 
}

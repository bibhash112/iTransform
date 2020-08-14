package com.carwash.cardetails.resource;
import org.bson.Document;
import com.carwash.cardetails.model.Car;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;


public class CarTest {
	
	public static Object returnCar()
	{

		MongoClientURI uri = new MongoClientURI(
			    "mongodb+srv://admin:admin@cluster0.u9q0x.mongodb.net/test?retryWrites=true&w=majority");

			MongoClient mongoClient = new MongoClient(uri);
			MongoDatabase database = mongoClient.getDatabase("test");
			MongoCollection<Document> collection = database.getCollection("test");
			BasicDBObject query = new BasicDBObject();
			query.put("id", "101");
			Document result = collection.find(query).iterator().next();
			mongoClient.close();
			return new Car(result.getString("id"), result.getString("owner"), result.getString("type"), result.getString("model"));
			//System.out.println(result.getString("test3"));
	}
	
	public static void main(String[] args)
	{
		Car car2 =(Car) returnCar();
		System.out.println(car2.getOwner());
	}

}
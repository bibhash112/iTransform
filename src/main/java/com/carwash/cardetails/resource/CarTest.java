package com.carwash.cardetails.resource;
import com.carwash.cardetails.model.Car;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;


public class CarTest {
	
	public static Object returnCar()
	{
		 try{
             
             @SuppressWarnings("resource")
             MongoClient mongo = new MongoClient( "ec2-18-190-25-192.us-east-2.compute.amazonaws.com" , 27017 );  
             
             @SuppressWarnings("deprecation")
             DB db = mongo.getDB("CarWash");  
             
             DBCollection table = db.getCollection("Car");  
             System.out.println("Data received successfully");
         	BasicDBObject searchQuery = new BasicDBObject();
         	searchQuery.put("_id", 102);
         	DBCursor cursor = table.find(searchQuery);
         	 
         	while (cursor.hasNext()) {
         		Car car = new Car((int)cursor.one().get("_id"), cursor.one().get("owner").toString(), cursor.one().get("type").toString(), cursor.one().get("model").toString());
        	    return car;
         	  
         	}
             //return (int)cursor.one().get("code");
		      }
			  catch(Exception e)
			  {
				  System.out.println("0");
				  return null;
			  }
		return null;
	}
	
	public static void main(String[] args)
	{
		Car car2 =(Car) returnCar();
		System.out.println(car2.getOwner());
	}

}
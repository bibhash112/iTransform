package com.carwash.cardetails.resource;


import com.amazonaws.services.lambda.runtime.Context;
import com.carwash.cardetails.model.Car;
import com.carwash.cardetails.model.Request;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;


public class CarController {
	
	
	public static Object handleRequests(Request request, Context context)
	{
		switch (request.getHttpMethod()) {
		case "GET": 
			/*
			 * @SuppressWarnings("resource") MongoClient mongo = new MongoClient(
			 * "ec2-18-190-25-192.us-east-2.compute.amazonaws.com" , 27017 );
			 * 
			 * @SuppressWarnings("deprecation") DB db = mongo.getDB("CarWash"); DBCollection
			 * table = db.getCollection("Car"); BasicDBObject searchQuery = new
			 * BasicDBObject(); searchQuery.put("_id", request.getId()); DBCursor cursor =
			 * table.find(searchQuery); while (cursor.hasNext()) { Car car = new
			 * Car((int)cursor.one().get("_id"), cursor.one().get("owner").toString(),
			 * cursor.one().get("type").toString(), cursor.one().get("model").toString());
			 * return car; }
			 */
			return new Car(101, "Bibhash", "SUV", "Sedan");
             
//		case "POST":
//			car =(request.getCar());
//			repository.save(car);
//			return car;
		default:
			
			break;
		}
		return null;
    	}
	
	
	/*
	 * @PostMapping("/addCar") public String saveCar(@RequestBody Car car) {
	 * repository.save(car); return "Added car with id: " + car.getId(); }
	 * 
	 * @GetMapping("/getAllCars") public List<Car> returnAll() { return
	 * repository.findAll(); }
	 * 
	 * @GetMapping("getCar/{id}") public Optional<Car> getCarById(@PathVariable int
	 * id) { return repository.findById(id); }
	 * 
	 * @DeleteMapping("/deleteCar/{id}") public String deleteCarById(@PathVariable
	 * int id) { repository.deleteById(id); return "Deleted car with id: "+id; }
	 */
	 
}

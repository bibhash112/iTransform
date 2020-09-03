package com.carwash.cardpayment.resource;


import org.bson.Document;
import com.amazonaws.services.lambda.runtime.Context;
import com.carwash.cardpayment.model.Card;
import com.carwash.cardpayment.model.Request;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class CardController {
	
	public static Object handleRequests(Request request, Context context)
	{
		MongoClientURI uri = new MongoClientURI("mongodb+srv://admin:admin@cluster0.u9q0x.mongodb.net/test?retryWrites=true&w=majority");
		MongoClient mongoClient = new MongoClient(uri);
		MongoDatabase database = mongoClient.getDatabase("test");
		MongoCollection<Document> collection = database.getCollection("cardpayments");
		switch (request.getHttpMethod()) {
		case "GET":
			
			BasicDBObject query = new BasicDBObject();
			query.put("id", request.getId());
			Document result = collection.find(query).iterator().next();
			mongoClient.close();
				return new Card(result.getString("transactionid"), result.getString("holderName"), result.getString("cardType"), result.getString("cardNumber"));
    	case "POST":
    		Card card = request.getCard();
    		Document document = new Document();
    	    document.put("id", card.getId());
    	    document.put("holderName", card.getHolderName());
    	    document.put("cardType", card.getCardType());
    	    document.put("cardNumber", card.getCardNumber());
    	    card.setSuccess(true);
    	    document.put("success", true);
    		collection.insertOne(document);
    		mongoClient.close();
    		return card;
		default:
			mongoClient.close();
			break;
		}
		return null;
    	}
	 
}

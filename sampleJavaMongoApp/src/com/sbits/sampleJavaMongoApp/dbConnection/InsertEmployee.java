package com.sbits.sampleJavaMongoApp.dbConnection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class InsertEmployee {

	 public static void main( String args[] ) {  
	      
	      // Creating a Mongo client 
	      MongoClient mongo = new MongoClient( "localhost" , 27017 ); 
	   
	      
	      // Accessing the database 
	      MongoDatabase database = mongo.getDatabase("myDbase2"); 
	      System.out.println("Database "+database);
	      
	      
	      
	      
	      //fetching object id from company
         ObjectId sbID= new ObjectId("5ebe2dfab3542f14ceafd233");
         ObjectId pieriandxID= new ObjectId("5ebe2dfab3542f14ceafd234");
         ObjectId persistentID= new ObjectId("5ebe2dfab3542f14ceafd235");

	      
	      
	      // Retrieving a collection

    	MongoCollection<Document> collection = database.getCollection("employee");

	Document doc1 = new Document("name","subhankari").append("email","subhankari@sb.com").append("company",sbID ).append("experience",4);
	Document doc2 = new Document("name","latha").append("email","latha@sb.com").append("company",sbID ).append("experience",5);
	Document doc3 = new Document("name","akhil").append("email","akhil@pieriandx.com").append("company",pieriandxID ).append("experience",6);
	Document doc4 = new Document("name","gufran").append("email","gufran@persistent.com").append("company",persistentID ).append("experience",7);
	
	List<Document> documents = new ArrayList<>();
	documents.add(doc1);
	documents.add(doc2);
	documents.add(doc3);
	documents.add(doc4);

	collection.insertMany(documents);
	System.out.println("collection created successfully");

	FindIterable<Document> iterDoc = collection.find();
	int i = 1;
	// Getting the iterator
	Iterator it = iterDoc.iterator();
	while (it.hasNext()) {
	System.out.println(it.next());
	i++;
	}


	 }
}

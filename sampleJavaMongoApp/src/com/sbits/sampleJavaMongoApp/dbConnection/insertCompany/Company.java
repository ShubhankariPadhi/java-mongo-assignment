package com.sbits.sampleJavaMongoApp.dbConnection.insertCompany;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Indexes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient; 
import com.mongodb.MongoCredential;  

public class Company {
	

	   
	   public static void main( String args[] ) {  
	      
	      // Creating a Mongo client 
	      MongoClient mongo = new MongoClient( "localhost" , 27017 ); 
	   
	      // Creating Credentials 
	      MongoCredential credential; 
	      credential = MongoCredential.createCredential("sampleUser", "myDbase2", 
	         "password".toCharArray()); 
	      System.out.println("Connected to the database successfully");  
	      
	      // Accessing the database 
	      MongoDatabase database = mongo.getDatabase("myDbase2"); 
	      System.out.println("Credentials ::"+ credential);  
	      System.out.println("Database "+database);
	      
	      
	      //Creating a collection 
	      database.createCollection("company"); 
	      System.out.println("Collection created successfully"); 
	      
	      
	      // Retrieving a collection

	MongoCollection<Document> collection = database.getCollection("company");

	Document document1 = new Document("name","SB").append("since", 10);
	Document document2 = new Document("name","Pieriandx").append("since", 6);
	Document document3 = new Document("name","Persistent").append("since", 14);

	List<Document> documents = new ArrayList<>();
	documents.add(document1);
	documents.add(document2);
	documents.add(document3);

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

	collection.createIndex(Indexes.ascending("name"));

	}
	

}

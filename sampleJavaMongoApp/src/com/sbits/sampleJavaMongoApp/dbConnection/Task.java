package com.sbits.sampleJavaMongoApp.dbConnection;

import java.util.Arrays;
import java.util.Iterator;
import org.bson.Document;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;

public class Task {

	
	 public static void main( String args[] ) {  
	      
	      // Creating a Mongo client 
	      MongoClient mongo = new MongoClient( "localhost" , 27017 ); 
	   
	      
	      // Accessing the database 
	      MongoDatabase database = mongo.getDatabase("myDbase2"); 
	      System.out.println("Database "+database);
	      

	      MongoCollection<Document> companyCollection = database.getCollection("company");

	      MongoCollection<Document> employeeCollection = database.getCollection("employee");
	      
	      
	 //  1. Count no of companies   
	 Long count=companyCollection.count();
	 System.out.println("number of companies : "+count);
	 
	
	 // 2. count no of employees	  
     count=employeeCollection.count();
	 System.out.println("number of employees : "+count);
	 
	// 3. Find companies which are less than 10 years
	 BasicDBObject whereQuery = new BasicDBObject();
	 whereQuery.put("since", new BasicDBObject("$lt", 10));
	 FindIterable<Document> iterDoc = companyCollection.find(whereQuery);
	 
	 int i = 1;
		// Getting the iterator
		Iterator it = iterDoc.iterator();
		while (it.hasNext()) {
		System.out.println(it.next());
		i++;
		}

		
		
		
	//  5. Calculate average experience of employee by company wise
		 AggregateIterable<Document> documents
         = employeeCollection.aggregate(
                 Arrays.asList(
                         Aggregates.group("$company",
                                 Accumulators.avg("averageExperience", "$experience")) ));
	 		 
		  i = 1;
			// Getting the iterator
		  it = documents.iterator();
			while (it.hasNext()) {
			System.out.println(it.next());
			i++;
			}

	 }
	
}

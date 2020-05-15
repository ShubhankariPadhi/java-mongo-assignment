package com.sbits.sampleJavaMongoApp.dbConnection;

import java.util.Arrays;
import java.util.Iterator;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Sorts;
import com.mongodb.operation.OrderBy;

public class RegexEmail {

	 public static void main( String args[] ) {  
	      
	      // Creating a Mongo client 
	      MongoClient mongo = new MongoClient( "localhost" , 27017 ); 
	   
	      
	      // Accessing the database 
	      MongoDatabase database = mongo.getDatabase("myDbase2"); 
	      System.out.println("Database "+database);
	

MongoCollection<Document> employeeCollection =  database.getCollection("employee");

Document regQuery = new Document();
regQuery.append("$regex", "a");
	
Document findQuery = new Document();
findQuery.append("email", regQuery);

FindIterable<Document> documents = employeeCollection.find(findQuery).sort(Sorts.ascending("experience"));

Iterator it = documents.iterator();
while (it.hasNext()) {
System.out.println(it.next());
}
}
}

/*
Document regQuery = new Document();
regQuery.append("$regex", "su");

Document findQuery = new Document();
findQuery.append("email", regQuery);

FindIterable<Document> documents = employeeCollection.find(findQuery);


AggregateIterable<Document> documents
= employeeCollection.aggregate(
        Arrays.asList(
                Aggregates.sort(S)("$company",
                         ));



 i = 1;
	// Getting the iterator
 it = documents.iterator();
	while (it.hasNext()) {
	System.out.println(it.next());
	i++;
	}
}}*/
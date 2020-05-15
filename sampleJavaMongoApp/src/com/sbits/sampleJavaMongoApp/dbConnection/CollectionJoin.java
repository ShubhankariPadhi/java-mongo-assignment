package com.sbits.sampleJavaMongoApp.dbConnection;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.bson.Document;

import com.mongodb.AggregationOutput;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;

public class CollectionJoin {

	 public static void main( String args[] ) {  
	      
	      // Creating a Mongo client 
	      MongoClient mongo = new MongoClient( "localhost" , 27017 ); 
	      
	      // Accessing the database 
	      DB database = mongo.getDB("myDbase2"); 
	      System.out.println("Database "+database);

	     DBCollection  employeeCollection = database.getCollection("employee");
	  
	   // 4. Join companies & employees. Display details of employee 'kumar'

	     
      // create the pipeline operations, first with the $match
       DBObject match = new BasicDBObject("$match",
        new BasicDBObject("name", "latha")  );

    // build the $lookup operations
    DBObject lookupFields = new BasicDBObject("from", "company");
    lookupFields.put("localField", "company");
    lookupFields.put("foreignField", "_id");
    lookupFields.put("as", "company");      
    DBObject lookup = new BasicDBObject("$lookup", lookupFields);

    // build the $project operations
    DBObject projectFields = new BasicDBObject("name", 1);
    projectFields.put("name", 1);
    projectFields.put("email", 1);
    projectFields.put("_id", 0);
    projectFields.put("companyName", "$company.name");       
    DBObject project = new BasicDBObject("$project", projectFields);

    List<DBObject> pipeline = Arrays.asList(match, lookup, project);

    AggregationOutput output = employeeCollection.aggregate(pipeline);

    for (DBObject result : output.results()) {
        System.out.println(result);
    }
    
    
}
}
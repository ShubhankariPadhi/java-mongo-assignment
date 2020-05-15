package com.sbits.sampleJavaMongoApp.dbConnection;

import com.mongodb.client.MongoDatabase;


import com.mongodb.MongoClient; 
import com.mongodb.MongoCredential;  

public class DbConn_CollectionCreation {
	

	   
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
	      
	      
	      //Creating a collection company
	      database.createCollection("company"); 
	      System.out.println("Collection created successfully"); 
	      
	    //Creating a collection employee
	      database.createCollection("employee"); 
	      System.out.println("Collection created successfully"); 
	      

	
	   }
}

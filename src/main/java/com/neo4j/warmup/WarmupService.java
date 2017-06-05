package com.neo4j.warmup;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.Transaction;


@Path("locator")
public class WarmupService {
	

  




  @GET
  @Path("/helloworld")
  public String helloWorld() {
      return "Hello World!";
  }
  
  @GET
  @Path("/warmupAll")
  public String warmUp(@Context GraphDatabaseService db) {
	  int counter=1;
	  int nodeCounter = 0;
	  int relCounter = 0;
	  int propCounter = 0;
	  Transaction tx = db.beginTx();
      try 
      {


//for Neo4j 3.0.0
    	  for (Node node : db.getAllNodes()) {
              node.getPropertyKeys();              
              counter ++;
              nodeCounter ++;
              for (String key : node.getPropertyKeys()) {
            	    node.getProperty(key);
            	    propCounter ++;
            	}
              if (counter % 10_000 == 0) {
                  tx.success();
                  tx.close();
                  tx = db.beginTx();
              }
          }
    	  
    	  for ( Relationship relationship : db.getAllRelationships()){
              relationship.getPropertyKeys();
              relationship.getNodes();
              counter ++;
              relCounter ++;
              for (String key : relationship.getPropertyKeys()) {
            	  relationship.getProperty(key);
            	  propCounter ++;
          	}
              if (counter % 10_000 == 0) {
                  tx.success();
                  tx.close();
                  tx = db.beginTx();
              }
          } 
  
      }catch (Exception e){
      	System.out.println(e);
      }
      return "Nodes Hit: " + nodeCounter + "\n" + "Relationships hit: " + relCounter + "\n" + "Properties Hit: " + propCounter + "\n" +" Warmed up and ready to go!";
  }
  
  @GET
  @Path("/warmupNodes")
  public String warmupNodes(@Context GraphDatabaseService db) {
	  int counter=1;
	  int nodeCounter = 0;
	  int propCounter = 0;
	  Transaction tx = db.beginTx();
      try 
      {


//for Neo4j 3.0.0
    	  for (Node node : db.getAllNodes()) {
              node.getPropertyKeys();              
              counter ++;
              nodeCounter ++;
              for (String key : node.getPropertyKeys()) {
            	    node.getProperty(key);
            	    propCounter ++;
            	}
              if (counter % 10_000 == 0) {
                  tx.success();
                  tx.close();
                  tx = db.beginTx();
              }
          }
  
      }catch (Exception e){
      	System.out.println(e);
      }
      return "Nodes Hit: " + nodeCounter + "\n" + "Properties Hit: " + propCounter + "\n" +" Warmed up and ready to go!";
  }
  
  @GET
  @Path("/warmupRelationships")
  public String warmUpRels(@Context GraphDatabaseService db) {
	  int counter=1;
	  int relCounter = 0;
	  int propCounter = 0;
	  Transaction tx = db.beginTx();
      try 
      {


//for Neo4j 3.0.0
    	  for ( Relationship relationship : db.getAllRelationships()){
              relationship.getPropertyKeys();
              relationship.getNodes();
              counter ++;
              relCounter ++;
              for (String key : relationship.getPropertyKeys()) {
            	  relationship.getProperty(key);
            	  propCounter ++;
          	}
              if (counter % 10_000 == 0) {
                  tx.success();
                  tx.close();
                  tx = db.beginTx();
              }
          } 
  
      }catch (Exception e){
      	System.out.println(e);
      }
      return "Relationships hit: " + relCounter + "\n" + "Properties Hit: " + propCounter + "\n" +" Warmed up and ready to go!";
  }  
}
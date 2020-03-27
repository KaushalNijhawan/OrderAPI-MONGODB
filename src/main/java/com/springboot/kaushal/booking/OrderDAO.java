package com.springboot.kaushal.booking;


import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.mongodb.MongoClient;

import java.util.*;


public class OrderDAO {
 static Map<Integer,Order> order = new HashMap<Integer,Order>();
 
 
 public Order createOrder(Order obj) {
	 MongoTemplate mt = getConnection();
	mt.insert(obj,"Order");
		 return obj;
 }
 
 public String deleteOrder(int id) {
	 MongoTemplate mt = getConnection();
	 Query query = new Query();
	 query.addCriteria(Criteria.where("orderID").is(id));
	 mt.remove(query, Order.class,"Order");
	 return "success!";
	
 }
 
 public ArrayList<Order> showAllOrder() {
	 MongoTemplate mt = getConnection();
	 ArrayList<Order> allUsers = (ArrayList<Order>) mt.findAll(Order.class ,"Order");
	 
	 return allUsers;
 }
 
 public Order updateOrder(int id, Order obj) {
	 MongoTemplate mt = getConnection();
	 Update update = new Update();
	 Query query = new Query();
	 query.addCriteria(Criteria.where("OrderID").is(id));
	 Order obj2 = mt.findOne(query, Order.class,"Order");
	 update.set("OrderID", obj.getId());
	 update.set("oderName", obj.getOrderName());
	 update.set("orderDestination", obj.getOrderDestination());
	 update.set("orderSource", obj.getOrderSource());
	 mt.updateFirst(query,update,Order.class,"Order");
	return obj;
 }
 
 public Order getOrderById(int id) {
	
	MongoTemplate mt = getConnection();
	 Query query = new Query();
	query.addCriteria(Criteria.where("OrderID").is(id));
	Order obj = mt.findOne(query,Order.class,"Order");
	 return obj;
 }
 
 private MongoTemplate getConnection() {

		MongoDbFactory df = new SimpleMongoDbFactory(new MongoClient("localhost"), "OrderApi");
		MongoTemplate mt = new MongoTemplate(df);

		return mt;
	}
}

package com.springboot.kaushal.booking;
import java.util.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins="*")
@SpringBootApplication
@RestController
public class SpringServiceOrderApplication {
	private OrderDAO odao = new OrderDAO();
    
	public static void main(String[] args) {
		SpringApplication.run(SpringServiceOrderApplication.class, args);
	}

	@RequestMapping("/orderApi/createOrder/")
	public Order createUser() {
		int id =(int)(Math.random()*100);
	   Order obj = new Order(id,"MyParcel" ,"Rohtak" ,"Chennai");
	   odao.createOrder(obj);
		return obj;
	}
	
	@RequestMapping("/")
	public String showPage() {
		return "This is the HomePage of the Website!!";
	}
	
	@RequestMapping("/orderApi/getAllOrders")
	public ArrayList<Order> getAllOrder(){
		return odao.showAllOrder();
	}
	
	@RequestMapping("/orderApi/deleteOrder/{id}")
	public String deletedOrder(@PathVariable("id") String id) {
		return odao.deleteOrder(Integer.parseInt(id));
	}
	
	@RequestMapping("/orderApi/updateOrder/{id}")
	public Order updateOrder(@PathVariable("id") String id) {
		Order obj = new Order(Integer.parseInt(id),"MyParcel" ,"Delhi" ,"Kolkata");
		if(odao.updateOrder(Integer.parseInt(id), obj) == null) {
			System.err.println("ID doesn't Matched!!");
		}
		return obj;
	}
	@RequestMapping("/orderApi/getOrderById/{id}")
    public Order getOrderById(@PathVariable("id") String id) {
		return odao.getOrderById(Integer.parseInt(id));
	}
}

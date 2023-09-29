package sk.marekpecho.barista_service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import sk.marekpecho.barista_service.enums.State;
import sk.marekpecho.barista_service.model.Order;


/**
 * Hello world!
 *
 */
public class App 
{
	private static Order order = null;
	private static ObjectMapper objectMapper = new ObjectMapper();
	private static String orderAsString = null;
	private static int SLEEP = 1000;
	private static HttpResponse<String> response = null;

	public static void main(String[] args) {

		System.out.println("Initialization...");
		
		while (true) {
			// Get order, init
			order=null;
			getFirstOrder();
			System.out.println(order);

			// In preparation
			order.setState(State.IN_PREPARATION);
			updateOrder(orderAsString);
			sleep();
			System.out.println(order);

			// Finished
			order.setState(State.FINISHED);
			updateOrder(orderAsString);
			sleep();
			System.out.println(order);

			// Picked up
			order.setState(State.PICKED_UP);
			updateOrder(orderAsString);
			sleep();
			System.out.println(order);
			
			// Delete order
			deleteOrder();
			sleep();
			System.out.println("Order deleted");
		}
	}

	private static void sleep() {
		try {
			Thread.sleep(SLEEP);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static void deleteOrder() {
		Long orderID = order.getId();
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("http://localhost:8080/orders-service-v2/webapi/orders/" + orderID))
				.method("DELETE", HttpRequest.BodyPublishers.noBody()).build();

		try {
			response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static void updateOrder(String orderAsString) {

		try {
			orderAsString = objectMapper.writeValueAsString(order);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("http://localhost:8080/orders-service-v2/webapi/orders"))
				.method("PUT", HttpRequest.BodyPublishers.ofString(orderAsString))
				.setHeader("Content-type", "application/json").build();

		try {
			response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
			String json = response.body();
			order = objectMapper.readValue(json, Order.class);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static void getFirstOrder() {
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("http://localhost:8080/orders-service-v2/webapi/orders/firstOrder"))
				.method("GET", HttpRequest.BodyPublishers.noBody()).build();
		while(order==null) {
		try {
			
			response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
			String json = response.body();
			order = objectMapper.readValue(json, Order.class);
			
		} catch (IOException e) {
			//e.printStackTrace();
			System.out.println("There is no order.");
			sleep();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		}
	}

	@SuppressWarnings("unused")
	private static void getAllOrders() {
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("http://localhost:8080/orders-service-v2/webapi/orders"))
				.method("GET", HttpRequest.BodyPublishers.noBody()).build();

		try {
			response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
			String json = response.body();
			List<Order> orders = objectMapper.readValue(json, new TypeReference<List<Order>>() {
			});
			orders.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}

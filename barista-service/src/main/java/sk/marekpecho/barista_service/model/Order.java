package sk.marekpecho.barista_service.model;

import sk.marekpecho.barista_service.enums.Coffee;
import sk.marekpecho.barista_service.enums.Milk;
import sk.marekpecho.barista_service.enums.Size;
import sk.marekpecho.barista_service.enums.State;
import sk.marekpecho.barista_service.enums.Takeaway;

public class Order {

	private Long id;
	private Coffee coffee;
	private Size size;
	private Milk milk;
	private Takeaway takeaway;
	private Double price;
	private State state;

	public Order() {

	}

	public Order(Long id, Coffee coffee, Size size, Milk milk, Takeaway takeaway, Double price, State state) {
		super();
		this.id = id;
		this.coffee = coffee;
		this.size = size;
		this.milk = milk;
		this.takeaway = takeaway;
		this.price = price;
		this.state = state;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Coffee getCoffee() {
		return coffee;
	}

	public void setCoffee(Coffee coffee) {
		this.coffee = coffee;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public Milk getMilk() {
		return milk;
	}

	public void setMilk(Milk milk) {
		this.milk = milk;
	}

	public Takeaway getTakeaway() {
		return takeaway;
	}

	public void setTakeaway(Takeaway takeaway) {
		this.takeaway = takeaway;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", coffee=" + coffee + ", size=" + size + ", milk=" + milk + ", takeaway=" + takeaway
				+ ", price=" + price + ", state=" + state + "]";
	}

}

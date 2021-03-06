package com.thecolony.tractus.economics;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.thecolony.tractus.economics.products.Product;
import com.thecolony.tractus.economics.products.Quantity;


public class Inventory {
	private Map<Product, Quantity> inventory;
	
	public Inventory() {
		inventory = new HashMap<Product, Quantity>();
	}
	
	public Inventory(Map<Product, Quantity> inventory) {
		Map<Product, Quantity> copy = new HashMap<Product, Quantity>();
		copy.putAll(inventory);
		this.inventory = copy;
	}
	
	public Inventory(Inventory other) {
		this(other.inventory);
	}
	
	public void addInventoryFrom(Inventory other) {
		for (Product product : other.getProducts()) {
			addQuantityOfProductImpl(product, other.getAmountOf(product));
		}
	}
	
	public boolean isEmpty() {
		return inventory.isEmpty() || allEmpty();
	}
	
	private boolean allEmpty() {
		for (Product p : getProducts()) {
			if (Double.compare(getAmountOf(p), 0.0) != 0)
				return false;
		}
		return true;
	}
	
	public boolean contains(Product product) {
		return inventory.get(product) != null;
	}
	
	public void setQuantityOf(Product product, double quantity) {
		inventory.put(product, new Quantity(product, Math.max(0.0, quantity)));
	}
	
	public void setQuantityOf(Quantity quantity) {
		setQuantityOf((Product)quantity.getUnit(), quantity.getQuantity());
	}
	
	public Quantity getQuantityOf(Product product) {
		Quantity stored = inventory.get(product);
		return stored == null ? Quantity.NullQuantity : stored;
	}
	
	public double getAmountOf(Product product) {
		if (!contains(product))
			return 0.0;
		return inventory.get(product).getQuantity();
	}
	
	public void addQuantityOfProduct(Product product, double quantity) {
		assertNotNegative(quantity);
		addQuantityOfProductImpl(product, quantity);
	}
	
	public void addQuantityOfProduct(Quantity quantity) {
		addQuantityOfProduct((Product)quantity.getUnit(), quantity.getQuantity());
	}

	private void assertNotNegative(double quantity) {
		if (quantity < 0.0)
			throw new IllegalArgumentException("Quantity must not be negative!");
	}

	private void addQuantityOfProductImpl(Product product, double quantity) {
		if (contains(product))
			setQuantityOf(product, inventory.get(product).getQuantity() + quantity);
		else
			setQuantityOf(product, quantity);
	}
	
	public void removeQuantityOfProduct(Product product, double quantity) {
		assertNotNegative(quantity);
		double oldQuantity = getAmountOf(product);
		if (oldQuantity >= quantity) {
			removeQuantityOfProductImpl(product, quantity);
		} else {
			removeQuantityOfProductImpl(product, oldQuantity);
		}
	}
	
	public void removeQuantityOfProduct(Quantity quantity) {
		removeQuantityOfProduct((Product)quantity.getUnit(), quantity.getQuantity());
	}
	
	private void removeQuantityOfProductImpl(Product product, double quantity) {
		addQuantityOfProductImpl(product, -quantity);
		if (Double.compare(getAmountOf(product), 0.0) == 0)
			inventory.remove(product);
	}
	
	public Set<Product> getProducts() {
		return inventory.keySet();
	}
	
	public void clear() {
		inventory.clear();
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		for (Product p : getProducts()) {
			result.append(p.getType());
			result.append(": ");
			result.append(String.format("%.2f",getAmountOf(p)));
			result.append(' ');
		}
		return result.toString();
	}
	
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof Inventory))
			return false;
		
		Inventory RHS = (Inventory)other;
		for (Product product : getProducts()) {
			if (Double.compare(getAmountOf(product), RHS.getAmountOf(product)) != 0)
				return false;
		}
		
		return getProducts().equals(RHS.getProducts());
	}
}

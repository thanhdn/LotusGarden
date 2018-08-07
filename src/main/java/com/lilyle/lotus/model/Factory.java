package com.lilyle.lotus.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the factory database table.
 * 
 */
@Entity
@NamedQuery(name="Factory.findAll", query=Factory.SELECT_ALL)
@Table(name="Factory")
public class Factory implements Serializable {
	private static final long serialVersionUID = 1L;
	protected static final String SELECT_ALL = "SELECT f FROM Factory f";
	
	@Id
    @Column(name = "factoryId", nullable = false)
	private long factoryId;
	
	 @Column(name = "factoryId")
	private String factoryName;

	//bi-directional many-to-one association to Item
	@OneToMany(mappedBy="factory", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Item> items;

	public Factory() {
	}

	public long getFactoryId() {
		return this.factoryId;
	}

	public void setFactoryId(long factoryId) {
		this.factoryId = factoryId;
	}

	public String getFactoryName() {
		return this.factoryName;
	}

	public void setFactoryName(String factoryName) {
		this.factoryName = factoryName;
	}

	public List<Item> getItems() {
		return this.items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Item addItem(Item item) {
		getItems().add(item);
		item.setFactory(this);

		return item;
	}

	public Item removeItem(Item item) {
		getItems().remove(item);
		item.setFactory(null);

		return item;
	}

}
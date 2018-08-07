package com.lilyle.lotus.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the item database table.
 * 
 */
@Entity
@NamedQuery(name="Item.findAll", query="SELECT i FROM Item i")
@Table(name="Item")
public class Item implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "itemId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int itemId;

	@Column(name = "itemName")
	private String itemName;

	//bi-directional many-to-one association to Factory
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="factoryId")
	private Factory factory;

	public Item() {
	}

	public int getItemId() {
		return this.itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return this.itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Factory getFactory() {
		return this.factory;
	}

	public void setFactory(Factory factory) {
		this.factory = factory;
	}

}
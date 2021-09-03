package com.project1;

public class Ticket {
	private String ticketOwner;
	private int ticketNumber;
	private String ticketType;
	private double amount;
	private String description;
	private String status;
	
	public Ticket() {}
	
	public Ticket(String name, int ticketNumber, String ticketType, double amount, String description, String status) {
		
		ticketOwner = name;
		this.ticketNumber = ticketNumber;
		this.ticketType = ticketType;
		this.amount = amount;
		this.description = description;
		this.status = status;
		
	}

	public String getTicketOwner() {
		return ticketOwner;
	}

	public void setTicketOwner(String ticketOwner) {
		this.ticketOwner = ticketOwner;
	}

	public int getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(int ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public String getTicketType() {
		return ticketType;
	}

	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	}

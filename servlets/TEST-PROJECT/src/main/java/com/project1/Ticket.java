package com.project1;


public class Ticket {
	private int ticketNumber;
	private int ticketOwnerId;
	private String ticketType;
	private double amount;
	private String description;
	private String status;
	
	public Ticket() {}

	public Ticket(int ticketNumber, int ticketOwnerId, String ticketType, double amount, String description,
			String status) {
		super();
		this.ticketNumber = ticketNumber;
		this.ticketOwnerId = ticketOwnerId;
		this.ticketType = ticketType;
		this.amount = amount;
		this.description = description;
		this.status = status;
	}

	public int getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(int ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public int getTicketOwnerId() {
		return ticketOwnerId;
	}

	public void setTicketOwnerId(int ticketOwnerId) {
		this.ticketOwnerId = ticketOwnerId;
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
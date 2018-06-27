package org.tgv.pojo;

public class Nico {

	private String email;
	private String pass;
	private boolean checkout;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public boolean isCheckout() {
		return checkout;
	}
	public void setCheckout(boolean checkout) {
		this.checkout = checkout;
	}
	public Nico(String email, String pass, boolean checkout) {
		super();
		this.email = email;
		this.pass = pass;
		this.checkout = checkout;
	}
	public Nico() {
		super();
	}
	
}

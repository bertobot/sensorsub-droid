package com.example.sensorsub_droid;

public class Submarine {
	
	private String mAddress;
	
	public Submarine(String address) {
		mAddress = address;
	}
	
	private String getURI() {
		return "http://" + mAddress;
	}
	
	public String up() {
		return getURI() + "/up";
	}
	
	public String down() {
		return getURI() + "/down";
	}
	
	public String left() {
		return getURI() + "/left";
	}

	public String right() {
		return getURI() + "/right";
	}
	
	public String move() {
		return getURI() + "/move";
	}


}

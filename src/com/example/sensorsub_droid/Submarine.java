package com.example.sensorsub_droid;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import android.util.Log;

public class Submarine {
	
	private String mAddress;
	
	private DatagramSocket socket;
	
	private InetAddress ipAddress;
	
	private int port = 5500;
		
	public Submarine(String address) throws UnknownHostException, SocketException {
		
		if (address.contains(":")) {
			port = Integer.parseInt(address.substring(address.indexOf(":") + 1));
			ipAddress = InetAddress.getByName(address.substring(0, address.indexOf(":")));
		}
		else
			ipAddress = InetAddress.getByName(address);
		
		socket = new DatagramSocket();
		
		// TODO:
		Log.d("sensorsub-droid", "connected to " + ipAddress.toString() + ":" + port);
	}
	
	public void send(String data) throws IOException {
		socket.send(new DatagramPacket(data.getBytes(), data.getBytes().length, ipAddress, port) );
	}
	
}

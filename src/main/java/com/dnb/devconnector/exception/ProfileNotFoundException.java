package com.dnb.devconnector.exception;

public class ProfileNotFoundException extends Exception{
	public ProfileNotFoundException(String msg)
	 {
		 super(msg);
	 }
	 public String toString() {
		 return super.toString()+super.getMessage();
	 }
}

package com.dnb.devconnector.exception;

public class EmailIdNotFoundException extends Exception{
	public EmailIdNotFoundException(String msg)
	 {
		 super(msg);
	 }
	 public String toString() {
		 return super.toString()+super.getMessage();
	 }
}

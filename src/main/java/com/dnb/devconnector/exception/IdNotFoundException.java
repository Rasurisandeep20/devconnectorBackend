package com.dnb.devconnector.exception;

public class IdNotFoundException extends Exception{
	public IdNotFoundException(String msg)
	 {
		 super(msg);
	 }
	 public String toString() {
		 return super.toString()+super.getMessage();
	 }
}

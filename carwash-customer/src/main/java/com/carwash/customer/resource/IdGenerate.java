package com.carwash.customer.resource;

import java.util.UUID;

public class IdGenerate {
	public static final void main(String... args){
	    //generate random UUIDs
	    UUID idOne = UUID.randomUUID();
	    UUID idTwo = UUID.randomUUID();
	    log("UUID One: " + idOne);
	    log("UUID Two: " + idTwo);
	  }
	  
	  private static void log(Object object){
	    System.out.println( String.valueOf(object) );
	  }

}

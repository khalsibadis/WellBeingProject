package com.esprit.pidevbackend.Twilio;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("twilio")
public class Twilioproperties {
	
	private String accountSid;
	private String authToken;
	private String fromNumber;


	public String getAccountSid() {
		return "ACde2793bd13239d94696149349f291379";
	}
	public void setAccountSid(String accountSid) {
		this.accountSid = accountSid;
	}
	public String getAuthToken() {
		return "aa10c0008a4c7e029b875933767426d0";
	}
	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}
	public String getFromNumber() {
		return "+18646614301" ;
	}
	public void setFromNumber(String fromNumber) {
		this.fromNumber = fromNumber;
	}
	public Twilioproperties() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}

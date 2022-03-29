package com.esprit.pidevbackend.Twilio;

import com.twilio.Twilio;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Twilioinitializer {
	
	private final Twilioproperties twilioproperties;
	
	public Twilioinitializer(Twilioproperties twilioproperties)
	{
		this.twilioproperties=twilioproperties;
		Twilio.init(twilioproperties.getAccountSid(), twilioproperties.getAuthToken());
		System.out.println("twilio intialized with account: "+twilioproperties.getAccountSid());
	}

}

package mt.edu.um.cs.rv.demo.valour.external_triggers;

import java.time.LocalDate;
import java.time.LocalDateTime;

import mt.edu.um.cs.rv.events.triggers.TriggerData;

public class OnSuccessfulLoginTriggerData implements TriggerData  {
	private String username;
	private LocalDateTime loginTime;
	
	public OnSuccessfulLoginTriggerData(String username) {
		this.username = username;
		this.loginTime = LocalDateTime.now();
	}
	public String getUsername() {
		return username;
	}
	public LocalDateTime getLoginTime() {
		return loginTime;
	}
	
}

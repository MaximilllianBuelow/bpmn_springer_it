package org.camunda.bpm.getstarted.sendMessage;
//import java.util.logging.Logger;
import java.util.*; 

import org.camunda.bpm.client.ExternalTaskClient;
public class SendMessageWorker {
	 //private final static Logger LOGGER = Logger.getLogger(SendMessageWorker.class.getName());

	  public static void main(String[] args) {
	    ExternalTaskClient client = ExternalTaskClient.create()
	        .baseUrl("http://localhost:8080/engine-rest")
	        .asyncResponseTimeout(10000) // long polling timeout
	        .build();

	    // subscribe to an external task topic as specified in the process
	    client.subscribe("send-message")
	        .lockDuration(1000) // the default lock duration is 20 seconds, but you can override this
	        .handler((externalTask, externalTaskService) -> {
	          // Put your business logic here

	          // Get a process variable
	          ArrayList<String> gruppe = (ArrayList<String>)externalTask.getVariable("gruppe");
	          
	         System.out.println("Darf der Nutzer der/den Gruppe/n '" + gruppe + "'hinzugefügt werden?" );

	          // Complete the task
	          externalTaskService.complete(externalTask);
	        })
	        .open();
	  }
}

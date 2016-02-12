package com.apress.spring.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apress.spring.websocket.Producer;

@RestController
public class WebSocketController {

	@Autowired
	Producer producer;
	
	@RequestMapping("/send/{topic}")
	public String sender(@PathVariable String topic, @RequestParam String message){
		producer.sendMessageTo(topic, message);
		return "OK-Sent";
	}
	
}

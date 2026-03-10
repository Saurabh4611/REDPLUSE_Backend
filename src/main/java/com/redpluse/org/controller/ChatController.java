package com.redpluse.org.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Redpluse/chat")
@CrossOrigin(origins = "https://redpluse.netlify.app/")
public class ChatController {

@PostMapping
public Map<String,String> chat(@RequestBody Map<String,String> req){

String msg = req.get("message").toLowerCase();

String reply="";

if(msg.contains("donate")){
reply="To donate blood click 'Available Requests' and accept a request.";
}
else if(msg.contains("request")){
reply="Patients can create blood request from dashboard.";
}
else if(msg.contains("hello")){
reply="Hello! I am RedPluse AI assistant. How can I help?";
}
if(msg.contains("need")){
reply="Sign up as Patient Helpers will help you";
}
else{
reply="Please contact hospital for emergency blood needs.";
}

return Map.of("reply",reply);
}
}
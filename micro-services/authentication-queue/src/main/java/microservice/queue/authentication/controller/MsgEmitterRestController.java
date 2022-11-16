package microservice.queue.authentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import microservice.queue.authentication.dto.UserRegisterDTO;
import microservice.queue.authentication.service.Sender;

@RestController
@RequestMapping("/api/auth-queue-microservice")
public class MsgEmitterRestController {

    @Autowired
    Sender busService;

    @PostMapping("/sendMessage")
    public boolean sendInform(@RequestBody UserRegisterDTO userRegister) {
    	busService.sendMessage(userRegister);
        return true;
    }

}


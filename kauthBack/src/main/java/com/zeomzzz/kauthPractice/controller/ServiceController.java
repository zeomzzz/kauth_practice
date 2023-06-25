package com.zeomzzz.kauthPractice.controller;

import java.util.Map;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.zeomzzz.kauthPractice.model.dto.User;

import com.zeomzzz.kauthPractice.model.service.OAuthService;
import com.zeomzzz.kauthPractice.util.JWTUtil;

@RestController
//@AllArgsConstructor
@RequestMapping("/home")
public class ServiceController {
	
	@Autowired
	HttpSession httpsession;
	
    @ResponseBody
    @GetMapping()
    public Object enterHome() throws Exception {
    	
    	return httpsession.getAttribute("kakaoNickname");
    	
    }
    
}
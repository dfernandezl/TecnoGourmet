package com.example.demo.WebController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.UseCases.ReservaUseCases;
import com.example.demo.UseCases.RestaurantUseCases;
import com.example.demo.UseCases.UsuariUseCases;

public class REQUESTWebController {
	private UsuariUseCases usuUseCases;
    private RestaurantUseCases restUseCases;
    private ReservaUseCases rsvUseCases;

    public REQUESTWebController(UsuariUseCases usuUseCases, RestaurantUseCases rest,ReservaUseCases rsvUseCases) {
        this.usuUseCases = usuUseCases;
        this.restUseCases = rest;
        this.rsvUseCases=rsvUseCases;
    }
    
    @RequestMapping(value = "/login")
    public String login(HttpServletRequest request, HttpSession session) {
        if (!session.isNew()) {
            session.invalidate();
        }
        return "login";
    }
}

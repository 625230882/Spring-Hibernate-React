package com.antra.assignment1.servlet;

import com.antra.assignment1.tmpData.UserInfo;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Scanner;
import java.util.UUID;

@Controller
public class LoginLogoutController {


    @RequestMapping(value="/login",method=RequestMethod.POST)
    @ResponseBody
    public String loginRequest(HttpServletRequest req, HttpServletResponse resp, RedirectAttributes redirectAttributes) {
        String form = req.getParameter("value");
        JSONObject jsonForm = new JSONObject(form);
        String userName = jsonForm.getString("userName");
        String password = jsonForm.getString("password");

        resp.setContentType("application/json");
        JSONObject jsonData = new JSONObject();
        if(userName.equals(UserInfo.getUserName()) && password.equals(UserInfo.getPassword())) {
            UUID uuid = UUID.randomUUID();
            req.getSession(true).setAttribute(uuid.toString(), userName);
            Cookie cookie = new Cookie("requestId", uuid.toString());
            resp.addCookie(cookie);
            jsonData.put("success", "success");
            return jsonData.toString();
        }else {
            jsonData.put("errorMessage", "Not correct combination");
            return jsonData.toString();
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest req, HttpServletResponse resp) {
        Cookie[] cookies = req.getCookies();
        for(Cookie c: cookies) {
            if(c.getName().equals("requestId")) {
                if(req.getSession().getAttribute(c.getValue()) != null) {
                    req.getSession().removeAttribute(c.getValue());
                    break;
                }
            }
        }
        return "redirect:/";
    }

}

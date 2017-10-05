package com.antra.assignment1.servlet;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class EmployeeController {
    @RequestMapping(value="/employee", method= RequestMethod.GET)
    public String getEmployee() {
        return "index.jsp";
    }

    @RequestMapping(value="/employee", method= RequestMethod.POST)
    public String addEmployee(HttpServletRequest req) {
        String emp = req.getParameter("employee");
        JSONObject reqJSON = new JSONObject(emp);

        String firstName = reqJSON.getString("firstName").toString();
        String lastName = reqJSON.getString("lastName").toString();
        String age = reqJSON.getString("age").toString();
        return "index.jsp";
    }
}

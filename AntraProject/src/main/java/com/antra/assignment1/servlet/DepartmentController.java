package com.antra.assignment1.servlet;

import com.antra.assignment1.data.Department;
import com.antra.assignment1.service.DepartmentService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @RequestMapping(value="/department", method= RequestMethod.POST)
    @ResponseBody
    public String addDepartment(ModelMap modelMap, HttpServletRequest req) {
        System.out.println("asd");
        String department = req.getParameter("value");
        JSONObject reqJSON = new JSONObject(department);
        departmentService.addDept(new Department(reqJSON.getString("name"), reqJSON.getString("email")));
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("success", "");
        return jsonObject.toString();
    }

    @RequestMapping(value="/department", method= RequestMethod.GET)
    public String getDepartment() {
        return "index.jsp";
    }

}

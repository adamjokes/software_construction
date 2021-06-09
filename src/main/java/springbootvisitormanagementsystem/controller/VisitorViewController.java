package springbootvisitormanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("")
public class VisitorViewController {
    @Autowired

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/viewVisitor", method = RequestMethod.GET)
    public String viewVisitor() {
        return "view_visitor";
    }

    @RequestMapping(value = "/createVisitor", method = RequestMethod.GET)
    public String createVisitor() {
        return "create_visitor";
    }
}


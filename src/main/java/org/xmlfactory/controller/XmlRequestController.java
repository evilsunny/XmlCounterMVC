package org.xmlfactory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.xmlfactory.model.RequestForm;
import org.xmlfactory.service.XmlService;

import javax.validation.Valid;

@Controller
@Component
public class XmlRequestController {

    private final XmlService xmlService;

    @Autowired
    public XmlRequestController(XmlService xmlService) {
        this.xmlService = xmlService;
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView showForm() {
        return new ModelAndView("requestForm", "command", new RequestForm());
    }

    @RequestMapping(value = "/addRequest", method = RequestMethod.POST)
    public String submit(@Valid @ModelAttribute("request") RequestForm request, ModelMap model) {
        model.addAttribute("name", request.getName());
        model.addAttribute("count", request.getCount());
        model.addAttribute("result", xmlService.getNodeValues(request.getName(), request.getCount()));
        return "result";
    }

}

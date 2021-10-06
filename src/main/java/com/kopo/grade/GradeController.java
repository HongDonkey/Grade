package com.kopo.grade;

import java.util.ArrayList;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class GradeController {

	@RequestMapping(value="/", method=RequestMethod.GET)
    public String Home(Locale Locale, Model model) {
        return "home";
    }

    //form
    @RequestMapping(value="/i1", method=RequestMethod.GET)
    public String i1(Locale Locale, Model model) {
        return "i1";
    }

    @RequestMapping(value="/form_input", method=RequestMethod.GET)
    public String form_input(Locale Locale, Model model, @RequestParam("name") String name, @RequestParam("score") int score) {
        DB db = new DB();
        String message = db.insertQuery(new Item(name, score));
        if(message.equals("success")){
            model.addAttribute("message", "입력이 완료되었습니다");
        } else {
            model.addAttribute("message", "입력이 실패했습니다");
        }
        return "message";
    }
    
    //ajax
    @RequestMapping(value="/i2", method=RequestMethod.GET)
    public String i2(Locale Locale, Model model) {
        return "i2";
    }

    @RequestMapping(value="/s1", method=RequestMethod.GET)
    public String s1(Locale Locale, Model model) {
        DB db = new DB();
        ArrayList<Item> results = db.selectQuery();
        model.addAttribute("score_list", results);
        return "s1";
    }

    @RequestMapping(value="/s2", method=RequestMethod.GET)
    public String s2(Locale Locale, Model model) {
        return "s2";
    }

}

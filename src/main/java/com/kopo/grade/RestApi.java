package com.kopo.grade;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestApi {

    @RequestMapping("/create")
	public HashMap<String, String> create() {
		HashMap<String, String> result = new HashMap<String, String>();

        DB db = new DB();
        String query = "CREATE TABLE grade (idx INTEGER PRIMARY KEY AUTOINCREMENT,  name TEXT, score INTEGER, created TEXT, updated TEXT)";
        String message = db.excuteQuery(query);
        
		result.put("message", message);
		return result;
	}
    
    @RequestMapping("/api_input")
	public HashMap<String, String> api_input(@RequestParam("name") String name, @RequestParam("score") int score) {
		HashMap<String, String> result = new HashMap<String, String>();

        DB db = new DB();
        String message = db.insertQuery(new Item(name, score));        
		result.put("message", message);
		return result;
	}

    @RequestMapping("/api_select")
	public ArrayList<Item> api_select() {
        DB db = new DB();       
		return db.selectQuery();
	}
}

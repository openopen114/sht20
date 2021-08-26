package com.openopen.controller;


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.openopen.model.Person;
import com.openopen.model.SHT20MST01;
import com.openopen.service.PersonService;
import com.openopen.service.SHT20MST01Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SHT20MST01Controller {

    // Logger
    private Logger logger = LoggerFactory.getLogger(SHT20MST01Controller.class);

    @Autowired
    private  SHT20MST01Service sht20mst01Service;



    /*
     *
     * 新增 model by List
     *
     * */
    //http://localhost:8080/api/add/sht20
    @PostMapping(
            value = "/add/sht20",
            produces = {"application/json"})
    @Transactional
    public String insertSht20mst01ByList(@RequestBody String _json) throws ParseException {
        logger.info("===> insertSht20mst01ByList");
        logger.info(_json);
        Gson gson = new Gson();
        List<SHT20MST01> list = gson.fromJson(_json, new TypeToken<List<SHT20MST01>>() {}.getType());

        sht20mst01Service.insertSht20mst01ByList(list);

        JsonObject obj = new JsonObject();
        obj.addProperty("ACTION", "insertSht20mst01ByList");
        obj.addProperty("RESULT", "OK");

        return new Gson().toJson(obj);
    }


}

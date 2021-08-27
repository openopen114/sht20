package com.openopen.service;

import com.openopen.dao.PersonMapper;
import com.openopen.dao.SHT20MST01Mapper;
import com.openopen.model.Person;
import com.openopen.model.SHT20MST01;
import com.openopen.utils.Moment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;


@Service
public class SHT20MST01Service {

    // Logger
    private Logger logger = LoggerFactory.getLogger(SHT20MST01Service.class);

    // Autowired Mapper
    @Autowired
    private SHT20MST01Mapper sht20mst01Mapper;

    //時間工具
    Moment moment= new Moment();


    /*
     *
     * 新增 model by List
     *
     * */
    public void insertSht20mst01ByList(List<SHT20MST01> _datalist) throws ParseException {

        for(SHT20MST01 model : _datalist){
            //塞系統時間 
            model.setDateUpdate(moment.getSysdate());

            //插入數據
            sht20mst01Mapper.insertSelective(model);
        }

    }


    /*
     *
     * 抓最新的一筆資料 selectLastOne
     *
     * */
    public SHT20MST01 selectLastOne(){
        return sht20mst01Mapper.selectLastOne();
    }





}

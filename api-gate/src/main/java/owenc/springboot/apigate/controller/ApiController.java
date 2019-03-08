package owenc.springboot.apigate.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import owenc.springboot.apigate.dao.BaseDao;
import owenc.springboot.apigate.model.bean.H;
import owenc.springboot.apigate.model.bean.ResponseBase;
import owenc.springboot.apigate.model.pojo.SysPara;
import owenc.springboot.apigate.service.IApiService;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api")
public class ApiController {
    @Autowired
    IApiService _api;


    @PostMapping(value = "/getOne")
    public ResponseBase getOne(@RequestBody SysPara para){
        ResponseBase response=new ResponseBase();
        //response.code="1";
        response.result = _api.getInfoById(para.getId());
        response.code="0";
        response.msg = "success";
        return response;
    }

    @GetMapping(value = "/getAll")
    public ResponseBase getAll(){
        ResponseBase response=new ResponseBase();
        response.code="1";
        try {
            response.result = _api.getAllInfo();
            response.code="0";
            response.msg = "success";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;

    }
}

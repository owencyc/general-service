package owenc.springboot.apigate.service.impl;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import owenc.springboot.apigate.config.SystemConfig;
import owenc.springboot.apigate.dao.BaseDao;
import owenc.springboot.apigate.model.pojo.SysPara;
import owenc.springboot.apigate.service.IApiService;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ApiService implements IApiService {
    @Autowired
    BaseDao _dao;
    @Autowired
    SystemConfig _config;
    @Override
    public String getAllInfo() {
        String result="";
        try {
//            Map<String,Object> map=new HashMap(1);
//            map.put("id",1);
            boolean test=_config.isOpen_log();
            List<SysPara> sp=(List<SysPara>)_dao.queryAll(SysPara.class,null);
            result = JSONObject.toJSONString(sp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String getInfoById(int _id) {
        String result="";
        try {
            SysPara sp=(SysPara)_dao.queryOne(SysPara.class,_id);
            result = JSONObject.toJSONString(sp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}

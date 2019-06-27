package com.zs.filecenter.controller;

import com.zs.filecenter.model.TbSkuPicture;
import com.zs.filecenter.utils.SnowflakeIdWorker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "test")
public class TestController {
    private static Logger logger = LoggerFactory.getLogger(TestController.class);

    /**
     * http://localhost:9000/test/nextId.do
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/nextId.do", method = RequestMethod.GET)
    public Object nextId(HttpServletRequest request) {
        List<Map<String, String>> lst = new ArrayList<>();
        try {
            SnowflakeIdWorker idWorker = new SnowflakeIdWorker(0, 0);
            for (int i = 0; i < 20; i++) {
                long id = idWorker.nextId();
                Map<String, String> map = new HashMap<>();
                map.put("ID", String.valueOf(id));
//                map.put("ID-Str", String.valueOf(Long.toBinaryString(id)));
                lst.add(map);
            }
        } catch (Exception e) {
//            try {
//                rltJson.put("Exception", e.getMessage());
//            } catch (JSONException e1) {
//            }
            return lst;
        }
        return lst;
    }

}

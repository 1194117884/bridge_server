package me.kkang.tools.bridge_server.api;

import com.alibaba.fastjson.JSONObject;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/{threadId}")
    public Object transferGet(@PathVariable String threadId, HttpServletRequest request) {
        return request.getQueryString();
    }

    @PostMapping("/{threadId}")
    public Object transferPost(@PathVariable String threadId, HttpServletRequest request) {
        return JSONObject.toJSONString(request);
    }

}
package cn.csbit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by wushifeng on 2016/7/1.
 * 不区分角色的共用的controller功能
 */
@Controller
public class ShareController {
    @RequestMapping(value = "/{path}", method = RequestMethod.GET)
    public String login(@PathVariable("path") String path) {
        return path;
    }
}

package me.jiangyu.april.web.controller.test;

import me.jiangyu.april.core.exception.AjaxException;
import me.jiangyu.april.dto.DtoReturned;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jiangyukun on 15/4/11.
 */
@RestController
@RequestMapping("/rest")
public class MyRestController {
    @RequestMapping("/r1")
    public DtoReturned r1() {
        throw new AjaxException("ajaxException");
    }

    @RequestMapping("/r2")
    public DtoReturned r2() {
        return new DtoReturned();
    }
}
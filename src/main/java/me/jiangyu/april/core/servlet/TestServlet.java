package me.jiangyu.april.core.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by jiangyukun on 2015/3/20.
 */
//@WebServlet(name = "test", urlPatterns = {"/test"}, loadOnStartup = 1)
public class TestServlet extends HttpServlet {
    public TestServlet() {
        System.out.println("init");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("servlet annotation");
    }
}

package com.example.Web03;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/web_reg")
public class web_reg extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        String username = req.getParameter("userName");
        String name = req.getParameter("relname");
        String password = req.getParameter("passWord");
        String repassword = req.getParameter("rePassWord");
        String sex = req.getParameter("sex");
        String birthday = req.getParameter("birthday");
        String email = req.getParameter("email");
        String phone = req.getParameter("mobile");
        String address = req.getParameter("address");

        USER_TABLE user = new USER_TABLE(username,name,password,sex,birthday,null,email,phone,address,1);

        int count= userdatebase.insert(user);

        if(count>0){
            resp.sendRedirect("login.jsp");
        }else{
            PrintWriter writer = resp.getWriter();
            writer.write("<script>");
            writer.write("alert('用户添加失败');");
            writer.write("location.href='reg.jsp';");
            writer.write("</script>");
        }
    }
}

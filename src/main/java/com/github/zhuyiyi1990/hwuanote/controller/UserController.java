package com.github.zhuyiyi1990.hwuanote.controller;

import com.github.zhuyiyi1990.hwuanote.exception.SysException;
import com.github.zhuyiyi1990.hwuanote.pojo.User;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/testReturnString")
    public String testReturnString(Model model) {
        System.out.println("执行testReturnString");
        User user = new User();
        user.setUsername("小明");
        user.setPassword("123456");
        user.setAge(18);
        model.addAttribute("user", user);
        return "success";
    }

    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("执行testVoid");
//        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request, response);
//        response.sendRedirect(request.getContextPath() + "/index.jsp");
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write("json字符串");
        return;
    }

    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        System.out.println("执行testModelAndView");
        ModelAndView mv = new ModelAndView();
        User user = new User();
        user.setUsername("小强");
        user.setPassword("111111");
        user.setAge(18);
        mv.addObject("user", user);
        mv.setViewName("success");
        return mv;
    }

    @RequestMapping("/testForwardOrRedirect")
    public String testForwardOrRedirect() {
        System.out.println("执行testForwardOrRedirect");
//        return "forward:/WEB-INF/pages/success.jsp";
        return "redirect:/user/testModelAndView";
    }

    @RequestMapping("/testResponseBody")
    @ResponseBody
    public User testResponseBody(@RequestBody User user) {
        System.out.println("执行testResponseBody");
        System.out.println(user);
        user.setAge(16);
        return user;
    }

    @RequestMapping("/testFileUpload1")
    public String testFileUpload1(HttpServletRequest request) throws Exception {
        System.out.println("执行testFileUpload1");
        //使用FileUpload组件完成文件上传
        //上传的位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        File file = new File(path);
        if (!file.exists()) {//如果该文件夹不存在,创建文件夹
            file.mkdirs();
        }
        //解析request对象,获取上传文件项
        DiskFileItemFactory factory = new DiskFileItemFactory();//磁盘文件项工厂
        ServletFileUpload upload = new ServletFileUpload(factory);
        //解析request
        List<FileItem> items = upload.parseRequest(request);
        //遍历
        for (FileItem item : items) {
            //判断当前item是否是上传文件项
            if (item.isFormField()) {//说明是普通表单项

            } else {//说明是上传文件项
                //获取上传文件名称
                String fileName = item.getName();
                //把文件的名称设置成唯一值, uuid
                String uuid = UUID.randomUUID().toString().replace("-", "");
                fileName = uuid + "_" + fileName;
                //完成文件上传
                item.write(new File(path, fileName));
                //删除临时文件,当文件大于10kb,就会生成临时文件,否则是内存的缓存数据
                item.delete();
            }
        }
        return "success";
    }

    @RequestMapping("/testFileUpload2")
    public String testFileUpload2(HttpServletRequest request, MultipartFile upload) throws IOException {
        System.out.println("执行testFileUpload2");
        //使用MultipartFile完成文件上传
        //上传的位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        File file = new File(path);
        if (!file.exists()) {//如果该文件夹不存在,创建文件夹
            file.mkdirs();
        }

        //获取上传文件名称
        String fileName = upload.getOriginalFilename();
        //把文件的名称设置成唯一值, uuid
        String uuid = UUID.randomUUID().toString().replace("-", "");
        fileName = uuid + "_" + fileName;
        //完成文件上传
        upload.transferTo(new File(path, fileName));

        return "success";
    }

    @RequestMapping("/testException")
    public String testException() throws SysException {
        System.out.println("执行testException");
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SysException("查询所有用户出现异常...");
        }
        return "success";
    }

    @RequestMapping("/testInterceptor")
    public String testInterceptor() {
        System.out.println("执行testInterceptor");
        return "success";
    }

}

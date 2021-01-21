package ppppp.fileupload;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author lppppp
 * @create 2021-01-21 22:47
 */
@Controller
public class FileUpload {
    @RequestMapping("/upload")
    public String up(@RequestParam(value = "username",required = false)String username,
                     @RequestParam(value = "img",required = false)MultipartFile[] multipartFile,
                     Model model){
        System.out.println(username);
        try {
            for (MultipartFile file : multipartFile) {
                file.transferTo(new File("D:\\MyJava\\5_Spring\\6_SpringMVC\\src\\main\\java\\ppppp\\fileupload\\"+file.getOriginalFilename()));
            }
            model.addAttribute("msg", "文件上传成功鸟！！！");
        } catch (IOException e) {
            model.addAttribute("msg", "文件上传失败鸟！！！"+e.toString());
        }
        return "forward:/upload.jsp";
    }
}

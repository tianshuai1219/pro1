package com.tianshuai.controller;

import com.tianshuai.domain.Items;
import com.tianshuai.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * Created by tianshuai on 2018/9/2.
 */
@Controller
@RequestMapping("/items")
public class ItemsController {

    @Autowired
    private ItemService itemService;

    @RequestMapping("/queryItems")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        List<Items> itemsList = itemService.findAll();
        System.out.println(itemsList);
        mv.addObject("itemsList",itemsList);
        mv.setViewName("itemsList");
        return mv;
    }
    @RequestMapping("/editItems.action")
    public ModelAndView saveItems(@RequestParam(name = "id",required = true) String id){
        ModelAndView mv = new ModelAndView();
        Items items = itemService.findById(id);
        mv.setViewName("editItems");
        mv.addObject("items",items);
        return mv;
    }

    @RequestMapping("/updateItems.action")
    public String update(Items items,HttpServletRequest request, MultipartFile pictureFile,String oldPic){
        String path = request.getSession().getServletContext().getRealPath("/pic/");
        //创建File对象
        File file = new File(path);
        //判断路径是否存在，不存在就创建
        if(!file.exists()){
            file.mkdirs();
        }
        if(oldPic!=null){
           File file1 = new File(path+"/"+oldPic);
           file1.delete();
        }
        //获取文件名
        String filename = pictureFile.getOriginalFilename();
        items.setPic(filename);
        try {
            File file1= new File(path,filename);
            pictureFile.transferTo(file1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        itemService.update(items);
        return "redirect:queryItems";
    }
}

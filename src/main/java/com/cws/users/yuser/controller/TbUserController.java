package com.cws.users.yuser.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import com.cws.users.yuser.entity.TbUser;
import com.cws.users.yuser.mapper.TbUserMapper;
import com.cws.users.yuser.service.ITbUserService;
import org.apache.shiro.codec.Hex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;


//import com.baomidou.ant.common.BaseController;

@RestController
@RequestMapping("/yuser/tb-user")
public class TbUserController {
   /* @Autowired
    ITbUserService userService;
    @Autowired
    TbUserMapper mapper;*/
  ITbUserService userService;
  TbUserMapper mapper;


  @Autowired
    public TbUserController(ITbUserService userService, TbUserMapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }

    @GetMapping
    public List<TbUser> getAll(){
        List<TbUser> list = userService.list();
      /*  list.forEach(tbUser -> {
            String pass;
            pass=tbUser.getPassWd(tbUser.getPasssword());
            tbUser.setPasssword(pass);
        });*/
        System.out.println(list);
        System.out.println(userService);
        return list;
    }
    @PostMapping("/add")
    public TbUser addUesr(@RequestBody TbUser tbUser){
        String name=tbUser.getName();
        String password = tbUser.getPasssword();
        if (name!=null&&password!=null){
            String hexEncoded = Hex.encodeToString(password.getBytes());
            tbUser.setPasssword(hexEncoded);
            userService.save(tbUser);



        }
        return tbUser;
    }

    @ResponseBody
    @PostMapping("/upload")
    public void upload(@RequestParam("file")MultipartFile file) throws IllegalStateException, IOException {

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式  HH:mm:ss
        String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
        String path = "D:/var/uploaded_files/"+date+"/";
        UUID uuid=UUID.randomUUID();
        String originalFilename = file.getOriginalFilename();
        String extendName = originalFilename.substring(originalFilename.lastIndexOf("."), originalFilename.length());
        String fileName = uuid.toString() + extendName;
        File dir = new File(path, fileName);
        File filepath = new File(path);
        if(!filepath.exists()){
            filepath.mkdirs();
        }
        file.transferTo(dir);




    }

}


package cn.webank.daotest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author gradyzhou
 * @version 1.0, on 23:21 2019/12/12.
 */
@Controller
public class AccountController {

    @PostMapping("/accountController")
    @ResponseBody
    private void accountController(){

    }
}

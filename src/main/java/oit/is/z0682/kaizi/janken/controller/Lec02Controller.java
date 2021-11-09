package oit.is.z0682.kaizi.janken.controller;

import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import oit.is.z0682.kaizi.janken.model.Entry;
import oit.is.z0682.kaizi.janken.model.User;
import oit.is.z0682.kaizi.janken.model.UserMapper;

@Controller
public class Lec02Controller {

  @Autowired
  private Entry room;

  @Autowired
  UserMapper uMapper;

  @GetMapping("/lec02")
  public String lec02(Principal prin, ModelMap model) {
    String loginUser = prin.getName();
    this.room.addUser(loginUser);
    model.addAttribute("login_user", loginUser);
    return "lec02.html";
  }

  @GetMapping("/lec02/{param}")
  public String sample22(@PathVariable Integer param, Principal prin, ModelMap model) {
    String loginUser = prin.getName();
    this.room.addUser(loginUser);
    //自分の手
    String hund1 = "error";
    //相手の手
    String hund2 = "相手の手 Gu";
    //結果
    String result = "error";
    //paramの値で分岐させる
    //paramが1でグー, 2でチョキ, 3でパー
    if(param == 1){
      hund1 = "自分の手 Gu";
      result = "結果 あいこ";
    }
    if(param == 2){
      hund1 = "自分の手 Choki";
      result = "結果 負け";
    }
    if(param == 3){
      hund1 = "自分の手 Pa";
      result = "結果 勝ち";
    }
    model.addAttribute("hund1", hund1);
    model.addAttribute("hund2", hund2);
    model.addAttribute("result", result);
    model.addAttribute("login_user", loginUser);
    return "lec02.html";
  }
}

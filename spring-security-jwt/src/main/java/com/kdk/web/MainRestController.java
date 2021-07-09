package com.kdk.web;

import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.kdk.security.SessionUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@Api(value = "MainRestController")
@RequiredArgsConstructor
@Controller
@RequestMapping("/oauth")
public class MainRestController {

  static final Logger logger = LoggerFactory.getLogger(MainRestController.class);

  private final HttpSession httpSession;

  @ApiOperation(value = "로그인 페이지", tags = "OAuth2 로그인")
  @RequestMapping(value = "/login")
  public String loginPage(Model model) {
    SessionUser user = (SessionUser) httpSession.getAttribute("user");

    if (user != null) {
      model.addAttribute("userName", user.getName());
      model.addAttribute("picture", user.getPicture());
    }

    return "thymeleaf/login";
  }

  @ApiOperation(value = "OAuth2 로그아웃", tags = "OAuth2 로그인")
  @RequestMapping(value = "/logout")
  public String logout(Model model) {
    SessionUser user = (SessionUser) httpSession.getAttribute("user");

    if (user != null)
      model.addAttribute("userName", user.getName());

    return "thymeleaf/login";
  }
}

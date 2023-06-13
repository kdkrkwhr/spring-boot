package com.kdk.security;

import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.kdk.util.JwtTokenUtil;
import io.swagger.annotations.ApiOperation;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class JwtAuthenticationController {

  private final JwtTokenUtil jwtTokenUtil;

  private final JwtUserDetailsService userDetailService;

  @CrossOrigin
  @ApiOperation(value = "토큰 정보 조회", tags = "인증 관리")
  @RequestMapping(value = "/api/token", method = RequestMethod.POST)
  public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) {
    Map<String, Object> result = new HashMap<>();

    final UserDetails userDetails =
        userDetailService.loadUserByUsername(authenticationRequest.getEmail());

    result.put("token", jwtTokenUtil.generateToken(userDetails));

    return new ResponseEntity<>(result, HttpStatus.OK);
  }
}

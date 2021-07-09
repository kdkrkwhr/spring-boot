package com.kdk.security;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class JwtResponse implements Serializable {

  private static final long serialVersionUID = -868765630229614668L;

  private final String jwttoken;
}

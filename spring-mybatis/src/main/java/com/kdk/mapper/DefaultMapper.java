package com.kdk.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.kdk.domain.DefaultDto;

@Mapper
public interface DefaultMapper {

  DefaultDto defaultSelect(@Param("parameter") String parameter);

}

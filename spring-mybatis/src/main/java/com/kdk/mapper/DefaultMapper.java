package com.kdk.mapper;

import java.util.HashMap;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.kdk.domain.DefaultDto;

@Mapper
public interface DefaultMapper {

  int defaultInsert(HashMap<String, Object> data);

  DefaultDto defaultSelect(@Param("idx") String idx);

  int defaultUpdate(HashMap<String, Object> data);

  int defaultDelete(@Param("idx") String idx);

}

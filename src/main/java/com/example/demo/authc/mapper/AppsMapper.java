package com.example.demo.authc.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.example.demo.authc.dto.AppsDto;
import com.example.demo.authc.entity.AppsPo;
import com.example.demo.authc.vo.AppsVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface AppsMapper extends BaseMapper<AppsPo> {

    List<AppsVo> selectPage(@Param("page") Page<AppsVo> page, @Param("dto") AppsDto appsDto);
}

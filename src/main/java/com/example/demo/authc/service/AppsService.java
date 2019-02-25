package com.example.demo.authc.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.example.demo.authc.dto.AppsDto;
import com.example.demo.authc.entity.AppsPo;
import com.example.demo.authc.vo.AppsVo;

public interface AppsService extends IService<AppsPo> {

    Page<AppsVo> selectPage(Page<AppsVo> page, AppsDto dto);
}

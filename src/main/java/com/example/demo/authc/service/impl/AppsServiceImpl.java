package com.example.demo.authc.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.demo.authc.dto.AppsDto;
import com.example.demo.authc.entity.AppsPo;
import com.example.demo.authc.mapper.AppsMapper;
import com.example.demo.authc.service.AppsService;
import com.example.demo.authc.vo.AppsVo;
import com.ly.cloud.exception.biz.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
@EnableEurekaClient
public class AppsServiceImpl  extends ServiceImpl<AppsMapper, AppsPo> implements AppsService {

    @Autowired
    private AppsMapper appsMapper;

    public Page<AppsVo> selectPage(Page<AppsVo> page, AppsDto dto) {
        try {
            page.setRecords(appsMapper.selectPage(page, dto));
            return page;
        } catch (Exception e) {
            throw new BusinessException("查询出错！", e);
        }
    }
}

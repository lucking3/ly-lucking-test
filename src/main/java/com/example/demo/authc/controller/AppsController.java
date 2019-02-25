package com.example.demo.authc.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.example.demo.authc.dto.AppsDto;
import com.example.demo.authc.service.AppsService;
import com.example.demo.authc.vo.AppsVo;
import com.ly.cloud.common.mybatisplus.plugins.PageInfo;
import com.ly.cloud.web.utils.WebResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "应用Controller", tags = {"应用操作接口"})
public class AppsController {

    private final static Log logger = LogFactory.getLog(AppsController.class);

    @Autowired
    private AppsService appsService;

    /**
     * 分页查询应用列表
     * @param pageNum, pageSize, dto
     * @return com.ly.cloud.web.utils.WebResponse<com.baomidou.mybatisplus.plugins.Page < com.ly.cloud.authc.vo.AppsVo>>
     */
    @ApiOperation(value = "分页查询应用列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "pageNum", dataType = "int", required = true, value = "当前页码", defaultValue = "1"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", dataType = "int", required = true, value = "每页条数", defaultValue = "5"),
    })
    @RequestMapping(value = "/apps", method = RequestMethod.GET)
    public WebResponse<PageInfo<AppsVo>> queryPage(@RequestParam int pageNum, @RequestParam int pageSize, @ModelAttribute AppsDto dto) {
        try {
            Page<AppsVo> page = appsService.selectPage(new Page<AppsVo>(pageNum, pageSize), dto);
            return new WebResponse<PageInfo<AppsVo>>().success(PageInfo.toPageInfo(page));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new WebResponse<PageInfo<AppsVo>>().failure(e.getMessage());
        }
    }
}

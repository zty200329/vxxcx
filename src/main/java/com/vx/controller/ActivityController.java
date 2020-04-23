package com.vx.controller;

import com.vx.form.*;
import com.vx.service.ActivityService;
import com.vx.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

/**
 * @author zty
 * @date 2020/4/16 下午2:03
 * @description:
 */
@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/activity")
@Api(tags = "活动接口")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @PostMapping("/addPicture")
    @ApiOperation("图片")
    public ResultVO addPicture(MultipartFile file){
        return activityService.addPicture(file);
    }

    @PostMapping("/addActivity")
    @ApiOperation("创建一个大活动的主体")
    public ResultVO addActivity(@Valid ActivityForm activityForm,  BindingResult bindingResult){
        return activityService.addActivity(activityForm,bindingResult);
    }

    @PostMapping("/addSonActivity")
    @ApiOperation("创建一个大活动的下的排队项目")
    public ResultVO addSonActivity(@Valid @RequestBody List<SonActivityForm> sonactivityforms, BindingResult bindingresult){
        return activityService.addSonActivity(sonactivityforms,bindingresult);
    }

    @PostMapping("/joinSonActivity")
    @ApiOperation("开始排队")
    public ResultVO joinSonActivity(@Valid JoinSonActivityForm joinSonActivityForm, BindingResult bindingresult){
        return activityService.joinSonActivity(joinSonActivityForm,bindingresult);
    }

    @PostMapping("/callNumber")
    @ApiOperation("叫号")
    public ResultVO callNumber(@Valid CallNumberForm callNumberForm,BindingResult bindingResult){
        return activityService.callNumber(callNumberForm,bindingResult);
    }

    @PostMapping("/selectByDistance")
    @ApiOperation("获取店家列表")
    public ResultVO selectByDistance(ActivityDistanceForm activityDistanceForm,BindingResult bindingResult){
        return activityService.selectByDistance(activityDistanceForm,bindingResult);
    }

    @PostMapping("/getSonActivityById")
    @ApiOperation("获取主体活动下的子排队")
    public ResultVO selectSonActivity(@RequestParam("id") Long id){
        return activityService.selectByActivityId(id);
    }
}

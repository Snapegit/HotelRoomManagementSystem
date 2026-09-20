package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.FangjianleixingEntity;
import com.entity.view.FangjianleixingView;

import com.service.FangjianleixingService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;

/**
 * 房间类型 
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-26 16:26:23
 */
@RestController
@RequestMapping("/fangjianleixing")
public class FangjianleixingController {
    @Autowired
    private FangjianleixingService fangjianleixingService;





    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,FangjianleixingEntity fangjianleixing, 
		HttpServletRequest request){

        EntityWrapper<FangjianleixingEntity> ew = new EntityWrapper<FangjianleixingEntity>();


		PageUtils page = fangjianleixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fangjianleixing), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,FangjianleixingEntity fangjianleixing, 
		HttpServletRequest request){
        EntityWrapper<FangjianleixingEntity> ew = new EntityWrapper<FangjianleixingEntity>();

		PageUtils page = fangjianleixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fangjianleixing), params), params));
        return R.ok().put("data", page);
    }


	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( FangjianleixingEntity fangjianleixing){
       	EntityWrapper<FangjianleixingEntity> ew = new EntityWrapper<FangjianleixingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( fangjianleixing, "fangjianleixing")); 
        return R.ok().put("data", fangjianleixingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(FangjianleixingEntity fangjianleixing){
        EntityWrapper< FangjianleixingEntity> ew = new EntityWrapper< FangjianleixingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( fangjianleixing, "fangjianleixing")); 
		FangjianleixingView fangjianleixingView =  fangjianleixingService.selectView(ew);
		return R.ok("查询房间类型成功").put("data", fangjianleixingView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        FangjianleixingEntity fangjianleixing = fangjianleixingService.selectById(id);
        fangjianleixing = fangjianleixingService.selectView(new EntityWrapper<FangjianleixingEntity>().eq("id", id));
        return R.ok().put("data", fangjianleixing);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        FangjianleixingEntity fangjianleixing = fangjianleixingService.selectById(id);
        fangjianleixing = fangjianleixingService.selectView(new EntityWrapper<FangjianleixingEntity>().eq("id", id));
        return R.ok().put("data", fangjianleixing);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody FangjianleixingEntity fangjianleixing, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(fangjianleixing);

        fangjianleixingService.insert(fangjianleixing);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody FangjianleixingEntity fangjianleixing, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(fangjianleixing);

        fangjianleixingService.insert(fangjianleixing);
        return R.ok();
    }




    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody FangjianleixingEntity fangjianleixing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(fangjianleixing);
        fangjianleixingService.updateById(fangjianleixing);//全部更新
        return R.ok();
    }

    
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        fangjianleixingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}

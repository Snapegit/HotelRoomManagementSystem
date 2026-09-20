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

import com.entity.FangjianxudingEntity;
import com.entity.view.FangjianxudingView;

import com.service.FangjianxudingService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;

/**
 * 房间续订 
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-26 16:26:23
 */
@RestController
@RequestMapping("/fangjianxuding")
public class FangjianxudingController {
    @Autowired
    private FangjianxudingService fangjianxudingService;





    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,FangjianxudingEntity fangjianxuding, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			fangjianxuding.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<FangjianxudingEntity> ew = new EntityWrapper<FangjianxudingEntity>();


		PageUtils page = fangjianxudingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fangjianxuding), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,FangjianxudingEntity fangjianxuding, 
		HttpServletRequest request){
        EntityWrapper<FangjianxudingEntity> ew = new EntityWrapper<FangjianxudingEntity>();

		PageUtils page = fangjianxudingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fangjianxuding), params), params));
        return R.ok().put("data", page);
    }


	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( FangjianxudingEntity fangjianxuding){
       	EntityWrapper<FangjianxudingEntity> ew = new EntityWrapper<FangjianxudingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( fangjianxuding, "fangjianxuding")); 
        return R.ok().put("data", fangjianxudingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(FangjianxudingEntity fangjianxuding){
        EntityWrapper< FangjianxudingEntity> ew = new EntityWrapper< FangjianxudingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( fangjianxuding, "fangjianxuding")); 
		FangjianxudingView fangjianxudingView =  fangjianxudingService.selectView(ew);
		return R.ok("查询房间续订成功").put("data", fangjianxudingView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        FangjianxudingEntity fangjianxuding = fangjianxudingService.selectById(id);
        fangjianxuding = fangjianxudingService.selectView(new EntityWrapper<FangjianxudingEntity>().eq("id", id));
        return R.ok().put("data", fangjianxuding);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        FangjianxudingEntity fangjianxuding = fangjianxudingService.selectById(id);
        fangjianxuding = fangjianxudingService.selectView(new EntityWrapper<FangjianxudingEntity>().eq("id", id));
        return R.ok().put("data", fangjianxuding);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody FangjianxudingEntity fangjianxuding, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(fangjianxuding);

        fangjianxudingService.insert(fangjianxuding);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody FangjianxudingEntity fangjianxuding, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(fangjianxuding);

        fangjianxudingService.insert(fangjianxuding);
        return R.ok();
    }




    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody FangjianxudingEntity fangjianxuding, HttpServletRequest request){
        //ValidatorUtils.validateEntity(fangjianxuding);
        fangjianxudingService.updateById(fangjianxuding);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<FangjianxudingEntity> list = new ArrayList<FangjianxudingEntity>();
        for(Long id : ids) {
            FangjianxudingEntity fangjianxuding = fangjianxudingService.selectById(id);
            fangjianxuding.setSfsh(sfsh);
            fangjianxuding.setShhf(shhf);
            list.add(fangjianxuding);
        }
        fangjianxudingService.updateBatchById(list);
        return R.ok();
    }
    
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        fangjianxudingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}

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

import com.entity.FangjianyuyueEntity;
import com.entity.view.FangjianyuyueView;

import com.service.FangjianyuyueService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;

/**
 * 房间预约 
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-26 16:26:23
 */
@RestController
@RequestMapping("/fangjianyuyue")
public class FangjianyuyueController {
    @Autowired
    private FangjianyuyueService fangjianyuyueService;





    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,FangjianyuyueEntity fangjianyuyue, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			fangjianyuyue.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<FangjianyuyueEntity> ew = new EntityWrapper<FangjianyuyueEntity>();


		PageUtils page = fangjianyuyueService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fangjianyuyue), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,FangjianyuyueEntity fangjianyuyue, 
		HttpServletRequest request){
        EntityWrapper<FangjianyuyueEntity> ew = new EntityWrapper<FangjianyuyueEntity>();

		PageUtils page = fangjianyuyueService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fangjianyuyue), params), params));
        return R.ok().put("data", page);
    }


	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( FangjianyuyueEntity fangjianyuyue){
       	EntityWrapper<FangjianyuyueEntity> ew = new EntityWrapper<FangjianyuyueEntity>();
      	ew.allEq(MPUtil.allEQMapPre( fangjianyuyue, "fangjianyuyue")); 
        return R.ok().put("data", fangjianyuyueService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(FangjianyuyueEntity fangjianyuyue){
        EntityWrapper< FangjianyuyueEntity> ew = new EntityWrapper< FangjianyuyueEntity>();
 		ew.allEq(MPUtil.allEQMapPre( fangjianyuyue, "fangjianyuyue")); 
		FangjianyuyueView fangjianyuyueView =  fangjianyuyueService.selectView(ew);
		return R.ok("查询房间预约成功").put("data", fangjianyuyueView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        FangjianyuyueEntity fangjianyuyue = fangjianyuyueService.selectById(id);
        fangjianyuyue = fangjianyuyueService.selectView(new EntityWrapper<FangjianyuyueEntity>().eq("id", id));
        return R.ok().put("data", fangjianyuyue);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        FangjianyuyueEntity fangjianyuyue = fangjianyuyueService.selectById(id);
        fangjianyuyue = fangjianyuyueService.selectView(new EntityWrapper<FangjianyuyueEntity>().eq("id", id));
        return R.ok().put("data", fangjianyuyue);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody FangjianyuyueEntity fangjianyuyue, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(fangjianyuyue);

        fangjianyuyueService.insert(fangjianyuyue);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody FangjianyuyueEntity fangjianyuyue, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(fangjianyuyue);

        fangjianyuyueService.insert(fangjianyuyue);
        return R.ok();
    }




    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody FangjianyuyueEntity fangjianyuyue, HttpServletRequest request){
        //ValidatorUtils.validateEntity(fangjianyuyue);
        fangjianyuyueService.updateById(fangjianyuyue);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<FangjianyuyueEntity> list = new ArrayList<FangjianyuyueEntity>();
        for(Long id : ids) {
            FangjianyuyueEntity fangjianyuyue = fangjianyuyueService.selectById(id);
            fangjianyuyue.setSfsh(sfsh);
            fangjianyuyue.setShhf(shhf);
            list.add(fangjianyuyue);
        }
        fangjianyuyueService.updateBatchById(list);
        return R.ok();
    }
    
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        fangjianyuyueService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}

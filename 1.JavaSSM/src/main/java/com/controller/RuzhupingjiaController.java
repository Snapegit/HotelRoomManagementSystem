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

import com.entity.RuzhupingjiaEntity;
import com.entity.view.RuzhupingjiaView;

import com.service.RuzhupingjiaService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;

/**
 * 入住评价 
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-26 16:26:23
 */
@RestController
@RequestMapping("/ruzhupingjia")
public class RuzhupingjiaController {
    @Autowired
    private RuzhupingjiaService ruzhupingjiaService;





    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,RuzhupingjiaEntity ruzhupingjia, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			ruzhupingjia.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<RuzhupingjiaEntity> ew = new EntityWrapper<RuzhupingjiaEntity>();


		PageUtils page = ruzhupingjiaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, ruzhupingjia), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,RuzhupingjiaEntity ruzhupingjia, 
		HttpServletRequest request){
        EntityWrapper<RuzhupingjiaEntity> ew = new EntityWrapper<RuzhupingjiaEntity>();

		PageUtils page = ruzhupingjiaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, ruzhupingjia), params), params));
        return R.ok().put("data", page);
    }


	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( RuzhupingjiaEntity ruzhupingjia){
       	EntityWrapper<RuzhupingjiaEntity> ew = new EntityWrapper<RuzhupingjiaEntity>();
      	ew.allEq(MPUtil.allEQMapPre( ruzhupingjia, "ruzhupingjia")); 
        return R.ok().put("data", ruzhupingjiaService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(RuzhupingjiaEntity ruzhupingjia){
        EntityWrapper< RuzhupingjiaEntity> ew = new EntityWrapper< RuzhupingjiaEntity>();
 		ew.allEq(MPUtil.allEQMapPre( ruzhupingjia, "ruzhupingjia")); 
		RuzhupingjiaView ruzhupingjiaView =  ruzhupingjiaService.selectView(ew);
		return R.ok("查询入住评价成功").put("data", ruzhupingjiaView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        RuzhupingjiaEntity ruzhupingjia = ruzhupingjiaService.selectById(id);
        ruzhupingjia = ruzhupingjiaService.selectView(new EntityWrapper<RuzhupingjiaEntity>().eq("id", id));
        return R.ok().put("data", ruzhupingjia);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        RuzhupingjiaEntity ruzhupingjia = ruzhupingjiaService.selectById(id);
        ruzhupingjia = ruzhupingjiaService.selectView(new EntityWrapper<RuzhupingjiaEntity>().eq("id", id));
        return R.ok().put("data", ruzhupingjia);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody RuzhupingjiaEntity ruzhupingjia, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(ruzhupingjia);

        ruzhupingjiaService.insert(ruzhupingjia);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody RuzhupingjiaEntity ruzhupingjia, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(ruzhupingjia);

        ruzhupingjiaService.insert(ruzhupingjia);
        return R.ok();
    }




    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody RuzhupingjiaEntity ruzhupingjia, HttpServletRequest request){
        //ValidatorUtils.validateEntity(ruzhupingjia);
        ruzhupingjiaService.updateById(ruzhupingjia);//全部更新
        return R.ok();
    }

    
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        ruzhupingjiaService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}

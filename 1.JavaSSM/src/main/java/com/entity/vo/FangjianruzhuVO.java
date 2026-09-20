package com.entity.vo;

import com.entity.FangjianruzhuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
 

/**
 * 房间入住
 * @author 
 * @email 
 * @date 2024-04-26 16:26:23
 */
public class FangjianruzhuVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 房间名称
	 */
	
	private String fangjianmingcheng;
		
	/**
	 * 图片
	 */
	
	private String tupian;
		
	/**
	 * 一晚价格
	 */
	
	private Integer yiwanjiage;
		
	/**
	 * 入住日期
	 */
	
	private String ruzhuriqi;
		
	/**
	 * 房间数量
	 */
	
	private String fangjianshuliang;
		
	/**
	 * 入住时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date ruzhushijian;
		
	/**
	 * 入住状态
	 */
	
	private String ruzhuzhuangtai;
		
	/**
	 * 用户账号
	 */
	
	private String yonghuzhanghao;
		
	/**
	 * 用户姓名
	 */
	
	private String yonghuxingming;
		
	/**
	 * 手机号码
	 */
	
	private String shoujihaoma;
				
	
	/**
	 * 设置：房间名称
	 */
	 
	public void setFangjianmingcheng(String fangjianmingcheng) {
		this.fangjianmingcheng = fangjianmingcheng;
	}
	
	/**
	 * 获取：房间名称
	 */
	public String getFangjianmingcheng() {
		return fangjianmingcheng;
	}
				
	
	/**
	 * 设置：图片
	 */
	 
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
	}
				
	
	/**
	 * 设置：一晚价格
	 */
	 
	public void setYiwanjiage(Integer yiwanjiage) {
		this.yiwanjiage = yiwanjiage;
	}
	
	/**
	 * 获取：一晚价格
	 */
	public Integer getYiwanjiage() {
		return yiwanjiage;
	}
				
	
	/**
	 * 设置：入住日期
	 */
	 
	public void setRuzhuriqi(String ruzhuriqi) {
		this.ruzhuriqi = ruzhuriqi;
	}
	
	/**
	 * 获取：入住日期
	 */
	public String getRuzhuriqi() {
		return ruzhuriqi;
	}
				
	
	/**
	 * 设置：房间数量
	 */
	 
	public void setFangjianshuliang(String fangjianshuliang) {
		this.fangjianshuliang = fangjianshuliang;
	}
	
	/**
	 * 获取：房间数量
	 */
	public String getFangjianshuliang() {
		return fangjianshuliang;
	}
				
	
	/**
	 * 设置：入住时间
	 */
	 
	public void setRuzhushijian(Date ruzhushijian) {
		this.ruzhushijian = ruzhushijian;
	}
	
	/**
	 * 获取：入住时间
	 */
	public Date getRuzhushijian() {
		return ruzhushijian;
	}
				
	
	/**
	 * 设置：入住状态
	 */
	 
	public void setRuzhuzhuangtai(String ruzhuzhuangtai) {
		this.ruzhuzhuangtai = ruzhuzhuangtai;
	}
	
	/**
	 * 获取：入住状态
	 */
	public String getRuzhuzhuangtai() {
		return ruzhuzhuangtai;
	}
				
	
	/**
	 * 设置：用户账号
	 */
	 
	public void setYonghuzhanghao(String yonghuzhanghao) {
		this.yonghuzhanghao = yonghuzhanghao;
	}
	
	/**
	 * 获取：用户账号
	 */
	public String getYonghuzhanghao() {
		return yonghuzhanghao;
	}
				
	
	/**
	 * 设置：用户姓名
	 */
	 
	public void setYonghuxingming(String yonghuxingming) {
		this.yonghuxingming = yonghuxingming;
	}
	
	/**
	 * 获取：用户姓名
	 */
	public String getYonghuxingming() {
		return yonghuxingming;
	}
				
	
	/**
	 * 设置：手机号码
	 */
	 
	public void setShoujihaoma(String shoujihaoma) {
		this.shoujihaoma = shoujihaoma;
	}
	
	/**
	 * 获取：手机号码
	 */
	public String getShoujihaoma() {
		return shoujihaoma;
	}
			
}

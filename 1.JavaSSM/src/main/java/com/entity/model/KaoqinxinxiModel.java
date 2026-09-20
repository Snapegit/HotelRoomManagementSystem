package com.entity.model;

import com.entity.KaoqinxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
 

/**
 * 考勤信息
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2024-04-26 16:26:24
 */
public class KaoqinxinxiModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 员工姓名
	 */
	
	private String yuangongxingming;
		
	/**
	 * 出勤天数
	 */
	
	private Integer chuqintianshu;
		
	/**
	 * 请假天数
	 */
	
	private Integer qingjiatianshu;
		
	/**
	 * 迟到次数
	 */
	
	private Integer chidaocishu;
		
	/**
	 * 早退次数
	 */
	
	private Integer zaotuicishu;
		
	/**
	 * 缺勤天数
	 */
	
	private Integer queqintianshu;
		
	/**
	 * 登记时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date dengjishijian;
		
	/**
	 * 月份
	 */
	
	private String yuefen;
		
	/**
	 * 用户id
	 */
	
	private Long userid;
				
	
	/**
	 * 设置：员工姓名
	 */
	 
	public void setYuangongxingming(String yuangongxingming) {
		this.yuangongxingming = yuangongxingming;
	}
	
	/**
	 * 获取：员工姓名
	 */
	public String getYuangongxingming() {
		return yuangongxingming;
	}
				
	
	/**
	 * 设置：出勤天数
	 */
	 
	public void setChuqintianshu(Integer chuqintianshu) {
		this.chuqintianshu = chuqintianshu;
	}
	
	/**
	 * 获取：出勤天数
	 */
	public Integer getChuqintianshu() {
		return chuqintianshu;
	}
				
	
	/**
	 * 设置：请假天数
	 */
	 
	public void setQingjiatianshu(Integer qingjiatianshu) {
		this.qingjiatianshu = qingjiatianshu;
	}
	
	/**
	 * 获取：请假天数
	 */
	public Integer getQingjiatianshu() {
		return qingjiatianshu;
	}
				
	
	/**
	 * 设置：迟到次数
	 */
	 
	public void setChidaocishu(Integer chidaocishu) {
		this.chidaocishu = chidaocishu;
	}
	
	/**
	 * 获取：迟到次数
	 */
	public Integer getChidaocishu() {
		return chidaocishu;
	}
				
	
	/**
	 * 设置：早退次数
	 */
	 
	public void setZaotuicishu(Integer zaotuicishu) {
		this.zaotuicishu = zaotuicishu;
	}
	
	/**
	 * 获取：早退次数
	 */
	public Integer getZaotuicishu() {
		return zaotuicishu;
	}
				
	
	/**
	 * 设置：缺勤天数
	 */
	 
	public void setQueqintianshu(Integer queqintianshu) {
		this.queqintianshu = queqintianshu;
	}
	
	/**
	 * 获取：缺勤天数
	 */
	public Integer getQueqintianshu() {
		return queqintianshu;
	}
				
	
	/**
	 * 设置：登记时间
	 */
	 
	public void setDengjishijian(Date dengjishijian) {
		this.dengjishijian = dengjishijian;
	}
	
	/**
	 * 获取：登记时间
	 */
	public Date getDengjishijian() {
		return dengjishijian;
	}
				
	
	/**
	 * 设置：月份
	 */
	 
	public void setYuefen(String yuefen) {
		this.yuefen = yuefen;
	}
	
	/**
	 * 获取：月份
	 */
	public String getYuefen() {
		return yuefen;
	}
				
	
	/**
	 * 设置：用户id
	 */
	 
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	
	/**
	 * 获取：用户id
	 */
	public Long getUserid() {
		return userid;
	}
			
}

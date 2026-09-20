package com.dao;

import com.entity.RuzhupingjiaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.RuzhupingjiaVO;
import com.entity.view.RuzhupingjiaView;


/**
 * 入住评价
 * 
 * @author 
 * @email 
 * @date 2024-04-26 16:26:23
 */
public interface RuzhupingjiaDao extends BaseMapper<RuzhupingjiaEntity> {
	
	List<RuzhupingjiaVO> selectListVO(@Param("ew") Wrapper<RuzhupingjiaEntity> wrapper);
	
	RuzhupingjiaVO selectVO(@Param("ew") Wrapper<RuzhupingjiaEntity> wrapper);
	
	List<RuzhupingjiaView> selectListView(@Param("ew") Wrapper<RuzhupingjiaEntity> wrapper);

	List<RuzhupingjiaView> selectListView(Pagination page,@Param("ew") Wrapper<RuzhupingjiaEntity> wrapper);

	
	RuzhupingjiaView selectView(@Param("ew") Wrapper<RuzhupingjiaEntity> wrapper);
	

}

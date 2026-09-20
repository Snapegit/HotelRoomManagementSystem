package com.dao;

import com.entity.FangjianxudingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.FangjianxudingVO;
import com.entity.view.FangjianxudingView;


/**
 * 房间续订
 * 
 * @author 
 * @email 
 * @date 2024-04-26 16:26:23
 */
public interface FangjianxudingDao extends BaseMapper<FangjianxudingEntity> {
	
	List<FangjianxudingVO> selectListVO(@Param("ew") Wrapper<FangjianxudingEntity> wrapper);
	
	FangjianxudingVO selectVO(@Param("ew") Wrapper<FangjianxudingEntity> wrapper);
	
	List<FangjianxudingView> selectListView(@Param("ew") Wrapper<FangjianxudingEntity> wrapper);

	List<FangjianxudingView> selectListView(Pagination page,@Param("ew") Wrapper<FangjianxudingEntity> wrapper);

	
	FangjianxudingView selectView(@Param("ew") Wrapper<FangjianxudingEntity> wrapper);
	

}

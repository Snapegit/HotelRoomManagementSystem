package com.dao;

import com.entity.FangjianruzhuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.FangjianruzhuVO;
import com.entity.view.FangjianruzhuView;


/**
 * 房间入住
 * 
 * @author 
 * @email 
 * @date 2024-04-26 16:26:23
 */
public interface FangjianruzhuDao extends BaseMapper<FangjianruzhuEntity> {
	
	List<FangjianruzhuVO> selectListVO(@Param("ew") Wrapper<FangjianruzhuEntity> wrapper);
	
	FangjianruzhuVO selectVO(@Param("ew") Wrapper<FangjianruzhuEntity> wrapper);
	
	List<FangjianruzhuView> selectListView(@Param("ew") Wrapper<FangjianruzhuEntity> wrapper);

	List<FangjianruzhuView> selectListView(Pagination page,@Param("ew") Wrapper<FangjianruzhuEntity> wrapper);

	
	FangjianruzhuView selectView(@Param("ew") Wrapper<FangjianruzhuEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params")Map<String, Object> params,@Param("ew") Wrapper<FangjianruzhuEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<FangjianruzhuEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<FangjianruzhuEntity> wrapper);



}

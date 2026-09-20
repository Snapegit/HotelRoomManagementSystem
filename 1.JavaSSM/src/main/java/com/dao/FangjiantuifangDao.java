package com.dao;

import com.entity.FangjiantuifangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.FangjiantuifangVO;
import com.entity.view.FangjiantuifangView;


/**
 * 房间退房
 * 
 * @author 
 * @email 
 * @date 2024-04-26 16:26:23
 */
public interface FangjiantuifangDao extends BaseMapper<FangjiantuifangEntity> {
	
	List<FangjiantuifangVO> selectListVO(@Param("ew") Wrapper<FangjiantuifangEntity> wrapper);
	
	FangjiantuifangVO selectVO(@Param("ew") Wrapper<FangjiantuifangEntity> wrapper);
	
	List<FangjiantuifangView> selectListView(@Param("ew") Wrapper<FangjiantuifangEntity> wrapper);

	List<FangjiantuifangView> selectListView(Pagination page,@Param("ew") Wrapper<FangjiantuifangEntity> wrapper);

	
	FangjiantuifangView selectView(@Param("ew") Wrapper<FangjiantuifangEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params")Map<String, Object> params,@Param("ew") Wrapper<FangjiantuifangEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<FangjiantuifangEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<FangjiantuifangEntity> wrapper);



}

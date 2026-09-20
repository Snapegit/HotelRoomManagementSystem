package com.dao;

import com.entity.FangjianyuyueEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.FangjianyuyueVO;
import com.entity.view.FangjianyuyueView;


/**
 * 房间预约
 * 
 * @author 
 * @email 
 * @date 2024-04-26 16:26:23
 */
public interface FangjianyuyueDao extends BaseMapper<FangjianyuyueEntity> {
	
	List<FangjianyuyueVO> selectListVO(@Param("ew") Wrapper<FangjianyuyueEntity> wrapper);
	
	FangjianyuyueVO selectVO(@Param("ew") Wrapper<FangjianyuyueEntity> wrapper);
	
	List<FangjianyuyueView> selectListView(@Param("ew") Wrapper<FangjianyuyueEntity> wrapper);

	List<FangjianyuyueView> selectListView(Pagination page,@Param("ew") Wrapper<FangjianyuyueEntity> wrapper);

	
	FangjianyuyueView selectView(@Param("ew") Wrapper<FangjianyuyueEntity> wrapper);
	

}

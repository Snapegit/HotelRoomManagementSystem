package com.dao;

import com.entity.DiscussnewsEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussnewsVO;
import com.entity.view.DiscussnewsView;


/**
 * 酒店资讯评论表
 * 
 * @author 
 * @email 
 * @date 2024-04-26 16:26:24
 */
public interface DiscussnewsDao extends BaseMapper<DiscussnewsEntity> {
	
	List<DiscussnewsVO> selectListVO(@Param("ew") Wrapper<DiscussnewsEntity> wrapper);
	
	DiscussnewsVO selectVO(@Param("ew") Wrapper<DiscussnewsEntity> wrapper);
	
	List<DiscussnewsView> selectListView(@Param("ew") Wrapper<DiscussnewsEntity> wrapper);

	List<DiscussnewsView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussnewsEntity> wrapper);

	
	DiscussnewsView selectView(@Param("ew") Wrapper<DiscussnewsEntity> wrapper);
	

}

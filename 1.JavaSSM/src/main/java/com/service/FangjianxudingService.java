package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.FangjianxudingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.FangjianxudingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.FangjianxudingView;


/**
 * 房间续订
 *
 * @author 
 * @email 
 * @date 2024-04-26 16:26:23
 */
public interface FangjianxudingService extends IService<FangjianxudingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<FangjianxudingVO> selectListVO(Wrapper<FangjianxudingEntity> wrapper);
   	
   	FangjianxudingVO selectVO(@Param("ew") Wrapper<FangjianxudingEntity> wrapper);
   	
   	List<FangjianxudingView> selectListView(Wrapper<FangjianxudingEntity> wrapper);
   	
   	FangjianxudingView selectView(@Param("ew") Wrapper<FangjianxudingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<FangjianxudingEntity> wrapper);

   	

}


package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.FangjianruzhuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.FangjianruzhuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.FangjianruzhuView;


/**
 * 房间入住
 *
 * @author 
 * @email 
 * @date 2024-04-26 16:26:23
 */
public interface FangjianruzhuService extends IService<FangjianruzhuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<FangjianruzhuVO> selectListVO(Wrapper<FangjianruzhuEntity> wrapper);
   	
   	FangjianruzhuVO selectVO(@Param("ew") Wrapper<FangjianruzhuEntity> wrapper);
   	
   	List<FangjianruzhuView> selectListView(Wrapper<FangjianruzhuEntity> wrapper);
   	
   	FangjianruzhuView selectView(@Param("ew") Wrapper<FangjianruzhuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<FangjianruzhuEntity> wrapper);

   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<FangjianruzhuEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<FangjianruzhuEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<FangjianruzhuEntity> wrapper);



}


package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.FangjiantuifangEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.FangjiantuifangVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.FangjiantuifangView;


/**
 * 房间退房
 *
 * @author 
 * @email 
 * @date 2024-04-26 16:26:23
 */
public interface FangjiantuifangService extends IService<FangjiantuifangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<FangjiantuifangVO> selectListVO(Wrapper<FangjiantuifangEntity> wrapper);
   	
   	FangjiantuifangVO selectVO(@Param("ew") Wrapper<FangjiantuifangEntity> wrapper);
   	
   	List<FangjiantuifangView> selectListView(Wrapper<FangjiantuifangEntity> wrapper);
   	
   	FangjiantuifangView selectView(@Param("ew") Wrapper<FangjiantuifangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<FangjiantuifangEntity> wrapper);

   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<FangjiantuifangEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<FangjiantuifangEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<FangjiantuifangEntity> wrapper);



}


package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.FangjianyuyueEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.FangjianyuyueVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.FangjianyuyueView;


/**
 * 房间预约
 *
 * @author 
 * @email 
 * @date 2024-04-26 16:26:23
 */
public interface FangjianyuyueService extends IService<FangjianyuyueEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<FangjianyuyueVO> selectListVO(Wrapper<FangjianyuyueEntity> wrapper);
   	
   	FangjianyuyueVO selectVO(@Param("ew") Wrapper<FangjianyuyueEntity> wrapper);
   	
   	List<FangjianyuyueView> selectListView(Wrapper<FangjianyuyueEntity> wrapper);
   	
   	FangjianyuyueView selectView(@Param("ew") Wrapper<FangjianyuyueEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<FangjianyuyueEntity> wrapper);

   	

}


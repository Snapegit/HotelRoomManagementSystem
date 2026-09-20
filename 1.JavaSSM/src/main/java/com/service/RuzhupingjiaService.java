package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.RuzhupingjiaEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.RuzhupingjiaVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.RuzhupingjiaView;


/**
 * 入住评价
 *
 * @author 
 * @email 
 * @date 2024-04-26 16:26:23
 */
public interface RuzhupingjiaService extends IService<RuzhupingjiaEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<RuzhupingjiaVO> selectListVO(Wrapper<RuzhupingjiaEntity> wrapper);
   	
   	RuzhupingjiaVO selectVO(@Param("ew") Wrapper<RuzhupingjiaEntity> wrapper);
   	
   	List<RuzhupingjiaView> selectListView(Wrapper<RuzhupingjiaEntity> wrapper);
   	
   	RuzhupingjiaView selectView(@Param("ew") Wrapper<RuzhupingjiaEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<RuzhupingjiaEntity> wrapper);

   	

}


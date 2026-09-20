package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.RuzhupingjiaDao;
import com.entity.RuzhupingjiaEntity;
import com.service.RuzhupingjiaService;
import com.entity.vo.RuzhupingjiaVO;
import com.entity.view.RuzhupingjiaView;

@Service("ruzhupingjiaService")
public class RuzhupingjiaServiceImpl extends ServiceImpl<RuzhupingjiaDao, RuzhupingjiaEntity> implements RuzhupingjiaService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<RuzhupingjiaEntity> page = this.selectPage(
                new Query<RuzhupingjiaEntity>(params).getPage(),
                new EntityWrapper<RuzhupingjiaEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<RuzhupingjiaEntity> wrapper) {
		  Page<RuzhupingjiaView> page =new Query<RuzhupingjiaView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<RuzhupingjiaVO> selectListVO(Wrapper<RuzhupingjiaEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public RuzhupingjiaVO selectVO(Wrapper<RuzhupingjiaEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<RuzhupingjiaView> selectListView(Wrapper<RuzhupingjiaEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public RuzhupingjiaView selectView(Wrapper<RuzhupingjiaEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

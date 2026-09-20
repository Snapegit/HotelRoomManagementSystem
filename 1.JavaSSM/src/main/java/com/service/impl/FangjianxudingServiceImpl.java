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


import com.dao.FangjianxudingDao;
import com.entity.FangjianxudingEntity;
import com.service.FangjianxudingService;
import com.entity.vo.FangjianxudingVO;
import com.entity.view.FangjianxudingView;

@Service("fangjianxudingService")
public class FangjianxudingServiceImpl extends ServiceImpl<FangjianxudingDao, FangjianxudingEntity> implements FangjianxudingService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FangjianxudingEntity> page = this.selectPage(
                new Query<FangjianxudingEntity>(params).getPage(),
                new EntityWrapper<FangjianxudingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<FangjianxudingEntity> wrapper) {
		  Page<FangjianxudingView> page =new Query<FangjianxudingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<FangjianxudingVO> selectListVO(Wrapper<FangjianxudingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public FangjianxudingVO selectVO(Wrapper<FangjianxudingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<FangjianxudingView> selectListView(Wrapper<FangjianxudingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public FangjianxudingView selectView(Wrapper<FangjianxudingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

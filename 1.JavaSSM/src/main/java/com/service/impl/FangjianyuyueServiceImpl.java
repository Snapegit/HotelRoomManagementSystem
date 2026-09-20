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


import com.dao.FangjianyuyueDao;
import com.entity.FangjianyuyueEntity;
import com.service.FangjianyuyueService;
import com.entity.vo.FangjianyuyueVO;
import com.entity.view.FangjianyuyueView;

@Service("fangjianyuyueService")
public class FangjianyuyueServiceImpl extends ServiceImpl<FangjianyuyueDao, FangjianyuyueEntity> implements FangjianyuyueService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FangjianyuyueEntity> page = this.selectPage(
                new Query<FangjianyuyueEntity>(params).getPage(),
                new EntityWrapper<FangjianyuyueEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<FangjianyuyueEntity> wrapper) {
		  Page<FangjianyuyueView> page =new Query<FangjianyuyueView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<FangjianyuyueVO> selectListVO(Wrapper<FangjianyuyueEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public FangjianyuyueVO selectVO(Wrapper<FangjianyuyueEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<FangjianyuyueView> selectListView(Wrapper<FangjianyuyueEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public FangjianyuyueView selectView(Wrapper<FangjianyuyueEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

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


import com.dao.FangjianruzhuDao;
import com.entity.FangjianruzhuEntity;
import com.service.FangjianruzhuService;
import com.entity.vo.FangjianruzhuVO;
import com.entity.view.FangjianruzhuView;

@Service("fangjianruzhuService")
public class FangjianruzhuServiceImpl extends ServiceImpl<FangjianruzhuDao, FangjianruzhuEntity> implements FangjianruzhuService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FangjianruzhuEntity> page = this.selectPage(
                new Query<FangjianruzhuEntity>(params).getPage(),
                new EntityWrapper<FangjianruzhuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<FangjianruzhuEntity> wrapper) {
		  Page<FangjianruzhuView> page =new Query<FangjianruzhuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<FangjianruzhuVO> selectListVO(Wrapper<FangjianruzhuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public FangjianruzhuVO selectVO(Wrapper<FangjianruzhuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<FangjianruzhuView> selectListView(Wrapper<FangjianruzhuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public FangjianruzhuView selectView(Wrapper<FangjianruzhuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<FangjianruzhuEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<FangjianruzhuEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<FangjianruzhuEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }



}

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


import com.dao.FangjiantuifangDao;
import com.entity.FangjiantuifangEntity;
import com.service.FangjiantuifangService;
import com.entity.vo.FangjiantuifangVO;
import com.entity.view.FangjiantuifangView;

@Service("fangjiantuifangService")
public class FangjiantuifangServiceImpl extends ServiceImpl<FangjiantuifangDao, FangjiantuifangEntity> implements FangjiantuifangService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FangjiantuifangEntity> page = this.selectPage(
                new Query<FangjiantuifangEntity>(params).getPage(),
                new EntityWrapper<FangjiantuifangEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<FangjiantuifangEntity> wrapper) {
		  Page<FangjiantuifangView> page =new Query<FangjiantuifangView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<FangjiantuifangVO> selectListVO(Wrapper<FangjiantuifangEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public FangjiantuifangVO selectVO(Wrapper<FangjiantuifangEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<FangjiantuifangView> selectListView(Wrapper<FangjiantuifangEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public FangjiantuifangView selectView(Wrapper<FangjiantuifangEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<FangjiantuifangEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<FangjiantuifangEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<FangjiantuifangEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }



}

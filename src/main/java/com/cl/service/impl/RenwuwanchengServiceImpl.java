package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.RenwuwanchengDao;
import com.cl.entity.RenwuwanchengEntity;
import com.cl.service.RenwuwanchengService;
import com.cl.entity.view.RenwuwanchengView;

@Service("renwuwanchengService")
public class RenwuwanchengServiceImpl extends ServiceImpl<RenwuwanchengDao, RenwuwanchengEntity> implements RenwuwanchengService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<RenwuwanchengEntity> page = this.selectPage(
                new Query<RenwuwanchengEntity>(params).getPage(),
                new EntityWrapper<RenwuwanchengEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<RenwuwanchengEntity> wrapper) {
		  Page<RenwuwanchengView> page =new Query<RenwuwanchengView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<RenwuwanchengView> selectListView(Wrapper<RenwuwanchengEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public RenwuwanchengView selectView(Wrapper<RenwuwanchengEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

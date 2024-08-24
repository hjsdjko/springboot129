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


import com.cl.dao.FengcaizhanshiDao;
import com.cl.entity.FengcaizhanshiEntity;
import com.cl.service.FengcaizhanshiService;
import com.cl.entity.view.FengcaizhanshiView;

@Service("fengcaizhanshiService")
public class FengcaizhanshiServiceImpl extends ServiceImpl<FengcaizhanshiDao, FengcaizhanshiEntity> implements FengcaizhanshiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FengcaizhanshiEntity> page = this.selectPage(
                new Query<FengcaizhanshiEntity>(params).getPage(),
                new EntityWrapper<FengcaizhanshiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<FengcaizhanshiEntity> wrapper) {
		  Page<FengcaizhanshiView> page =new Query<FengcaizhanshiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<FengcaizhanshiView> selectListView(Wrapper<FengcaizhanshiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public FengcaizhanshiView selectView(Wrapper<FengcaizhanshiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

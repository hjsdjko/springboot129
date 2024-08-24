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


import com.cl.dao.ZhiyuanzheDao;
import com.cl.entity.ZhiyuanzheEntity;
import com.cl.service.ZhiyuanzheService;
import com.cl.entity.view.ZhiyuanzheView;

@Service("zhiyuanzheService")
public class ZhiyuanzheServiceImpl extends ServiceImpl<ZhiyuanzheDao, ZhiyuanzheEntity> implements ZhiyuanzheService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZhiyuanzheEntity> page = this.selectPage(
                new Query<ZhiyuanzheEntity>(params).getPage(),
                new EntityWrapper<ZhiyuanzheEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZhiyuanzheEntity> wrapper) {
		  Page<ZhiyuanzheView> page =new Query<ZhiyuanzheView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ZhiyuanzheView> selectListView(Wrapper<ZhiyuanzheEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZhiyuanzheView selectView(Wrapper<ZhiyuanzheEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

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


import com.cl.dao.ZhiyuanzhepeixunDao;
import com.cl.entity.ZhiyuanzhepeixunEntity;
import com.cl.service.ZhiyuanzhepeixunService;
import com.cl.entity.view.ZhiyuanzhepeixunView;

@Service("zhiyuanzhepeixunService")
public class ZhiyuanzhepeixunServiceImpl extends ServiceImpl<ZhiyuanzhepeixunDao, ZhiyuanzhepeixunEntity> implements ZhiyuanzhepeixunService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZhiyuanzhepeixunEntity> page = this.selectPage(
                new Query<ZhiyuanzhepeixunEntity>(params).getPage(),
                new EntityWrapper<ZhiyuanzhepeixunEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZhiyuanzhepeixunEntity> wrapper) {
		  Page<ZhiyuanzhepeixunView> page =new Query<ZhiyuanzhepeixunView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ZhiyuanzhepeixunView> selectListView(Wrapper<ZhiyuanzhepeixunEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZhiyuanzhepeixunView selectView(Wrapper<ZhiyuanzhepeixunEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

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


import com.cl.dao.ZhiyuanfuwuqiantuiDao;
import com.cl.entity.ZhiyuanfuwuqiantuiEntity;
import com.cl.service.ZhiyuanfuwuqiantuiService;
import com.cl.entity.view.ZhiyuanfuwuqiantuiView;

@Service("zhiyuanfuwuqiantuiService")
public class ZhiyuanfuwuqiantuiServiceImpl extends ServiceImpl<ZhiyuanfuwuqiantuiDao, ZhiyuanfuwuqiantuiEntity> implements ZhiyuanfuwuqiantuiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZhiyuanfuwuqiantuiEntity> page = this.selectPage(
                new Query<ZhiyuanfuwuqiantuiEntity>(params).getPage(),
                new EntityWrapper<ZhiyuanfuwuqiantuiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZhiyuanfuwuqiantuiEntity> wrapper) {
		  Page<ZhiyuanfuwuqiantuiView> page =new Query<ZhiyuanfuwuqiantuiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ZhiyuanfuwuqiantuiView> selectListView(Wrapper<ZhiyuanfuwuqiantuiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZhiyuanfuwuqiantuiView selectView(Wrapper<ZhiyuanfuwuqiantuiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

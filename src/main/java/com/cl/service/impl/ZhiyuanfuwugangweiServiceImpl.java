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


import com.cl.dao.ZhiyuanfuwugangweiDao;
import com.cl.entity.ZhiyuanfuwugangweiEntity;
import com.cl.service.ZhiyuanfuwugangweiService;
import com.cl.entity.view.ZhiyuanfuwugangweiView;

@Service("zhiyuanfuwugangweiService")
public class ZhiyuanfuwugangweiServiceImpl extends ServiceImpl<ZhiyuanfuwugangweiDao, ZhiyuanfuwugangweiEntity> implements ZhiyuanfuwugangweiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZhiyuanfuwugangweiEntity> page = this.selectPage(
                new Query<ZhiyuanfuwugangweiEntity>(params).getPage(),
                new EntityWrapper<ZhiyuanfuwugangweiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZhiyuanfuwugangweiEntity> wrapper) {
		  Page<ZhiyuanfuwugangweiView> page =new Query<ZhiyuanfuwugangweiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ZhiyuanfuwugangweiView> selectListView(Wrapper<ZhiyuanfuwugangweiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZhiyuanfuwugangweiView selectView(Wrapper<ZhiyuanfuwugangweiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

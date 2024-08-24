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


import com.cl.dao.ZhiyuanfuwuqiandaoDao;
import com.cl.entity.ZhiyuanfuwuqiandaoEntity;
import com.cl.service.ZhiyuanfuwuqiandaoService;
import com.cl.entity.view.ZhiyuanfuwuqiandaoView;

@Service("zhiyuanfuwuqiandaoService")
public class ZhiyuanfuwuqiandaoServiceImpl extends ServiceImpl<ZhiyuanfuwuqiandaoDao, ZhiyuanfuwuqiandaoEntity> implements ZhiyuanfuwuqiandaoService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZhiyuanfuwuqiandaoEntity> page = this.selectPage(
                new Query<ZhiyuanfuwuqiandaoEntity>(params).getPage(),
                new EntityWrapper<ZhiyuanfuwuqiandaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZhiyuanfuwuqiandaoEntity> wrapper) {
		  Page<ZhiyuanfuwuqiandaoView> page =new Query<ZhiyuanfuwuqiandaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ZhiyuanfuwuqiandaoView> selectListView(Wrapper<ZhiyuanfuwuqiandaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZhiyuanfuwuqiandaoView selectView(Wrapper<ZhiyuanfuwuqiandaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

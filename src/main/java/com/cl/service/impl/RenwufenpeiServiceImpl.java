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


import com.cl.dao.RenwufenpeiDao;
import com.cl.entity.RenwufenpeiEntity;
import com.cl.service.RenwufenpeiService;
import com.cl.entity.view.RenwufenpeiView;

@Service("renwufenpeiService")
public class RenwufenpeiServiceImpl extends ServiceImpl<RenwufenpeiDao, RenwufenpeiEntity> implements RenwufenpeiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<RenwufenpeiEntity> page = this.selectPage(
                new Query<RenwufenpeiEntity>(params).getPage(),
                new EntityWrapper<RenwufenpeiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<RenwufenpeiEntity> wrapper) {
		  Page<RenwufenpeiView> page =new Query<RenwufenpeiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<RenwufenpeiView> selectListView(Wrapper<RenwufenpeiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public RenwufenpeiView selectView(Wrapper<RenwufenpeiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

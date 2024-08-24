package com.cl.dao;

import com.cl.entity.ZhiyuanzheEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZhiyuanzheView;


/**
 * 志愿者
 * 
 * @author 
 * @email 
 * @date 2024-03-26 22:27:33
 */
public interface ZhiyuanzheDao extends BaseMapper<ZhiyuanzheEntity> {
	
	List<ZhiyuanzheView> selectListView(@Param("ew") Wrapper<ZhiyuanzheEntity> wrapper);

	List<ZhiyuanzheView> selectListView(Pagination page,@Param("ew") Wrapper<ZhiyuanzheEntity> wrapper);
	
	ZhiyuanzheView selectView(@Param("ew") Wrapper<ZhiyuanzheEntity> wrapper);
	

}

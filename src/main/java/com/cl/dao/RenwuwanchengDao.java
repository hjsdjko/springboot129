package com.cl.dao;

import com.cl.entity.RenwuwanchengEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.RenwuwanchengView;


/**
 * 任务完成
 * 
 * @author 
 * @email 
 * @date 2024-03-26 22:27:34
 */
public interface RenwuwanchengDao extends BaseMapper<RenwuwanchengEntity> {
	
	List<RenwuwanchengView> selectListView(@Param("ew") Wrapper<RenwuwanchengEntity> wrapper);

	List<RenwuwanchengView> selectListView(Pagination page,@Param("ew") Wrapper<RenwuwanchengEntity> wrapper);
	
	RenwuwanchengView selectView(@Param("ew") Wrapper<RenwuwanchengEntity> wrapper);
	

}

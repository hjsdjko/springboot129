package com.cl.dao;

import com.cl.entity.FengcaizhanshiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.FengcaizhanshiView;


/**
 * 风采展示
 * 
 * @author 
 * @email 
 * @date 2024-03-26 22:27:34
 */
public interface FengcaizhanshiDao extends BaseMapper<FengcaizhanshiEntity> {
	
	List<FengcaizhanshiView> selectListView(@Param("ew") Wrapper<FengcaizhanshiEntity> wrapper);

	List<FengcaizhanshiView> selectListView(Pagination page,@Param("ew") Wrapper<FengcaizhanshiEntity> wrapper);
	
	FengcaizhanshiView selectView(@Param("ew") Wrapper<FengcaizhanshiEntity> wrapper);
	

}

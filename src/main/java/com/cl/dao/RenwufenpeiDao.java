package com.cl.dao;

import com.cl.entity.RenwufenpeiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.RenwufenpeiView;


/**
 * 任务分配
 * 
 * @author 
 * @email 
 * @date 2024-03-26 22:27:34
 */
public interface RenwufenpeiDao extends BaseMapper<RenwufenpeiEntity> {
	
	List<RenwufenpeiView> selectListView(@Param("ew") Wrapper<RenwufenpeiEntity> wrapper);

	List<RenwufenpeiView> selectListView(Pagination page,@Param("ew") Wrapper<RenwufenpeiEntity> wrapper);
	
	RenwufenpeiView selectView(@Param("ew") Wrapper<RenwufenpeiEntity> wrapper);
	

}

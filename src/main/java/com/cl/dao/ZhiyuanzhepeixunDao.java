package com.cl.dao;

import com.cl.entity.ZhiyuanzhepeixunEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZhiyuanzhepeixunView;


/**
 * 志愿者培训
 * 
 * @author 
 * @email 
 * @date 2024-03-26 22:27:34
 */
public interface ZhiyuanzhepeixunDao extends BaseMapper<ZhiyuanzhepeixunEntity> {
	
	List<ZhiyuanzhepeixunView> selectListView(@Param("ew") Wrapper<ZhiyuanzhepeixunEntity> wrapper);

	List<ZhiyuanzhepeixunView> selectListView(Pagination page,@Param("ew") Wrapper<ZhiyuanzhepeixunEntity> wrapper);
	
	ZhiyuanzhepeixunView selectView(@Param("ew") Wrapper<ZhiyuanzhepeixunEntity> wrapper);
	

}

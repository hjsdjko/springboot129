package com.cl.dao;

import com.cl.entity.ZhiyuanfuwuqiantuiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZhiyuanfuwuqiantuiView;


/**
 * 志愿服务签退
 * 
 * @author 
 * @email 
 * @date 2024-03-26 22:27:34
 */
public interface ZhiyuanfuwuqiantuiDao extends BaseMapper<ZhiyuanfuwuqiantuiEntity> {
	
	List<ZhiyuanfuwuqiantuiView> selectListView(@Param("ew") Wrapper<ZhiyuanfuwuqiantuiEntity> wrapper);

	List<ZhiyuanfuwuqiantuiView> selectListView(Pagination page,@Param("ew") Wrapper<ZhiyuanfuwuqiantuiEntity> wrapper);
	
	ZhiyuanfuwuqiantuiView selectView(@Param("ew") Wrapper<ZhiyuanfuwuqiantuiEntity> wrapper);
	

}

package com.cl.dao;

import com.cl.entity.ZhiyuanfuwugangweiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZhiyuanfuwugangweiView;


/**
 * 志愿服务岗位
 * 
 * @author 
 * @email 
 * @date 2024-03-26 22:27:34
 */
public interface ZhiyuanfuwugangweiDao extends BaseMapper<ZhiyuanfuwugangweiEntity> {
	
	List<ZhiyuanfuwugangweiView> selectListView(@Param("ew") Wrapper<ZhiyuanfuwugangweiEntity> wrapper);

	List<ZhiyuanfuwugangweiView> selectListView(Pagination page,@Param("ew") Wrapper<ZhiyuanfuwugangweiEntity> wrapper);
	
	ZhiyuanfuwugangweiView selectView(@Param("ew") Wrapper<ZhiyuanfuwugangweiEntity> wrapper);
	

}

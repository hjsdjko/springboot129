package com.cl.dao;

import com.cl.entity.ZhiyuanfuwuqiandaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZhiyuanfuwuqiandaoView;


/**
 * 志愿服务签到
 * 
 * @author 
 * @email 
 * @date 2024-03-26 22:27:34
 */
public interface ZhiyuanfuwuqiandaoDao extends BaseMapper<ZhiyuanfuwuqiandaoEntity> {
	
	List<ZhiyuanfuwuqiandaoView> selectListView(@Param("ew") Wrapper<ZhiyuanfuwuqiandaoEntity> wrapper);

	List<ZhiyuanfuwuqiandaoView> selectListView(Pagination page,@Param("ew") Wrapper<ZhiyuanfuwuqiandaoEntity> wrapper);
	
	ZhiyuanfuwuqiandaoView selectView(@Param("ew") Wrapper<ZhiyuanfuwuqiandaoEntity> wrapper);
	

}

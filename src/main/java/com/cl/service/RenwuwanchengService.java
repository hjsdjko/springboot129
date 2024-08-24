package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.RenwuwanchengEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.RenwuwanchengView;


/**
 * 任务完成
 *
 * @author 
 * @email 
 * @date 2024-03-26 22:27:34
 */
public interface RenwuwanchengService extends IService<RenwuwanchengEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<RenwuwanchengView> selectListView(Wrapper<RenwuwanchengEntity> wrapper);
   	
   	RenwuwanchengView selectView(@Param("ew") Wrapper<RenwuwanchengEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<RenwuwanchengEntity> wrapper);
   	

}


package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.FengcaizhanshiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.FengcaizhanshiView;


/**
 * 风采展示
 *
 * @author 
 * @email 
 * @date 2024-03-26 22:27:34
 */
public interface FengcaizhanshiService extends IService<FengcaizhanshiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<FengcaizhanshiView> selectListView(Wrapper<FengcaizhanshiEntity> wrapper);
   	
   	FengcaizhanshiView selectView(@Param("ew") Wrapper<FengcaizhanshiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<FengcaizhanshiEntity> wrapper);
   	

}


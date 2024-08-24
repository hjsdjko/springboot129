package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.RenwufenpeiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.RenwufenpeiView;


/**
 * 任务分配
 *
 * @author 
 * @email 
 * @date 2024-03-26 22:27:34
 */
public interface RenwufenpeiService extends IService<RenwufenpeiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<RenwufenpeiView> selectListView(Wrapper<RenwufenpeiEntity> wrapper);
   	
   	RenwufenpeiView selectView(@Param("ew") Wrapper<RenwufenpeiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<RenwufenpeiEntity> wrapper);
   	

}


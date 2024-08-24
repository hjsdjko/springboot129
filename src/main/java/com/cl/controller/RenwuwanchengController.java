package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.RenwuwanchengEntity;
import com.cl.entity.view.RenwuwanchengView;

import com.cl.service.RenwuwanchengService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 任务完成
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-26 22:27:34
 */
@RestController
@RequestMapping("/renwuwancheng")
public class RenwuwanchengController {
    @Autowired
    private RenwuwanchengService renwuwanchengService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,RenwuwanchengEntity renwuwancheng,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("zhiyuanzhe")) {
			renwuwancheng.setZhiyuanzhezhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<RenwuwanchengEntity> ew = new EntityWrapper<RenwuwanchengEntity>();

		PageUtils page = renwuwanchengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, renwuwancheng), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,RenwuwanchengEntity renwuwancheng, 
		HttpServletRequest request){
        EntityWrapper<RenwuwanchengEntity> ew = new EntityWrapper<RenwuwanchengEntity>();

		PageUtils page = renwuwanchengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, renwuwancheng), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( RenwuwanchengEntity renwuwancheng){
       	EntityWrapper<RenwuwanchengEntity> ew = new EntityWrapper<RenwuwanchengEntity>();
      	ew.allEq(MPUtil.allEQMapPre( renwuwancheng, "renwuwancheng")); 
        return R.ok().put("data", renwuwanchengService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(RenwuwanchengEntity renwuwancheng){
        EntityWrapper< RenwuwanchengEntity> ew = new EntityWrapper< RenwuwanchengEntity>();
 		ew.allEq(MPUtil.allEQMapPre( renwuwancheng, "renwuwancheng")); 
		RenwuwanchengView renwuwanchengView =  renwuwanchengService.selectView(ew);
		return R.ok("查询任务完成成功").put("data", renwuwanchengView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        RenwuwanchengEntity renwuwancheng = renwuwanchengService.selectById(id);
		renwuwancheng = renwuwanchengService.selectView(new EntityWrapper<RenwuwanchengEntity>().eq("id", id));
        return R.ok().put("data", renwuwancheng);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        RenwuwanchengEntity renwuwancheng = renwuwanchengService.selectById(id);
		renwuwancheng = renwuwanchengService.selectView(new EntityWrapper<RenwuwanchengEntity>().eq("id", id));
        return R.ok().put("data", renwuwancheng);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody RenwuwanchengEntity renwuwancheng, HttpServletRequest request){
    	renwuwancheng.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(renwuwancheng);
        renwuwanchengService.insert(renwuwancheng);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody RenwuwanchengEntity renwuwancheng, HttpServletRequest request){
    	renwuwancheng.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(renwuwancheng);
        renwuwanchengService.insert(renwuwancheng);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody RenwuwanchengEntity renwuwancheng, HttpServletRequest request){
        //ValidatorUtils.validateEntity(renwuwancheng);
        renwuwanchengService.updateById(renwuwancheng);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        renwuwanchengService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}

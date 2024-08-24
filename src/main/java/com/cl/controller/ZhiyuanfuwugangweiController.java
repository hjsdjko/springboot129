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

import com.cl.entity.ZhiyuanfuwugangweiEntity;
import com.cl.entity.view.ZhiyuanfuwugangweiView;

import com.cl.service.ZhiyuanfuwugangweiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 志愿服务岗位
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-26 22:27:34
 */
@RestController
@RequestMapping("/zhiyuanfuwugangwei")
public class ZhiyuanfuwugangweiController {
    @Autowired
    private ZhiyuanfuwugangweiService zhiyuanfuwugangweiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZhiyuanfuwugangweiEntity zhiyuanfuwugangwei,
		HttpServletRequest request){
        EntityWrapper<ZhiyuanfuwugangweiEntity> ew = new EntityWrapper<ZhiyuanfuwugangweiEntity>();

		PageUtils page = zhiyuanfuwugangweiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhiyuanfuwugangwei), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZhiyuanfuwugangweiEntity zhiyuanfuwugangwei, 
		HttpServletRequest request){
        EntityWrapper<ZhiyuanfuwugangweiEntity> ew = new EntityWrapper<ZhiyuanfuwugangweiEntity>();

		PageUtils page = zhiyuanfuwugangweiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhiyuanfuwugangwei), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZhiyuanfuwugangweiEntity zhiyuanfuwugangwei){
       	EntityWrapper<ZhiyuanfuwugangweiEntity> ew = new EntityWrapper<ZhiyuanfuwugangweiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zhiyuanfuwugangwei, "zhiyuanfuwugangwei")); 
        return R.ok().put("data", zhiyuanfuwugangweiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZhiyuanfuwugangweiEntity zhiyuanfuwugangwei){
        EntityWrapper< ZhiyuanfuwugangweiEntity> ew = new EntityWrapper< ZhiyuanfuwugangweiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zhiyuanfuwugangwei, "zhiyuanfuwugangwei")); 
		ZhiyuanfuwugangweiView zhiyuanfuwugangweiView =  zhiyuanfuwugangweiService.selectView(ew);
		return R.ok("查询志愿服务岗位成功").put("data", zhiyuanfuwugangweiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZhiyuanfuwugangweiEntity zhiyuanfuwugangwei = zhiyuanfuwugangweiService.selectById(id);
		zhiyuanfuwugangwei = zhiyuanfuwugangweiService.selectView(new EntityWrapper<ZhiyuanfuwugangweiEntity>().eq("id", id));
        return R.ok().put("data", zhiyuanfuwugangwei);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZhiyuanfuwugangweiEntity zhiyuanfuwugangwei = zhiyuanfuwugangweiService.selectById(id);
		zhiyuanfuwugangwei = zhiyuanfuwugangweiService.selectView(new EntityWrapper<ZhiyuanfuwugangweiEntity>().eq("id", id));
        return R.ok().put("data", zhiyuanfuwugangwei);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZhiyuanfuwugangweiEntity zhiyuanfuwugangwei, HttpServletRequest request){
    	zhiyuanfuwugangwei.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zhiyuanfuwugangwei);
        zhiyuanfuwugangweiService.insert(zhiyuanfuwugangwei);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZhiyuanfuwugangweiEntity zhiyuanfuwugangwei, HttpServletRequest request){
    	zhiyuanfuwugangwei.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zhiyuanfuwugangwei);
        zhiyuanfuwugangweiService.insert(zhiyuanfuwugangwei);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZhiyuanfuwugangweiEntity zhiyuanfuwugangwei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zhiyuanfuwugangwei);
        zhiyuanfuwugangweiService.updateById(zhiyuanfuwugangwei);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zhiyuanfuwugangweiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}

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

import com.cl.entity.ZhiyuanfuwuqiandaoEntity;
import com.cl.entity.view.ZhiyuanfuwuqiandaoView;

import com.cl.service.ZhiyuanfuwuqiandaoService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 志愿服务签到
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-26 22:27:34
 */
@RestController
@RequestMapping("/zhiyuanfuwuqiandao")
public class ZhiyuanfuwuqiandaoController {
    @Autowired
    private ZhiyuanfuwuqiandaoService zhiyuanfuwuqiandaoService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZhiyuanfuwuqiandaoEntity zhiyuanfuwuqiandao,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("zhiyuanzhe")) {
			zhiyuanfuwuqiandao.setZhiyuanzhezhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ZhiyuanfuwuqiandaoEntity> ew = new EntityWrapper<ZhiyuanfuwuqiandaoEntity>();

		PageUtils page = zhiyuanfuwuqiandaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhiyuanfuwuqiandao), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZhiyuanfuwuqiandaoEntity zhiyuanfuwuqiandao, 
		HttpServletRequest request){
        EntityWrapper<ZhiyuanfuwuqiandaoEntity> ew = new EntityWrapper<ZhiyuanfuwuqiandaoEntity>();

		PageUtils page = zhiyuanfuwuqiandaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhiyuanfuwuqiandao), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZhiyuanfuwuqiandaoEntity zhiyuanfuwuqiandao){
       	EntityWrapper<ZhiyuanfuwuqiandaoEntity> ew = new EntityWrapper<ZhiyuanfuwuqiandaoEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zhiyuanfuwuqiandao, "zhiyuanfuwuqiandao")); 
        return R.ok().put("data", zhiyuanfuwuqiandaoService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZhiyuanfuwuqiandaoEntity zhiyuanfuwuqiandao){
        EntityWrapper< ZhiyuanfuwuqiandaoEntity> ew = new EntityWrapper< ZhiyuanfuwuqiandaoEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zhiyuanfuwuqiandao, "zhiyuanfuwuqiandao")); 
		ZhiyuanfuwuqiandaoView zhiyuanfuwuqiandaoView =  zhiyuanfuwuqiandaoService.selectView(ew);
		return R.ok("查询志愿服务签到成功").put("data", zhiyuanfuwuqiandaoView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZhiyuanfuwuqiandaoEntity zhiyuanfuwuqiandao = zhiyuanfuwuqiandaoService.selectById(id);
		zhiyuanfuwuqiandao = zhiyuanfuwuqiandaoService.selectView(new EntityWrapper<ZhiyuanfuwuqiandaoEntity>().eq("id", id));
        return R.ok().put("data", zhiyuanfuwuqiandao);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZhiyuanfuwuqiandaoEntity zhiyuanfuwuqiandao = zhiyuanfuwuqiandaoService.selectById(id);
		zhiyuanfuwuqiandao = zhiyuanfuwuqiandaoService.selectView(new EntityWrapper<ZhiyuanfuwuqiandaoEntity>().eq("id", id));
        return R.ok().put("data", zhiyuanfuwuqiandao);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZhiyuanfuwuqiandaoEntity zhiyuanfuwuqiandao, HttpServletRequest request){
    	zhiyuanfuwuqiandao.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zhiyuanfuwuqiandao);
        zhiyuanfuwuqiandaoService.insert(zhiyuanfuwuqiandao);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZhiyuanfuwuqiandaoEntity zhiyuanfuwuqiandao, HttpServletRequest request){
    	zhiyuanfuwuqiandao.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zhiyuanfuwuqiandao);
        zhiyuanfuwuqiandaoService.insert(zhiyuanfuwuqiandao);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZhiyuanfuwuqiandaoEntity zhiyuanfuwuqiandao, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zhiyuanfuwuqiandao);
        zhiyuanfuwuqiandaoService.updateById(zhiyuanfuwuqiandao);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<ZhiyuanfuwuqiandaoEntity> list = new ArrayList<ZhiyuanfuwuqiandaoEntity>();
        for(Long id : ids) {
            ZhiyuanfuwuqiandaoEntity zhiyuanfuwuqiandao = zhiyuanfuwuqiandaoService.selectById(id);
            zhiyuanfuwuqiandao.setSfsh(sfsh);
            zhiyuanfuwuqiandao.setShhf(shhf);
            list.add(zhiyuanfuwuqiandao);
        }
        zhiyuanfuwuqiandaoService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zhiyuanfuwuqiandaoService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}

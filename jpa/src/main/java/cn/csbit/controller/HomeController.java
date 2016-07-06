package cn.csbit.controller;

import cn.csbit.common.Global;
import cn.csbit.common.PageUtil;
import cn.csbit.model.ColumnDetail;
import cn.csbit.model.DataSource;
import cn.csbit.repository.DataSourceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Answer on 16/7/1.
 */
@Controller
public class HomeController {

    @Autowired
    DataSourceDao dataSourceDao;

    @RequestMapping(value = "/{path}", method = RequestMethod.GET)
    public String index(@PathVariable("path") String path) {
        return path;
    }

    @RequestMapping(value = "/source/add", method = RequestMethod.POST)
    @ResponseBody
    public String addDataSource(@Valid DataSource dataSource, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<ObjectError> errors = bindingResult.getAllErrors();
            for (ObjectError error : errors) {
//                Log.e(error);
                System.out.println(error);
            }
            return Global.RESULT.ERROR;
        } else {
            dataSourceDao.save(dataSource);
            return Global.RESULT.SUCCESS;
        }
    }

    @RequestMapping(value = "/source/get", method = RequestMethod.GET)
    @ResponseBody
    public Object getDataSource(@RequestParam(value = "pageSize") Integer pageSize,
                                @RequestParam(value = "pageNumber") Integer pageNumber,
                                @RequestParam(value = "sortOrder") String sortOrder) {
        Page<DataSource> page = dataSourceDao.findAll(new PageRequest(pageNumber - 1, pageSize));
        return PageUtil.PageToMap(page);
    }

    @RequestMapping(value = "/source/getById", method = RequestMethod.POST)
    @ResponseBody
    public Object getDataSourceById(@RequestParam(value = "id") Integer id) {
        DataSource dataSource = dataSourceDao.findOne(id);
        return dataSource;
    }

    @RequestMapping(value = "/source/del", method = RequestMethod.POST)
    @ResponseBody
    public String delDataSource(@RequestParam(value = "id") Integer id) {
        this.dataSourceDao.delete(id);
        return Global.RESULT.SUCCESS;
    }


    @RequestMapping(value = "/source/editInterrupt", method = RequestMethod.POST)
    @ResponseBody
    public String editInterrupt(@RequestParam(value = "id") Integer id, @RequestParam(value = "interrupt") Boolean interrupt) {
        DataSource dataSource = this.dataSourceDao.findOne(id);
        dataSource.setInterrupt(interrupt);
        this.dataSourceDao.save(dataSource);
        return Global.RESULT.SUCCESS;
    }

    /**
     * 获取Oracle数据库Schema名称列表
     * 安全域树形结构的父节点
     */
    @RequestMapping(value = "/schema/get")
    @ResponseBody
    public Object getSchema() {
        List<String> parents = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String parent = "parent" + i;
            parents.add(parent);
        }
        return parents;
    }

    /**
     * 通过Oracle数据库的Schema获取所有表
     * 通过安全域父节点获取子节点
     *
     * @param schema
     * @return
     */
    @RequestMapping(value = "/schema/getChild")
    @ResponseBody
    public Object getChild(@RequestParam(value = "schema") String schema) {
        List<String> children = new ArrayList<>();
        int lent = 3;//(int) Math.random();
        for (int i = 0; i < lent; i++) {
            String child = schema + "-Child";
            children.add(child);
        }
        return children;
    }

    @RequestMapping(value = "/schema/getChildDetail")
    @ResponseBody
    public Object getChildDetail(@RequestParam(value = "schema") String schema, @RequestParam(value = "table") String table) {
        List<ColumnDetail> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ColumnDetail columnDetail = new ColumnDetail();
            columnDetail.setAlgorithm(1);
            columnDetail.setColumn("Column" + i);
            columnDetail.setStatus(false);
            list.add(columnDetail);
        }
        return list;
    }


}

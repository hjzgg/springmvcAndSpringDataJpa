package com.hjz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.hjz.code.ReturnCode;
import com.hjz.page.PagableResponse;
import com.hjz.service.PersonService;
import com.hjz.vo.PersonVO;

@Controller
@RequestMapping(value = "person")
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject save(@RequestBody PersonVO personVO){
		JSONObject ret = new JSONObject();
		try {
			personService.save(personVO);
			ret.put("msg", "保存成功!");
			ret.put("code", ReturnCode.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			ret.put("msg", "保存失败!");
			ret.put("code", ReturnCode.FAILURE);
		}
		
		return ret;
	}
	
	@RequestMapping(value = "del")
	@ResponseBody
	public JSONObject del(@RequestParam(value="id") String id){
		JSONObject ret = new JSONObject();
		try {
			personService.deleteOnePerson(id);
			ret.put("msg", "删除成功!");
			ret.put("code", ReturnCode.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			ret.put("msg", "删除失败!");
			ret.put("code", ReturnCode.FAILURE);
		}
		
		return ret;
	}
	
	@RequestMapping(value = "delBatch", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject delBatch(@RequestParam("ids") List<String> ids){
		JSONObject ret = new JSONObject();
		try {
			personService.deletePersons(ids);
			ret.put("msg", "批量删除成功!");
			ret.put("code", ReturnCode.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			ret.put("msg", "批量删除失败!");
			ret.put("code", ReturnCode.FAILURE);
		}
		
		return ret;
	}
	
	@RequestMapping(value = "page")
    public ModelAndView page(@RequestParam("pageNumber") int pageNumber, @RequestParam("pageSize") int pageSize) {
       PageRequest pageRequest = new PageRequest(pageNumber-1, pageSize);
       PagableResponse<PersonVO> response = new PagableResponse<PersonVO>();
       response.setPageNumber(pageNumber);
       response.setPageSize(pageSize);
       try {
			List<PersonVO> data = personService.findPageablePersons(pageRequest);
			long count = personService.count();
			response.setList(data);
			response.setCount(count);
			response.setCode(ReturnCode.SUCCESS);
			response.setMsg("获取人员信息成功！");
		} catch(Exception e) {
			e.printStackTrace();
			response.setCode(ReturnCode.FAILURE);
			response.setMsg("获取人员信息失败！"); 
		}
       return new ModelAndView("person", "page", response);
    }
}

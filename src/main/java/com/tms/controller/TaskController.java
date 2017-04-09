package com.tms.controller;
import com.tms.entity.*;
import com.tms.dao.*;

import java.util.List;

import javax.validation.Valid;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;




import com.tms.repository.*;
import com.tms.dto.*;
@Controller
@RequestMapping(path="/task")
public class TaskController {
	@Autowired
	private TaskRepository taskRepository;
	@Autowired
	private TaskDao taskDao;
	@ResponseBody
	@RequestMapping(method=RequestMethod.POST,path="/save")
	public ResponseEntity saveEntity(@RequestBody @Validated  Task task,BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return ResponseEntity.ok(bindingResult.getAllErrors());
		}
		return ResponseEntity.ok(taskRepository.save(task));
	}
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.GET,path="/get/{taskId}")
	public Task findById(@PathVariable("taskId") long taskId) {
		return taskRepository.findOne(taskId);
	}
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.GET,path="/find")
	public Page<TaskDTO> findByFields(@PageableDefault(page=0,size=20) Pageable pagable,@RequestParam(name="statusfilter",required=false) Status status,@RequestParam(name="token",required=false) String token) {		
		return taskDao.findByField(pagable, status,token) ;
	}
	
	
	
}

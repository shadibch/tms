package com.tms.dao;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tms.dto.TaskDTO;
import com.tms.entity.*;
import com.tms.repository.*;
@Service
@Transactional
public class TaskDaoImpl implements TaskDao {
	@Autowired
	private TaskRepository taskRepository;
	@Override
	public Page<TaskDTO> findAll(Pageable pagable) {
		// TODO Auto-generated method stub
		Page<Task> result = taskRepository.findAll(pagable);
		return convert(result);
	}

	@Override
	public Page<TaskDTO> findByField(Pageable pagable,Status status,String token) {
		if(status == null && token == null) {
			return findAll(pagable);
		}
		if(token == null) {
			token = "%%";
		}else {
			token = "%" + token + "%";
		}
		Page<Task> page = status == null ? taskRepository.findByFirstNameIgnoreCaseLikeOrLastNameIgnoreCaseLike(pagable, token,token):
			taskRepository.filterByStatusAndName(pagable, status, token, token);
		return convert(page);
	}
	protected Page<TaskDTO> convert(Page<Task> p) {
		return p.map((c)->new TaskDTO(c));
	}
}

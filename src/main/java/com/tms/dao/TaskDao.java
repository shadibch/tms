package com.tms.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.tms.dto.*;
import com.tms.entity.Status;
public interface TaskDao {
	Page<TaskDTO> findAll(Pageable pagable);
	Page<TaskDTO> findByField(Pageable pagable ,Status status,String token);
}

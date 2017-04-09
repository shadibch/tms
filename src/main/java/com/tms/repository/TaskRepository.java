package com.tms.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.tms.entity.*;

public interface TaskRepository extends PagingAndSortingRepository<Task, Long> {
	@Query(value="select t from Task t where t.status = ?1 and (t.firstName like ?2 or t.lastName like ?3)",countQuery = "select count(t) from Task t where t.status = ?1 and (t.firstName like ?2 or t.lastName like ?3)")
	Page<Task> filterByStatusAndName(Pageable pagable, Status status,String firstName, String lastName);
	
	Page<Task> findByFirstNameIgnoreCaseLikeOrLastNameIgnoreCaseLike(Pageable pagable, String firstName, String lastName);
}

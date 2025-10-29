package com.crudop.CRUDOperation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crudop.CRUDOperation.entity.CrudEntity;

public interface CrudRepository extends JpaRepository<CrudEntity,Long>
{

}

package com.example.demo.repository;

import com.example.demo.entity.SysRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

/**
 * Created by archerlj on 2017/7/4.
 */
public interface SysRoleRepository extends CrudRepository<SysRole, Long> {

    List<SysRole> findAllByDescriptionIn(Collection<String> roleNames);
}

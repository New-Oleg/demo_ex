package com.example.ultrademo.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.ultrademo.object.order;


@Repository
public interface orderRepos extends CrudRepository<order, Integer>{

    order findById(int id);

}

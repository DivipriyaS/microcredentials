package com.cognizant.microcredentials.process.dao;

import org.springframework.data.repository.CrudRepository;

import com.cognizant.microcredentials.process.entity.Transaction;

public interface TransactionDao extends CrudRepository<Transaction, Long>{

}

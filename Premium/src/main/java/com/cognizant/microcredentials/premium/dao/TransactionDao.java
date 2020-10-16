package com.cognizant.microcredentials.premium.dao;

import org.springframework.data.repository.CrudRepository;

import com.cognizant.microcredentials.premium.entity.Transaction;

public interface TransactionDao extends CrudRepository<Transaction, Long>{

}

package com.cognizant.microcredentials.fileclaims.dao;

import org.springframework.data.repository.CrudRepository;

import com.cognizant.microcredentials.fileclaims.entity.Transaction;

public interface TransactionDao extends CrudRepository<Transaction, Long>{

}

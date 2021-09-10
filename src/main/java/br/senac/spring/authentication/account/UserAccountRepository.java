package br.senac.spring.authentication.account;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

public interface UserAccountRepository extends CrudRepository<UserAccount, Integer>,
        QuerydslPredicateExecutor<UserAccount>{
}

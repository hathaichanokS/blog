package org.fealise.blog.service;

import java.util.Map;

import org.fealise.blog.database.DataBase;
import org.fealise.blog.model.Account;


public class AccountService {
	
	private Map<String, Account> accounts = DataBase.getAccount();
	
	public AccountService(){
        this.accounts.put("fealise", new Account(1L, "fealise", "Emma", "Sreecharoen"));
    }
	
	public Account getAccount(String name) {
		return accounts.get(name);
	}
	
	public Account addAccount(Account acc) {
		acc.setId(accounts.size() + 1);
		accounts.put(acc.getAccountName(), acc);
		return acc;
	}
	
	public Account updateAccount(Account acc) {
		if(accounts.containsKey(acc.getAccountName())) {
			accounts.put(acc.getAccountName(), acc);
			return acc;
		}
		
		return null;
	}
	
	public Account deleteAccount(Account acc) {
		return accounts.remove(acc);
	}
}

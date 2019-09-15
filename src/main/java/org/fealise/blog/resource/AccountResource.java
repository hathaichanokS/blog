package org.fealise.blog.resource;


import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.fealise.blog.model.Account;
import org.fealise.blog.service.AccountService;

@Path("/account")
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class AccountResource {
	private AccountService accountService = new AccountService(); 
	
	@GET
	@Path("/{accountName}")
	public Account getAllAccount(@PathParam("/{accountName}")String accountName){
		return accountService.getAccount(accountName);
	}
	
	@POST
	public Account addAccount(Account account) {
		return accountService.addAccount(account);
	}
	
	@PUT
	@Path("/{accountName}")
	public Account updateAccount(@PathParam("/{accountName}")String accountName, Account account) {
		account.setAccountName(accountName);
		return accountService.updateAccount(account);
	}
	
	@DELETE
	public Account deleteAccount(Account account) {
		return accountService.deleteAccount(account);
	}
	
	
}

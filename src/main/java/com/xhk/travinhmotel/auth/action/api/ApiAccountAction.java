package com.xhk.travinhmotel.auth.action.api;

import com.xhk.travinhmotel.auth.action.base.JsonAction;
import com.xhk.travinhmotel.auth.action.dto.query.AccountQueryParam;
import com.xhk.travinhmotel.auth.entity.Account;
import com.xhk.travinhmotel.auth.security.Role;
import com.xhk.travinhmotel.auth.security.Secured;
import com.xhk.travinhmotel.auth.service.AccountService;
import org.apache.struts2.convention.annotation.Action;

import java.util.List;

public class ApiAccountAction extends JsonAction {

    private final transient AccountService accountService = AccountService.getInstance();

    private AccountQueryParam queryParam;

    @Secured(value = {Role.ADMIN, Role.CUSTOMER})
    @Action(value = "search")
    public String search() throws NoSuchFieldException, IllegalAccessException {
        List<Account> accountList = accountService.search(queryParam.build());
        addJsonParam(accountList);
        return SUCCESS;
    }

    public AccountService getAccountService() {
        return accountService;
    }

    public AccountQueryParam getQueryParam() {
        return queryParam;
    }

    public void setQueryParam(AccountQueryParam queryParam) {
        this.queryParam = queryParam;
    }
}

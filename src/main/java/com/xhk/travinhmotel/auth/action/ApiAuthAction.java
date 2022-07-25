package com.xhk.travinhmotel.auth.action;

import com.xhk.travinhmotel.auth.entity.Account;
import com.xhk.travinhmotel.auth.form.LoginForm;
import com.xhk.travinhmotel.auth.service.AccountService;
import org.apache.struts2.convention.annotation.Action;

import java.util.List;

@Role(value = {RoleType.ADMIN})
public class ApiAuthAction extends JsonAction {
    private LoginForm loginForm;
    private final transient AccountService accountService =null;


    @Action(value = "list-account")
    public String list() {
        List<Account> accountList = accountService.getAccountList();
        addJsonParam(accountList);
        return SUCCESS;
    }


    public LoginForm getLoginForm() {
        return loginForm;
    }

    public void setLoginForm(LoginForm loginForm) {
        this.loginForm = loginForm;
    }
}
package com.xhk.travinhmotel.auth.action.api;

import com.xhk.travinhmotel.auth.action.base.JsonAction;
import com.xhk.travinhmotel.auth.action.dto.JsonResponse;
import com.xhk.travinhmotel.auth.entity.Account;
import com.xhk.travinhmotel.auth.form.LoginForm;
import com.xhk.travinhmotel.auth.security.Role;
import com.xhk.travinhmotel.auth.security.Secured;
import com.xhk.travinhmotel.auth.service.AccountService;
import com.xhk.travinhmotel.auth.service.AuthenticationService;
import org.apache.struts2.convention.annotation.Action;

import java.util.List;


public class ApiAuthAction extends JsonAction {
    private LoginForm loginForm;
    private final transient AccountService accountService = AccountService.getInstance();


    @Secured(value = {Role.ADMIN, Role.CUSTOMER})
    @Action(value = "list-account")
    public String list() {
        AuthenticationService.getInstance().validate("asdadf", "asdadsf");
        List<Account> accountList = accountService.getAccountList();
        addJsonParam(accountList);
        return SUCCESS;
    }

    @Action(value = "login")
    public String login() {
        Account account = accountService.getAccountById(Long.parseLong(loginForm.getUsername()));
        addJsonParam(account);
        setUserRoles(Role.ADMIN);
        executeLogin();
        return SUCCESS;
    }

    @Secured
    @Action(value = "logout")
    public String logout() {
        addJsonParam(new JsonResponse("200", "Logout Success!"));
        setUserRoles();
        executeLout();
        return SUCCESS;
    }


    public LoginForm getLoginForm() {
        return loginForm;
    }

    public void setLoginForm(LoginForm loginForm) {
        this.loginForm = loginForm;
    }
}
package com.xhk.travinhmotel.auth.action.web;

import com.xhk.travinhmotel.auth.action.base.WebAction;
import com.xhk.travinhmotel.auth.entity.Account;
import com.xhk.travinhmotel.auth.form.LoginForm;
import com.xhk.travinhmotel.auth.security.Role;
import com.xhk.travinhmotel.auth.service.AccountService;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

@Namespace("/auth")
public class AuthAction extends WebAction {
    private LoginForm loginForm;

    private final transient AccountService accountService = AccountService.getInstance();

    @Action(value = "index",
            results = {
                    @Result(name = SUCCESS, location = "auth.index", type = "tiles")
            }
    )
    public String index() {
        return SUCCESS;
    }

    @Action(value = "login",
            results = {
                    @Result(name = SUCCESS, type = "redirectAction", params = {"actionName", "index", "namespace", "/home"}),
                    @Result(name = ERROR, location = "auth.index", type = "tiles")
            }
    )
    public String login() {
        try {
            Account account = accountService.getAccountById(Long.parseLong(loginForm.getUsername()));
            addParam("account", account);
            setUserRoles(Role.ADMIN);
            executeLogin();
            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }

    public LoginForm getLoginForm() {
        return loginForm;
    }

    public void setLoginForm(LoginForm loginForm) {
        this.loginForm = loginForm;
    }
}
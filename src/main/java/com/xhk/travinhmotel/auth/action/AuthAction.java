package com.xhk.travinhmotel.auth.action;

import com.xhk.travinhmotel.auth.entity.Account;
import com.xhk.travinhmotel.auth.form.LoginForm;
import com.xhk.travinhmotel.auth.service.AccountService;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import java.util.List;

@Namespace("/auth")
public class AuthAction extends BaseAction {
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
                    @Result(name = SUCCESS, location = "auth.index", type = "tiles"),
                    @Result(name = ERROR, location = "home.index", type = "tiles")
            }
    )
    public String login() {
        try {
            Account account = accountService.getAccountById(Long.parseLong(loginForm.getUsername()));
            addParam("account", account);
            addParam("message", "Tao xin chao!!!");
            List<Account> accountList = accountService.getAccountList();
            addParam("accountList", accountList);

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
package com.xhk.travinhmotel.auth.action;

import com.xhk.travinhmotel.auth.dao.AccountDao;
import com.xhk.travinhmotel.auth.entity.Account;
import com.xhk.travinhmotel.auth.form.LoginForm;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import java.io.Serializable;
import java.util.Optional;

@Namespace("/auth")
public class AuthAction extends BaseAction implements Serializable {

    private static final long serialVersionUID = 1L;

    private LoginForm loginForm;


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
                    @Result(name = SUCCESS, location = "auth.index", type = "tiles")
            }
    )
    public String login() {
        AccountDao accountDao = new AccountDao();
        Optional<Account> account = accountDao.findById(1L);
        addParam("account", account.get());
        addParam("message", "Tao xin chao!!!");
        return SUCCESS;
    }


    public LoginForm getLoginForm() {
        return loginForm;
    }

    public void setLoginForm(LoginForm loginForm) {
        this.loginForm = loginForm;
    }

}
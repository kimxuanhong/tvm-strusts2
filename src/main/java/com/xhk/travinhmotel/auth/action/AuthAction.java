package com.xhk.travinhmotel.auth.action;

import com.xhk.travinhmotel.auth.entity.Account;
import com.xhk.travinhmotel.auth.form.LoginForm;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.io.Serializable;

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
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();
        Account account =  session.createQuery("FROM Account", Account.class).getResultList().get(0);


        addParam("account", account);
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
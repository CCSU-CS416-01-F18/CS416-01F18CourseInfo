/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ccsu;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Web application lifecycle listener.
 *
 * @author cw1491
 */
@WebListener()
public class SessionAttributeListener implements HttpSessionAttributeListener {

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
       event.getSession().getServletContext().log("Session Attribute created "+event.getName()+"="+event.getValue());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
       event.getSession().getServletContext().log("Session Attribute removed "+event.getName());
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
       event.getSession().getServletContext().log("Session Attribute changed "+event.getName()+"="+event.getValue());
    }
}

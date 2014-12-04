package com.tradenow.domains.mail;

import com.tradenow.domains.user.User;

public class FeedbackMail extends Mail{
    String m_message;

    User m_user;

    public FeedbackMail(String message, User user){
        m_message=message;
        m_user=user;
    }

    public String getMessage() {
        return m_message;
    }

    public void setMessage(String m_message) {
        this.m_message = m_message;
    }

    public User getUser() {
        return m_user;
    }

    public void setUser(User m_user) {
        this.m_user = m_user;
    }
	
}

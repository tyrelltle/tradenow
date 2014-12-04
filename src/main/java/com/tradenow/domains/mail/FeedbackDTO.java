package com.tradenow.domains.mail;

import com.tradenow.domains.user.User;

public class FeedbackDTO extends Mail{
    String message;

    public FeedbackDTO(){}

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

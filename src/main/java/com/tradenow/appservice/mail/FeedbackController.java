package com.tradenow.appservice.mail;
import com.tradenow.domains.mail.FeedbackDTO;
import com.tradenow.domains.mail.FeedbackMail;
import com.tradenow.domains.mail.FeedbackMailer;
import com.tradenow.repository.mail.IMailRepository;
import com.tradenow.services.user.IUserService;
import com.tradenow.shared.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/api/feedback")
public class FeedbackController {

	    @Autowired
	    private IUserService userService;

        @Autowired
        FeedbackMailer feedbackMailer;

        @Autowired
        IMailRepository mailRepository;
	    
		@RequestMapping(method = RequestMethod.POST, produces="application/json")
		public @ResponseBody ResponseDTO newfeedback(@RequestBody FeedbackDTO dto,HttpServletRequest req, HttpServletResponse resp) throws IOException {
            try {
                FeedbackMail feedback = new FeedbackMail(dto.getMessage(), userService.currentUser());
                feedback.setMailSubject("TradeNow - New feedback from user!");
                feedbackMailer.sendMailAdmin(feedback);
            }catch(Exception e){
                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
                return new ResponseDTO(ResponseDTO.FAIL,e.getMessage());
            }
            return new ResponseDTO(ResponseDTO.SUCCESS,"");
        }
	    

}

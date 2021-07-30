package com.beta.replyservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.beta.rules.RuleExecutor;

@RestController
public class ReplyController {
    @GetMapping("/reply")
    public Message replying() {
	return new ErrorMessage("Message is empty");
    }

    /**
     * Accepts a message that will be processed depending on the rule provided. The
     * response of this service follows the procedure of the rule.
     * 
     * @param rule
     *                    a 2-digit rule that will be used to process the message
     * @param message
     *                    the message to be processed
     * @return the result of the processed message according to the rule
     */
    @GetMapping("/reply/{rule}-{message}")
    public Message replying(@PathVariable String rule, @PathVariable String message) {
	try {
	    return new ReplyMessage(RuleExecutor.execute(rule, message));
	} catch (Exception exception) {
	    return new ErrorMessage(exception.getMessage());
	}
    }
}
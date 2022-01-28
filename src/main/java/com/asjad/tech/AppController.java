package com.asjad.tech;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class AppController {
	public static final Logger LOGGER = LoggerFactory.getLogger(AppController.class);
	@RequestMapping({"/"})
	public String loadUI() {
        LOGGER.info("loading UI");
		return "forward:/index.html";
	}

}

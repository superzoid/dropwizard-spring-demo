package com.project.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class NameReversalService {

    @Autowired
    public NameReversalService(@Value("${rocketName}") String rocketName) {
        log.info("rocketName={}", rocketName);
    }


    public String reverse(String string) {
        return new StringBuffer(
                string)
                .reverse()
                .toString();
    }
}

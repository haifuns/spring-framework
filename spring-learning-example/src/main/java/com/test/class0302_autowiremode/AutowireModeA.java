package com.test.class0302_autowiremode;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author haifuns
 * @date 2024/9/11 21:40
 */
@Slf4j
@Component
public class AutowireModeA {

    public AutowireModeA() {
        log.debug("autoModelA default construct");
    }

    public AutowireModeA(AutowireModeB autowireModeB) {
        log.debug("autoModelA construct from autoModelB");
    }

    public AutowireModeA(AutowireModeC autowireModeC) {
        log.debug("construct from autoModelC");
    }

//    public AutoModelA(AutoModelB autoModelB, AutoModelC autoModelC) {
//        log.debug("construct from autoModelB + autoModelC");
//    }
}

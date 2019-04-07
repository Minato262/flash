package org.flashframework.aop.annotation;

import lombok.Getter;

@Getter
public enum AopAnno {
    AFTER(),
    AFTER_RETURNING(),
    AFTER_THROWING(),
    AROUND(),
    ASPECT(),
    BEFORE(),
    POINTCUT();

    AopAnno() {
        //
    }
}

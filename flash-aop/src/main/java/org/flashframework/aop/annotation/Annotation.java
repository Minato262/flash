package org.flashframework.aop.annotation;

import lombok.Getter;

@Getter
public enum Annotation {
    AFTER(),
    AFTER_RETURNING(),
    AFTER_THROWING(),
    AROUND(),
    ASPECT(),
    BEFORE(),
    POINTCUT();

    Annotation() {
        //
    }
}

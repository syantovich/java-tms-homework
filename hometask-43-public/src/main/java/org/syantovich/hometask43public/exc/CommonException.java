package org.syantovich.hometask43public.exc;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CommonException extends RuntimeException {
    private Integer code;
    private String msg;
}

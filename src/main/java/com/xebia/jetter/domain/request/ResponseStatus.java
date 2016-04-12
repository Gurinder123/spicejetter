package com.xebia.jetter.domain.request;

import com.xebia.jetter.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by gurinder on 12/4/16.
 */
@Getter
@Setter
@AllArgsConstructor
public class ResponseStatus {
    private String message;
    private Status status;
}

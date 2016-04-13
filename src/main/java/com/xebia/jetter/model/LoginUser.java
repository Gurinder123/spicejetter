package com.xebia.jetter.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created with IntelliJ IDEA.
 * User: HJAIN
 * Date: 4/8/16
 * Time: 9:50 PM
 * To change this template use File | Settings | File Templates.
 */


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class LoginUser {

    private String username;

    private String password;
}
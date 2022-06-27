package com.techlead.user.valueobjects;

import com.techlead.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateValueObject {

    private User user;
    private Department department;
}

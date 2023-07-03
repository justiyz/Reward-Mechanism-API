package com.poprev.service.response;

import com.poprev.data.model.user.PoprevUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private List<PoprevUser> users;
    private int totalNumberOfUsers;
}

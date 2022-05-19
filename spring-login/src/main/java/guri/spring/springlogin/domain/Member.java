package guri.spring.springlogin.domain;

import lombok.Data;
import lombok.NonNull;

@Data
public class Member {
    private Long id;

    @NonNull
    private String loginId;
    @NonNull
    private String name;
    @NonNull
    private String password;
}

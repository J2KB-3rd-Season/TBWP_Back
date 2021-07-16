package org.j2kb.tbwp.domain.entity;

import lombok.*;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table
public class User { // 사용자
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long userNo; // 고유번호

    String userName; // 이름

    String userId; // 아이디

    String userPw; // 비밀번호

    String email; // 이메일

    String division; // 부서

    Boolean autowire; // 권한


}

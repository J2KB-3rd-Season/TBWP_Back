package org.j2kb.tbwp.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.Local;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table
public class Template { // 템플릿
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long TemplateNo; // 고유 번호

    private String content; // 내용

    private String path; // 파일 위치

    private String fileName; // 변환된 파일명

    private String extension; // 확장자

    private String font; // 폰트

    @CreationTimestamp
    private LocalDateTime regDate; // 작성일자

    @UpdateTimestamp
    private LocalDateTime modDate; // 수정일자

}

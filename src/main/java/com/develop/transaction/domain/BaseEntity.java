package com.develop.transaction.domain;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/**
 * 상속을 통해 칼럼 정보를 제공하는 역할을 할 뿐 @MappedSuperClass 활용
 * JPA CUD가 일어날 때 자동으로 생성해주기 위해 @EntityListeners 사용
 *
 * 궁극적으로 BaseEntity 는 인스터스 해서 독립적으로 쓸 이유가 없기 때문에 abstract로 설정
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;
}

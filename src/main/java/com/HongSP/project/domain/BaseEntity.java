package com.HongSP.project.domain;

import jakarta.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;

@Getter
@MappedSuperclass
public class BaseEntity {
    @CreatedDate
    private LocalDateTime createdDate;
}

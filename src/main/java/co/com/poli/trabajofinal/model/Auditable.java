package co.com.poli.trabajofinal.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Auditable<U> {

    @Getter
    @Setter
    @CreatedBy
    @Column(name = "created_by", updatable = false)
    private U createdBy;

    @Getter
    @Setter
    @CreatedDate
    @Column(name = "created_date", updatable = false)
    private Date createdDate;

    @Getter
    @Setter
    @LastModifiedBy
    @Column(name = "last_modify_by")
    private U lastModifiedBy;

    @Getter
    @Setter
    @LastModifiedDate
    @Column(name = "last_modified_date")
    private Date lastModifiedDate;

}

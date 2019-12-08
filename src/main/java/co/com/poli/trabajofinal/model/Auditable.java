package co.com.poli.trabajofinal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable implements Serializable {

    @Getter
    @Setter
    @CreatedDate
    @Column(name = "created_date", updatable = false)
    @JsonIgnore
    private Date createdDate;

    @Getter
    @Setter
    @LastModifiedDate
    @Column(name = "last_modified_date")
    @JsonIgnore
    private Date lastModifiedDate;

}

package group6.ecommerce.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.catalina.User;

@Entity
@Data
@Getter
@Setter
public class Apply {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column (name = "ApplyId")
    private int Id;
    @ManyToOne
    @JoinColumn (name = "UserId")
    private Users userApply;
    @ManyToOne
    @JoinColumn (name = "JobId")
    private Job JobApply;

    public Apply() {
    }

    public Apply(int id, Users userApply, Job jobApply) {
        Id = id;
        this.userApply = userApply;
        JobApply = jobApply;
    }
}

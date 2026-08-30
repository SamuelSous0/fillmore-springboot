package com.example.fillmore.model;

// import com.fasterxml.jackson.annotation.JsonIgnore;
// import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.ManyToOne;
// import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
// import lombok.ToString;

// import java.util.ArrayList;
// import java.util.List;

@Entity
@Table(name = "routes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

    // TODO: descomentar quando Driver for adicionado ao projeto
    // @ManyToOne
    // @JoinColumn(name = "driver_id", nullable = false)
    // private Driver driver;

    // TODO: descomentar quando Student for adicionado ao projeto
    // @OneToMany(mappedBy = "route", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    // @Builder.Default
    // @ToString.Exclude
    // @JsonIgnore
    // private List<Student> students = new ArrayList<>();
}

package org.treguluvcource.hibernate_many_to_many.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "children")
public class Child {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String furstName;

    @Column(name = "age")
    private int age;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "child_section",
            joinColumns = @JoinColumn(name = "child_id"), //связь нашего класса с таблицей связей
            inverseJoinColumns = @JoinColumn(name = "section_id") // связь другой таблицы с таблицей связей
    )
    private List<Section> sections;

    public Child() {
    }

    public Child(String furstName, int age) {
        this.furstName = furstName;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFurstName() {
        return furstName;
    }

    public void setFurstName(String furstName) {
        this.furstName = furstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    public void addSectionToChild(Section section) {
        if (sections == null){
            sections = new ArrayList<>();
        }
        sections.add(section);
    }

    @Override
    public String toString() {
        return "Child{" +
                "id=" + id +
                ", furstName='" + furstName + '\'' +
                ", age=" + age +
                '}';
    }
}

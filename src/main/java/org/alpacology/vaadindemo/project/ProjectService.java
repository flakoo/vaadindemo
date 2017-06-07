package org.alpacology.vaadindemo.project;

import com.google.common.collect.Lists;

import java.util.List;

public class ProjectService {

    private static List<Project> projects;
    static {
        projects = Lists.newArrayList(
                Project.builder()
                        .id(2)
                        .name("Brownstar")
                        .build(),
                Project.builder()
                        .id(5)
                        .name("Iscan")
                        .build(),
                Project.builder()
                        .id(11)
                        .name("AviaCook")
                        .build(),
                Project.builder()
                        .id(19)
                        .name("Not Touch")
                        .build()
        );
    }

    public List<Project> getProjects() {
        return projects;
    }
}

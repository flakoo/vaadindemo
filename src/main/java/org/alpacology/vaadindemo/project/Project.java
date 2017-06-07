package org.alpacology.vaadindemo.project;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Project {

    private Integer id;

    private String name;

}

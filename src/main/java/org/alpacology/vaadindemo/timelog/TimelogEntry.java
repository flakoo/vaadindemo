package org.alpacology.vaadindemo.timelog;



import lombok.Builder;
import lombok.Data;
import org.alpacology.vaadindemo.category.Category;
import org.alpacology.vaadindemo.project.Project;

import java.time.LocalDate;

@Data
@Builder
public class TimelogEntry {
    private Integer id;

    private Project project;

    private Category category;

    private LocalDate day = LocalDate.now();

    private Double hourCount;
}

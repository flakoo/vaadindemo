package org.alpacology.vaadindemo.timelog;


import org.alpacology.vaadindemo.category.CategoryService;
import org.alpacology.vaadindemo.project.ProjectService;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class TimelogEntryService {


    private static Map<Integer, TimelogEntry> entries = new HashMap<>();

    static {
        CategoryService categoryService = new CategoryService();
        ProjectService projectService = new ProjectService();
        entries.put(
                1,
                TimelogEntry.builder()
                        .id(1)
                        .category(categoryService.getCategories().get(2))
                        .day(LocalDate.now().minusDays(2))
                        .hourCount(7.0)
                        .project(projectService.getProjects().get(0))
                        .build()
        );
        entries.put(
                3,
                TimelogEntry.builder()
                        .id(3)
                        .category(categoryService.getCategories().get(1))
                        .day(LocalDate.now().minusDays(2))
                        .hourCount(1.0)
                        .project(projectService.getProjects().get(2))
                        .build()
        );
    }

    public List<TimelogEntry> getTimelogEntriesAsList() {
        return entries.values().stream().collect(Collectors.toList());
    }

    public void saveTimelogEntry(TimelogEntry timelogEntry) {
        if (timelogEntry.getId() == null) {
            timelogEntry.setId(new Random().nextInt() + 100);
        }
        entries.put(timelogEntry.getId(), timelogEntry);
    }

    public void remove(TimelogEntry timelogEntry) {
        entries.remove(timelogEntry.getId());
    }
}

